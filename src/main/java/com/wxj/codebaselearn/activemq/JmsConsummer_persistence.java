package com.wxj.codebaselearn.activemq;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/4/28 0028 15:45
 */
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

// 持久化topic 的消息消费者
public class JmsConsummer_persistence {
    public static final String ACTIVEMQ_URL = "tcp://192.168.181.128:61617";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        // 设置客户端ID。向MQ服务器注册自己的名称
        connection.setClientID("marrry");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建一个topic订阅者对象。一参是topic，二参是订阅者名称
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"remark...");
        // 之后再开启连接
        connection.start();
        Message message = topicSubscriber.receive();
        while (null != message){
            TextMessage textMessage = (TextMessage)message;
            System.out.println(" 收到的持久化 topic ："+textMessage.getText());
            message = topicSubscriber.receive();
        }
        session.close();
        connection.close();
    }
}
