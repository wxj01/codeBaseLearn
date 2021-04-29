package com.wxj.codebaselearn.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/4/28 0028 19:38
 */
@RestController
public class GoodController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static final String REDIS_LOCK = "REDIS_LOCK";


    @GetMapping("/buy_goods")
    public String buyGoods(){
        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();



        // set key value ex px nx|xx   解决setnx +expire 不是原子性问题

        try{
            Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);

            if(!aBoolean){
                return "抢锁失败";
            }

            String s = stringRedisTemplate.opsForValue().get("good:001");
            int goodsNum = s == null ? 0 : Integer.parseInt(s);

            if(goodsNum > 0){
                int realNum = goodsNum - 1;
                stringRedisTemplate.opsForValue().set("good:001",String.valueOf(realNum));
                System.out.println("成功买到商品，库存剩下："+realNum+" 件" +"服务端口号："+serverPort);
                return "成功买到商品，库存剩下："+realNum+" 件" +"服务端口号："+serverPort;
            }else {
                System.out.println("商品已经售完/活动结束/调用超时，欢迎下次光临 " +"\t 服务端口号：" + serverPort );
            }
            return "商品已经售完/活动结束/调用超时，欢迎下次光临 " +"\t 服务端口号：" + serverPort;
        }finally {
            // del REDIS_LOCK
//            stringRedisTemplate.delete(REDIS_LOCK);  删锁不安全，
            // 用lua 脚本
//             redis 事务  通过 watch  和 mutli  来完成

            while (true){
                stringRedisTemplate.watch(REDIS_LOCK);
                // 判断锁是不是 当前线程持有的那把
                if(stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)){
                    stringRedisTemplate.multi(); // 开启事务
                    stringRedisTemplate.delete(REDIS_LOCK);
                    List<Object> list = stringRedisTemplate.exec();

                    // list 不为空，就一直 循环，乐观锁
                    if(list != null){
                        continue;
                    }
                }
                stringRedisTemplate.unwatch();
                break;
            }
        }
    }

}