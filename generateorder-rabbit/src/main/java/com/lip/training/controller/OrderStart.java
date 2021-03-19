package com.lip.training.controller;

import cn.hutool.json.JSONUtil;
import com.lip.training.Order;
import com.lip.training.util.OrderSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * *****************************************************************************************
 *
 * @ClassName OrderStart
 * @Author: cjc
 * @Descripeion 客户下单
 * @Date： 2/4/21 11:36
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       11:362/4/21     cjc                       初版
 * ******************************************************************************************
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderStart {

    @Autowired
    private OrderSender orderSender;

    @GetMapping("/start")
    public String generateOrder(){
        //根据购物车信息下单
        String orderNo = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        Order order  = new Order();
        order.setOrderNo(orderNo);
        order.setState(1);
        order.setRemark(" 快发货！");
        order.setAmount(new BigDecimal("1000"));
        String orderJson = JSONUtil.toJsonPrettyStr(order);
        orderSender.send(orderJson);

        log.info("下单成功，订单信息 orderNO：{}",orderNo);
        return "下单成功，订单信息 orderNO："+orderNo;
    }
}
