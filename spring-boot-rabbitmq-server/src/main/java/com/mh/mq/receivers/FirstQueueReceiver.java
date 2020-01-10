package com.mh.mq.receivers;

import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.mq.receivers
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/2 14:19
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Component
@RabbitListener(queues = "first_Queue")
@Slf4j
public class FirstQueueReceiver {
    /**
     * 如果 spring.rabbitmq.listener.direct.acknowledge-mode: auto，则可以用这个方式，会自动ack
     */
//    @RabbitHandler
    public void directHandlerAutoAck(String msg) {
        log.info("直接队列【first_Queue】处理器，接收消息：{}", msg);
    }

    @RabbitHandler
    public void directHandlerManualAck(String msg, Message message, Channel channel) {
//  如果手动ACK,消息会被监听消费,但是消息在队列中依旧存在,如果 未配置 acknowledge-mode 默认是会在消费完毕后自动ACK掉
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("直接队列【first_Queue】处理器，手动ack，接收消息：{}", msg);
            // 通知 MQ 消息已被成功消费,可以ACK了
//            Long.parseLong("12sdfdsf");
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                // 处理失败,重新压入MQ
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
