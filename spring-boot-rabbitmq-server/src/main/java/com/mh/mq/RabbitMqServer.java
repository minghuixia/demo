package com.mh.mq;

import cn.hutool.core.lang.Dict;
import com.mh.mq.config.RabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.mq
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2019/12/26 16:54
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@SpringBootApplication
@RestController
public class RabbitMqServer {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqServer.class, args);
    }

    @Autowired
    private RabbitmqConfig rabbitmqConfig;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/print")
    public Dict print(){
        return Dict.create().set("rabbitmqconfig", rabbitmqConfig);
    }

    @RequestMapping("/send1")
    public Dict send1(){
        String msg = "send1";
        amqpTemplate.convertAndSend("first_Queue", msg);
        return Dict.create().set("msg", "send1");
    }

    @RequestMapping("/send2")
    public Dict send2(){
        String msg = "send2";
        amqpTemplate.convertAndSend("second_Queue","second.queue.test", msg);
        return Dict.create().set("msg", "send2");
    }

}
