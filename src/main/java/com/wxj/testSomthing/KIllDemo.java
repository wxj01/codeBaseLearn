package com.wxj.testSomthing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName KIllDemo.java
 * @Description TODO 学习海哥视频
 *  用户请求过来了怎么进行合并，合并完后怎么通知用户
 * @createTime 2022年05月28日 17:26:00
 */
@Slf4j
public class KIllDemo {

    // 模拟数据库10条数据
    private  Integer stock = 10;

    private BlockingQueue<RequestPromise> queue = new LinkedBlockingQueue(10);

    private Object lock = new Object();

    /**
     * 启动 10个线程
     * 库存 6个
     * 生成一个合并对列
     * 每个用户能拿到自己的请求响应
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        KIllDemo kIllDemo = new KIllDemo();
        kIllDemo.mergeJob();

        TimeUnit.MILLISECONDS.sleep(200);


        List<Future<CommonResult>> list = new ArrayList(10);


        for (int i = 0 ; i < 10; i++){
            final long orderId = 100L+i;
            final Long userId = Long.valueOf(i);

            Future<CommonResult> future = executorService.submit(() -> {
                return kIllDemo.operate(new UserRequest(orderId,userId , 1));
            });
            list.add(future);
        }

        list.forEach(e ->{
            CommonResult commonResult = null;
            try {
                commonResult = e.get(300, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + ":客户端请求响应:" + commonResult);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException executionException) {
                executionException.printStackTrace();
            } catch (TimeoutException timeoutException) {
                timeoutException.printStackTrace();
            }

        });
    }

    /**
     *  用户请求入列
     * @param userRequest
     * @return
     */
    public CommonResult operate(UserRequest userRequest) throws InterruptedException {
        // todo  阈值判断
        // todo  对列的创建
        RequestPromise requestPromise = new RequestPromise(userRequest);
        boolean offer = queue.offer(requestPromise, 100, TimeUnit.MILLISECONDS);
        //如果放入对列失败
        if(!offer){
            return new CommonResult(false,"对列已满，请稍后再试");
        }
//        synchronized (lock){
//            lock.wait(200);
//
//        }
        return requestPromise.getCommonResult();
    }

    /**
     *  这里单程线程处理 合并请求
     */
    public void mergeJob(){
        new Thread(() -> {
            List<RequestPromise> list = new ArrayList<>();
            while (true) {
                // 对列中没有用户发过来的请求，
                if (queue.isEmpty()){
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    //java.lang.NullPointerException
                    RequestPromise requestPromise = queue.poll(200, TimeUnit.MILLISECONDS);
                    list.add(requestPromise);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":合并扣减库存:" + list);
                int sum = list.stream().mapToInt(e -> e.getUserRequest().getCount()).sum();
                /*
                  两种情况:1. 用户请求下单量 <= 库存
                          2. 用户请求下单量 >= 库存
                 */

                if (sum <= stock){
                    stock -= sum;
                    //通知用户
                    list.forEach(requestPromise -> {
                        requestPromise.setCommonResult(new CommonResult(true, "ok"));
                    });
                    continue;
                }


                list.forEach(e ->{
                    int count = e.getUserRequest().getCount();
                    if (count <= stock){
                        stock -=  count;
                        e.setCommonResult(new CommonResult(true, "ok"));
                    }else {
                        e.setCommonResult(new CommonResult(false, "库存不足"));
                    }

                });
                list.clear();
            }
        },"处理合并请求的线程^_^").start();
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class RequestPromise{
    private UserRequest userRequest;
    private CommonResult commonResult;

    public RequestPromise(UserRequest userRequest) {
        this.userRequest = userRequest;
    }
}

/**
 *  返回结果
 */
@Data
@AllArgsConstructor
class CommonResult{
    private boolean success;
    private String msg;
}

@Data
@AllArgsConstructor
class UserRequest{
    private Long orderId;
    private Long userId;
    private Integer count; // 用户购买商品的数量
}
