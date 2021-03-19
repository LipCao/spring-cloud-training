package com.lip.training.util;

import cn.hutool.core.thread.ThreadUtil;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * *****************************************************************************************
 *
 * @ClassName OrderReceive
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/7/21 00:53
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       00:532/7/21     cjc                       初版
 * ******************************************************************************************
 */
@Component
@Slf4j
public class OrderReceive {

    @RabbitListener(queues = "#{orderQueue.name}")
    public void receive(String orderJson){
        StopWatch watch = new StopWatch();
        watch.start("接受订单创建信息");
        log.info("instance: {}",orderJson);
        //模拟创建订单
        doWork(orderJson);
        //Order order = (Order) JSONUtil.toBean(orderJson, Order.class, true);
        watch.stop();
        log.info(watch.prettyPrint());
    }

    private void doWork(String in){
        log.info("创建订单信息：{}",in);
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
