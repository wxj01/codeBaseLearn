package com.wxj.codebaselearn.ms;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 *
 * unable to create new native thread
 *
 * @date 2021/4/25 0025 11:16
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i = 1; ; i++){
            System.out.println("***************  i = " + i);

            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },""+i).start();
        }
    }
}
//
//结果：
//        Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread