package com.wxj.codebaselearn.pool;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/5/13 0013 9:58
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {
    public static void main(String[] args) {
        // �����̳߳�
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3));
        // ���̳߳��ύ����
//        for (int i = 0; i < threadPool.getCorePoolSize(); i++) {
        for (int i = 1; i < 11; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int x = 0; x < 2; x++) {
                        System.out.println(Thread.currentThread().getName() + ":" + x);
                        try {
//                            Thread.sleep(2000);
                            Thread.sleep(Integer.MAX_VALUE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        // �ر��̳߳�
        threadPool.shutdown(); // �����̳߳ص�״̬ΪSHUTDOWN��Ȼ���ж�����û������ִ��������߳�
        // threadPool.shutdownNow(); // �����̳߳ص�״̬ΪSTOP��Ȼ����ֹͣ���е�����ִ�л���ͣ������̣߳������صȴ�ִ��������б��÷���Ҫ���ã�������ɲ��ɿصĺ��
    }
}
