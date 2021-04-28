package com.wxj.codebaselearn.activemq;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/4/28 0028 15:33
 */
// 持久化topic 的消息生产者
public class JmsProduce_persistence {

    public static final String ACTIVEMQ_URL = "tcp://192.168.181.128:61617";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws  Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer messageProducer = session.createProducer(topic);

        // 设置持久化topic
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 设置持久化topic之后再，启动连接
        connection.start();

        Map<Integer, Object> map = new HashMap<>();

        for (int i = 1; i < 4 ; i++) {

            map.put(i,"a"+i);
            String s = JSON.toJSONString(map);
            TextMessage textMessage = session.createTextMessage(s  + i);
            messageProducer.send(textMessage);
            MapMessage mapMessage = session.createMapMessage();
        }
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("  **** TOPIC_NAME消息发送到MQ完成 ****");
    }
}
