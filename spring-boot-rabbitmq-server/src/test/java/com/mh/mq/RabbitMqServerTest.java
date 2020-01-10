package com.mh.mq;

import com.mh.mq.callback.CallBackSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.mq
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/2 15:17
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqServerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private CallBackSender callBackSender;

    @Test
    public void sendTopic() {
        rabbitTemplate.convertAndSend("topic_Exchange", "second.queue.test", "topic message");
    }

    @Test
    public void sendFanout() {
        rabbitTemplate.convertAndSend("fanout_Exchange", "","fanout message");
    }

    @Test
    public void callBackSend() {
        callBackSender.send();
    }

}
