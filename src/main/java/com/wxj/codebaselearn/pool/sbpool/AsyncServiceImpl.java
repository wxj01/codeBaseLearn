package com.wxj.codebaselearn.pool.sbpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 学习 https://mp.weixin.qq.com/s/QWXakOdwdSg-Qde6TE7Q9Q
 *
 * 将Service层的服务异步化，在executeAsync()方法上增加注解@Async("asyncServiceExecutor")，
 *  asyncServiceExecutor方法是前面ExecutorConfig.java中的方法名，
 *  表明executeAsync方法进入的线程池是asyncServiceExecutor方法创建的
 *
 * @date 2021/8/13 0013 11:05
 */
@Service
public class AsyncServiceImpl implements AsyncService{

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {

        logger.info("start executeAsync");

        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");

        logger.info("end executeAsync");
    }
}