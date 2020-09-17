package com.hofey.dwy.demo.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: hofey
 * @Date: 2020/9/14 14:31
 * @Description: 账户消息监听器
 */
@Slf4j
@Component
public class AccountMsgListener {

    /**
     * @Author: hofey
     * @Date: 2020/9/15 9:52
     * @Description: 接受用户注册消息
     * @Param
     */
    //使用JmsListener配置消费者监听的队列，其中Message是接收到的消息
    @JmsListener(destination = "user.reg.topic",containerFactory = "topicListenerFactory")
    public void receiveUserRegTopic(String message) {
        log.info("[账户消息监听器] ## msg -> {}",message);
    /*    if(StringUtils.isNotEmpty(message)){
            User  user = JSONObject.parseObject(message,User.class);
            if(user == null){
                log.error("[账户消息监听器] ## 消息内容解析错误");
                return;
            }
            try {
                accPersonalService.createAccount(user.getId(),1);
            } catch (SaasException e) {
                log.error("[账户消息监听器] ## 账户创建错误");
                e.printStackTrace();

            }
        }else {
            log.error("[账户消息监听器] ## 消息内容为空");
        }
            */
    }
}
