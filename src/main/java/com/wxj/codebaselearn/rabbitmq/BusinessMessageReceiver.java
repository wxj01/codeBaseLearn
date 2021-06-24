//package com.wxj.codebaselearn.rabbitmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * @author wxj
// * @version 1.0
// * @description: TODO 业务队列的消费
// * @date 2021/5/10 0010 15:16
// */
//@Slf4j
//@Component
//public class BusinessMessageReceiver {
//
//    @RabbitListener(queues = BUSINESS_QUEUEA_NAME)
//    public void receiveA(Message message, Channel channel) throws IOException {
//        String msg = new String(message.getBody());
//        log.info("收到业务消息A：{}", msg);
//        boolean ack = true;
//        Exception exception = null;
//        try {
//            if (msg.contains("deadletter")){
//                throw new RuntimeException("dead letter exception");
//            }
//        } catch (Exception e){
//            ack = false;
//            exception = e;
//        }
//        if (!ack){
//            log.error("消息消费发生异常，error msg:{}", exception.getMessage(), exception);
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
//        } else {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        }
//    }
//
//    @RabbitListener(queues = BUSINESS_QUEUEB_NAME)
//    public void receiveB(Message message, Channel channel) throws IOException {
//        System.out.println("收到业务消息B：" + new String(message.getBody()));
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    }
//}