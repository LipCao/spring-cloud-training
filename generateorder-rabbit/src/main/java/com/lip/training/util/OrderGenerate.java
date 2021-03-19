package com.lip.training.util;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.lip.training.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * *****************************************************************************************
 *
 * @ClassName OrderGenerate
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/6/21 23:39
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       23:392/6/21     cjc                       初版
 * ******************************************************************************************
 */
@Slf4j
public class OrderGenerate {

    @RabbitListener(queues = "order-queue")
    public void receiveOrderInfo(String orderJson){
        receive(orderJson);
    }

    private void receive(String orderJson){
        StopWatch watch = new StopWatch();
        watch.start("接受订单创建信息");
        log.debug("instance: {}",orderJson);
        //模拟创建订单
        doWork(orderJson);
        //Order order = (Order) JSONUtil.toBean(orderJson, Order.class, true);
        watch.stop();
        log.info(watch.prettyPrint());
    }

    private void doWork(String in){
        log.debug("创建订单信息：{}",in);
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
