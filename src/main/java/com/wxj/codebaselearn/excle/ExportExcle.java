//package com.wxj.codebaselearn.excle;
//
//import net.sf.jxls.transformer.XLSTransformer;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.*;
//import java.util.Map;
//
///**
// * @author wxj
// * @version 1.0
// * @description: TODO  spring boot 项目 下载Excle 的 window 是正常的，部署服务器就下载不了 找不到文件
// *
// *      记录一下主要的方法， 遇到第二次了。springboot linux 下导出文件，找不到 ，重复解决一个问题 费时费力 真是糟糕
// *
// * @date 2021/8/6 0006 13:52
// */
//public class ExportExcle {
//
//    public static boolean genFile(Map<String, Object> map, String tempFile,
//                                  String outFile, HttpServletRequest request) {
//        try {
//            // window 下的 获取路径的方法，excle 模板放在 /WEB-INF/template/
////			tempFile=  request.getRealPath("/WEB-INF/template/"+tempFile);
//
//
//            //linux 下的  获取路径的方法，excle 模板放在 resource/template/ 下面
//            ClassPathResource classPathResource = new ClassPathResource("/template/"+tempFile);
//
//            String outFilePath=request.getRealPath("/outFileXls");
//            File xlsDir = new File(outFilePath);
//            if (!xlsDir.exists()) {
//                xlsDir.mkdirs();
//            }
//            outFile = outFilePath+"/"+outFile;
//            XLSTransformer transformer = new XLSTransformer();
//            transformXLS(transformer,classPathResource.getInputStream(), map,outFile);
////			transformer.transformXLS(path,map,outFilePath);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static   void transformXLS(XLSTransformer transformer, InputStream is, Map beanParams, String destFilePath) throws Exception {
//        org.apache.poi.ss.usermodel.Workbook workbook = transformer.transformXLS(is, beanParams);
//        OutputStream os = new BufferedOutputStream(new FileOutputStream(destFilePath));
//        workbook.write(os);
//        is.close();
//        os.flush();
//        os.close();
//    }
//}