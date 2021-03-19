package com.lip.training.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * *****************************************************************************************
 *
 * @ClassName OrderRabbitConfig
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/7/21 00:58
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       00:582/7/21     cjc                       初版
 * ******************************************************************************************
 */
@Configuration
public class OrderRabbitConfig {
    @Bean
    public DirectExchange orderExchange(){
        return  new DirectExchange("order.exchange");
    }

    @Bean
    public Queue orderQueue(){
        return new AnonymousQueue();
    }

    //绑定key 值到队列 1
    @Bean
    public Binding directBinding1a(DirectExchange orderExchange, Queue orderQueue) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("order");
    }
}
