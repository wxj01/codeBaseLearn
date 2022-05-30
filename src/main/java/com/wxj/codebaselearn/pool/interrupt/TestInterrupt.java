package com.wxj.codebaselearn.pool.interrupt;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName TestInterrupt.java
 * @Description TODO
 * @createTime 2022年03月15日 21:29:00
 */
@Slf4j
public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination termination = new TwoPhaseTermination();
        log.debug("开始启动");
        termination.start();

        TimeUnit.SECONDS.sleep(3);
        log.debug("开始结束");
        termination.stop();
    }

    @Test
    public void test() throws InterruptedException {
        TwoPhaseTermination termination = new TwoPhaseTermination();
        log.debug("开始启动");
        termination.start();

        TimeUnit.MILLISECONDS.sleep(3500);
        log.debug("开始结束");
        termination.stop();
    }

}

@Slf4j(topic = "c.TwoPhaseTermination")
class  TwoPhaseTermination{

    private Thread monitor;

    public void start(){

        monitor  = new Thread(()->{
            while (true){
                System.out.println("0000000");
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()){
                    log.debug("线程被打断");
                    System.out.println("11111");
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    log.debug("执行监控记录");
                    System.out.println("2222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记
                    thread.interrupt();
                }
            }

        });


    }

    public void stop(){
        log.debug("调用interrupt");
        monitor.interrupt();
    }
}
