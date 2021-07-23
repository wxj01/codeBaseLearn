package com.wxj.codebaselearn.pool.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/23 0023 10:38
 */
public class JvmThread {

    public static void main(String[] args) {

        new Thread(()->{
            List<byte[]> list = new ArrayList<>();

            while (true){
                System.out.println(new Date().toString() + Thread.currentThread() + "=====" );

                byte[] bytes = new byte[1024 * 1024 * 1];

                list.add(bytes);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();



        // 线程二
        new Thread(()->{
            while (true){
                System.out.println(new Date().toString() + Thread.currentThread() + "^^^^^^");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}