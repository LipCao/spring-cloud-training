package com.lip.training.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * *****************************************************************************************
 *
 * @ClassName OrderSender
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/5/21 18:36
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       18:362/5/21     cjc                       初版
 * ******************************************************************************************
 */
@Slf4j
public class OrderSender {
    @Autowired
    private RabbitTemplate template;

    private static final String exchangeName = "test";

    private final String key = "order-queue";

    public void send(String orderNo){
        CorrelationData correlationData = null;
        correlationData = new CorrelationData(orderNo);
        log.info("发起生成订单请求 ：id:'{}' send '{}'",correlationData.getId(),orderNo);
        template.convertAndSend(exchangeName,key,orderNo,correlationData);
    }
}
