package com.hofey.dwy.server.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: hofey
 * @Date: 2020/9/14 12:33
 * @Description: 消息配置类
 */
@Configuration
public class ActiveMqConfig {
    /**
     * @Author: hofey
     * @Date: 2020/9/14 19:11
     * @Description: 初始话用户注册主题
     * @Param
     */
    @Bean(name = "userRegTopic")
    public Topic userRegTopic() {
        return new ActiveMQTopic("user.reg.topic");
    }

    /**
     * @Author: hofey
     * @Date: 2020/9/16 19:29
     * @Description: 微信模板消息队列
     * @Param
     */
    @Bean(name = "wechatTemplateQueue")
    public Queue wechatTemplateQueue(){
        return new ActiveMQQueue("wechat.template.queue");
    }
    /**
     * 处理topic消息
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    /**
     * 处理queue消息
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
}
