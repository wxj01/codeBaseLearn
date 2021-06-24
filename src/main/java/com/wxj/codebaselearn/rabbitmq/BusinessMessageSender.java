//package com.wxj.codebaselearn.rabbitmq;
//
///**
// * @author wxj
// * @version 1.0
// * @description: TODO 消息生产者
// * @date 2021/5/10 0010 15:19
// */
//@Component
//public class BusinessMessageSender {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void sendMsg(String msg){
//        rabbitTemplate.convertSendAndReceive(BUSINESS_EXCHANGE_NAME, "", msg);
//    }
//}