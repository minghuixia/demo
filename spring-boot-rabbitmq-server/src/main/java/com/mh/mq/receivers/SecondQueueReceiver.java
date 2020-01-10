package com.mh.mq.receivers;

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
 * @date: Created in 2020/1/2 15:00
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Component
@Slf4j
@RabbitListener(queues = "second_Queue")
public class SecondQueueReceiver {

    @RabbitHandler
    public void topicHandlerManualAck(String msg, Message message, Channel channel) {
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("topic队列【second_Queue】处理器，手动ack，接收消息：{}", msg);
            //消息消费完成，可以ACK了
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            // 处理失败,重新压入MQ
            try {
                channel.basicRecover();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
