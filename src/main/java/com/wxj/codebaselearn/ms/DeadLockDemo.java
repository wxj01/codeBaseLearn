package com.wxj.codebaselearn.ms;

import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 10.死锁编码及定位分析
 *
 * 程序运行后，先jps -l 查看进程号
 * 再 jstack 进程号
 * 查找对应死锁的行数
 *
 * @date 2021/4/23 0023 13:20
 */
class HoldThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockA + "尝试获得" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockB + "尝试获得" + lockA);
            }
        }
    }
}

/**
 * Description:
 * 死锁是指两个或者以上的进程在执行过程中,
 * 因争夺资源而造成的一种相互等待的现象,
 * 若无外力干涉那他们都将无法推进下去
 *
 * @author veliger@163.com
 * @date 2019-04-14 0:05
 **/
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldThread(lockA, lockB), "threadAAA").start();
        new Thread(new HoldThread(lockB, lockA), "threadBBB").start();
    }
}