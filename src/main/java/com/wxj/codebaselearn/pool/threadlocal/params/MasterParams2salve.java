package com.wxj.codebaselearn.pool.threadlocal.params;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName MasterParams2salve.java
 * @Description 子线程获取主线程的参数
 * @createTime 2022年05月30日 22:47:00
 */
@Slf4j
public class MasterParams2salve {

    @Test
    public void test(){


        new Thread(() ->{
            ThreadLocal<Object> pThreadLocal = new ThreadLocal<>();
            pThreadLocal.set(1);
            InheritableThreadLocal<Object> pInheritableThreadLocal = new InheritableThreadLocal<>();
            pInheritableThreadLocal.set(2);

            new Thread(( ()->{
                log.info("pThreadLocal:{}" + pThreadLocal.get());
                log.info("pInheritableThreadLocal:{}",pInheritableThreadLocal.get());
                System.out.println(pThreadLocal.get());
                System.out.println(pInheritableThreadLocal.get());

            }),"子线程").start();

        },"父线程").start();
    }

    @Test
    public void test2(){
        int a = 1;
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.set(2);
        new Thread(() -> {
            System.out.println(a);
            System.out.println(threadLocal.get());
        },"abc").start();
    }
}
