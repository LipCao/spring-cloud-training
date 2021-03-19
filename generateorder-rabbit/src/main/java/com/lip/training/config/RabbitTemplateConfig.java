package com.lip.training.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * *****************************************************************************************
 *
 * @ClassName RabbitTemplateConfig
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/7/21 01:32
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       01:322/7/21     cjc                       初版
 * ******************************************************************************************
 */
@Component
@Slf4j
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitTemplate() {
        // 设置生产者消息确认
        rabbitTemplate.setConfirmCallback(this);

    }

    /**
     * 消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
     *
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean b, @Nullable String s) {
        log.error("ack：[{}]" , b);
        if (b) {
            String id = correlationData.getId();
            log.info("消息到达rabbitmq服务器 id:{}",id);
        } else {
            log.error("消息可能未到达rabbitmq服务器:{}",correlationData);
        }
    }
}
