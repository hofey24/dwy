package com.hofey.dwy.demo.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: hofey
 * @Date: 2020/9/16 17:11
 * @Description: 生产者工具类
 */
@Slf4j
@Component
public class DdspActiveMqProducer {

    @Autowired
    private  JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * @Author: hofey
     * @Date: 2020/9/16 17:13
     * @Description:
     *    发送消息，destination是发送到的队列名称，message是待发送的消息
     *    Queue 点对点 发送
     * @Param
     */
    public  void sendMessage(Queue destination, String message){
        log.info("[发送消息] ## msg -> {}",message);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
    /**
     * @Author: hofey
     * @Date: 2020/9/16 17:13
     * @Description:
     *    发送消息，destination是发送到的队列名称，message是待发送的消息
     *    topic 广播式 发送 多个消费者接受
     * @Param
     */
    public  void sendMessage(Topic destination, String message){
        log.info("[发送消息] ## msg -> {}",message);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
    /**
     * @Author: hofey
     * @Date: 2020/9/16 17:13
     * @Description:
     *    发送消息，destination是发送到的队列名称，message是待发送的消息
     *    通用消息发送
     * @Param
     */
    public  void sendMessage(Destination destination, String message){
        log.info("[发送消息] ## msg -> {}",message);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    /**
     * @Author: hofey
     * @Date: 2020/9/16 17:26
     * @Description: 发送消息
     * @Param 队列名称
     */
    public  void sendQueMessage(String queueStr, String message){
        log.info("[发送消息] ## queueStr -> {} msg -> {}",queueStr,message);
        Destination destination = new ActiveMQQueue(queueStr);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    /**
     * @Author: hofey
     * @Date: 2020/9/16 17:26
     * @Description: 发送消息
     * @Param 主题名称
     */
    public  void sendTopicMessage(String topicStr, String message){
        log.info("[发送消息] ## topicStr -> {} msg -> {}",topicStr,message);
        Destination destination = new ActiveMQTopic(topicStr);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    /***
     * 消费者获取信息样例
     */
    // 使用JmsListener配置消费者监听的队列名称qingfeng.queue，其中text是接收到的消息
 /*   @JmsListener(destination = "s-queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的生产者的报文为:"+text);
    }*/

}
