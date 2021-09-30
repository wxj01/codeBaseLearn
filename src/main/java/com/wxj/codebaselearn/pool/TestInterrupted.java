package com.wxj.codebaselearn.pool;

import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 测试线程中断
 * @date 2021/9/30 0030 15:53
 */

public class TestInterrupted {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final String[] result = {""};
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> future =
                new FutureTask<String>(new Callable<String>() {//使用Callable接口作为构造参数
                    public String call() throws InterruptedException {
                        //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                        TimeUnit.SECONDS.sleep(3);
                        result[0] = "costTimeOut";
                        return result[0];
                    }});
        executor.execute(future);
        //在这里可以做别的任何事情
        try {
            result[0] = future.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
        } catch (InterruptedException e) {
            future.cancel(true);
            System.out.println("InterruptedException :"+"InterruptedException");
        } catch (ExecutionException e) {
            future.cancel(true);
            System.out.println("ExecutionException :"+"ExecutionException");
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("TimeoutException :"+ future.get());
        } finally {
            System.out.println("1111");
            executor.shutdown();
            System.out.println("22222");
        }

        System.out.println(future.get());
        System.out.println("xxxxxx");
    }
}
