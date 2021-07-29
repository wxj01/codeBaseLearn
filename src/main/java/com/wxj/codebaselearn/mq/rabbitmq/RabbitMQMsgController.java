//package com.wxj.codebaselearn.mq.rabbitmq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author wxj
// * @version 1.0
// * @description: TODO
// * @date 2021/5/10 0010 15:19
// */
//@RequestMapping("rabbitmq")
//@RestController
//public class RabbitMQMsgController {
//
//    @Autowired
//    private BusinessMessageSender sender;
//
//    @RequestMapping("sendmsg")
//    public void sendMsg(String msg){
//        sender.sendMsg(msg);
//    }
//}