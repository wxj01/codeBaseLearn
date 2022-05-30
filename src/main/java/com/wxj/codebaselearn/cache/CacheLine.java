package com.wxj.codebaselearn.cache;

import com.wxj.codebaselearn.spring.test.C;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName CacheLine.java
 * @Description TODO
 *  * 多核CPU多级缓存一致性协议MESI
 *  * 缓存一致性协议：同一个缓存行的数据被不同cpu读取的时候必须保持一致性
 * @createTime 2022年02月19日 19:37:00
 */
public class CacheLine {
    //volatile：保持线程之间的数据可见性，每次修改数据之后都会将数据从工作内存中刷新到主内存，然后强制线程从主内存中读取数据
    private static volatile long[] arr1 = new long[2];
    private static volatile long[] arr2 = new long[16];
    /**
     *
     * 缓存行 通常为64字节，每个long 8个字节，所以数组的两个对象存储在同一个缓存行中，会因为数据一致性的原因
     * 两个线程（假设两个线程分别运行在两个cup中）在改变数据后频繁进行相互通知，并重新从缓存行中读取，即通知另一个cpu缓存的缓存行状态为invalid，必须重新从主存中读取
     *
     * 耗时：4135
     * */
    @Test
    public void inOneLine() throws Exception{
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10_0000_0000L; i++) {
                arr1[0] = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10_0000_0000L; i++) {
                arr1[1] = i;
            }
            latch.countDown();
        });

        final long start =System.nanoTime();//返回纳秒
        //System.currentTimeMillis()：返回毫秒
        t1.start();
        t2.start();
        //thread.join()：主线程 会等待子线程执行完毕之后再执行
//        t1.join();
//        t2.join();
        latch.await();

        System.out.println((System.nanoTime() - start)/1000000);

    }
    /**
     * 缓存行 为64字节，每个long 8个字节，每个缓存行只能存8个long ,所以数组的两个对象分别存储在不同缓存行中，
     * 所以不会出现上面频繁修改缓存行的问题
     *
     * 耗时：2106
     * */
    @Test
    public void inDffLine() throws Exception{
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10_0000_0000L; i++) {
                arr2[0] = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10_0000_0000L; i++) {
                arr2[8] = i;
            }
            latch.countDown();
        });

        final long start =System.nanoTime();
        t1.start();
        t2.start();
//        thread.join()：主线程 会等待子线程执行完毕之后再执行
//        t1.join();
//        t2.join();
        latch.await();

        System.out.println((System.nanoTime() - start)/1000000);

    }
}
