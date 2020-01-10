package com.mh.mq.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.mq.config
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2019/12/26 16:56
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Slf4j
public class RabbitmqConfig {
    private String firstQueue;
    private String secondQueue;
    private String thirdlyQueue;
    private String fourthlyQueue;

    private String directExchange;
    private String topicExchange;
    private String fanoutExchange;

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause));
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
        return rabbitTemplate;
    }

    /*创建队列*/
    @Bean("firstQueue")
    public Queue createFirstQueue() {
        return new Queue(firstQueue);
    }

    @Bean("secondQueue")
    public Queue createSecondQueue() {
        return new Queue(secondQueue);
    }

    @Bean("thirdlyQueue")
    public Queue createThirdlyQueue() {
        return new Queue(thirdlyQueue);
    }

    @Bean("fourthlyQueue")
    public Queue createFourthlyQueue() {
        return new Queue(fourthlyQueue);
    }

    /*创建交换机*/
    @Bean("directExchange")
    public DirectExchange createDirectExchange() {
        return new DirectExchange(directExchange, true, false);
    }

    @Bean("topicExchange")
    public TopicExchange createTopicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean("fanoutExchange")
    public FanoutExchange createFanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    /*创建绑定关系 firstQueue binding to directExchanges routing key first.Queue */
    @Bean
    public Binding createDirectBinding(Queue firstQueue,DirectExchange directExchange){
        return BindingBuilder.bind(firstQueue).to(directExchange).with("first.queue");
    }

    /*创建绑定关系 secondQueue binding to topicExchange routing key second.queue.* */
    @Bean
    public Binding createTopicBinding(Queue secondQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(secondQueue).to(topicExchange).with("second.queue.*");
    }

    /*创建绑定关系 thirdlyQueue binding to fanoutExchange */
    @Bean
    public Binding createFanoutBinding(Queue thirdlyQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(thirdlyQueue).to(fanoutExchange);
    }

    /*创建绑定关系 fourthlyQueue binding to fanoutExchange*/
    @Bean
    public Binding createFanoutBinding1(Queue fourthlyQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fourthlyQueue).to(fanoutExchange);
    }



}
