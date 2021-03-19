package com.lip.training.config;

import com.lip.training.util.OrderGenerate;
import com.lip.training.util.OrderSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * *****************************************************************************************
 *
 * @ClassName OrderRabbitMQConfig
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/5/21 18:23
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       18:232/5/21     cjc                       初版
 * ******************************************************************************************
 */
@Configuration
@Slf4j
public class OrderRabbitMQConfig {
    /**
     * 绑定key，交换机绑定队列时需要指定
     */
    public static final String BINGDING_KEY_TEST1 = "test";

    /**
     * 队列名称
     */
    public static final String QUEUE_TEST1 = "order-queue";

    @Bean
    public DirectExchange orderExchange(){
        // 支持持久化，长期不用不删除
        return  new DirectExchange(BINGDING_KEY_TEST1,true,false);
    }

    @Bean
    public Queue orderQueue(){
        // 支持持久化
        return new Queue(QUEUE_TEST1,true);
    }

    //绑定key 值到队列 1
    @Bean
    public Binding directBinding1a(DirectExchange orderExchange, Queue orderQueue) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("order-queue");
    }

    // 注入生产者
    @Bean
    public OrderSender orderSender(){
        return  new OrderSender();
    }

    //注入消费者
    @Bean
    public OrderGenerate orderGenerate(){
        return new OrderGenerate();
    }
}
