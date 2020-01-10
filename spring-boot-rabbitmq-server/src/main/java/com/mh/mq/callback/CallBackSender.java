package com.mh.mq.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.mq.callback
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/2 16:37
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Component
@Slf4j
public class CallBackSender implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplatenew;

    public void send() {
        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        log.info(msg);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("topic_Exchange", "second.queue.callback", msg, correlationData);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("callback confirm: " + correlationData.getId());
    }
}
