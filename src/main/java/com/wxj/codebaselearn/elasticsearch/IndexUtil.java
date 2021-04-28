package com.wxj.codebaselearn.elasticsearch;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 *
 * elasticsearch 的 文件写入和搜索的工具类
 *
 * @date 2021/1/26 0026 15:41
 */
@Component
public class IndexUtil {

    //Lucene索引文件路径
    static String dir="E:\\lucence";
    //定义分词器
    static Analyzer analyzer = new IKAnalyzer();
    /**
     * 封裝一个方法，用于将数据库中的数据解析为一个个关键字词存储到索引文件中
     * @param doc
     */
    public static void write(Document doc){
        try {
            //索引库的存储目录
            Directory directory = FSDirectory.open(new File(dir));
            //关联当前lucence版本和分值器
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47, analyzer);
            //传入目录和分词器
            IndexWriter iwriter = new IndexWriter(directory, config);
            //写入到目录文件中
            iwriter.addDocument(doc);
            //提交事务
            iwriter.commit();
            //关闭流
            iwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //搜索
    public static List<Map<String,Object>> search(String field, String value) throws Exception{

        //索引库的存储目录
        Directory directory = FSDirectory.open(new File(dir));
        //读取索引库的存储目录
        DirectoryReader ireader = DirectoryReader.open(directory);
        //搜索类
        IndexSearcher isearcher = new IndexSearcher(ireader);

        //lucence查询解析器，用于指定查询的属性名和分词器
        QueryParser parser = new QueryParser(Version.LUCENE_47, field, analyzer);

        //搜索
        Query query = parser.parse(value);


        //最终被分词后添加的前缀和后缀处理器，默认是粗体<B></B>
        SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<font color=red>","</font>");
        //高亮搜索的词添加到高亮处理器中
        Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));

        //获取搜索的结果，指定返回document返回的个数
        ScoreDoc[] hits = isearcher.search(query, null, 5).scoreDocs;
        List<Map<String,Object>> list= new ArrayList<>();
        //遍历，输出
        for (int i = 0; i < hits.length; i++) {
            int id = hits[i].doc;
            Document hitDoc = isearcher.doc(hits[i].doc);
            Map map=new HashMap();


            map.put("tydm", hitDoc.get("tydm"));

            //获取到foodname

            String fieldName=hitDoc.get(field);
            //将查询的词和搜索词匹配，匹配到添加前缀和后缀
            TokenStream tokenStream = TokenSources.getAnyTokenStream(isearcher.getIndexReader(), id, field, analyzer);
            //传入的第二个参数是查询的值
            TextFragment[] frag = highlighter.getBestTextFragments(tokenStream, fieldName, false, 10);
            String fieldValue="";
            for (int j = 0; j < frag.length; j++) {
                if ((frag[j] != null) && (frag[j].getScore() > 0)) {
                    //获取 foodname 的值
                    fieldValue=((frag[j].toString()));
                }
            }
            map.put(field, fieldValue);
            map.put("legalper", hitDoc.get("legalper"));




            list.add(map);
        }
        ireader.close();
        directory.close();
        return list;
    }

    public static void main(String[] args) {
        // lucene 搜索
        try {
//            List<Map<String, Object>> search = IndexUtil.search(queryType.toLowerCase(), queryValue);
            List<Map<String, Object>> search = IndexUtil.search("queryType", "queryValue");
            search.forEach(searchMap ->{
                System.out.println("searchMap:"+searchMap.toString());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}