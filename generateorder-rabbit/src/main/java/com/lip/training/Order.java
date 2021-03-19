package com.lip.training;

import lombok.Data;

import java.math.BigDecimal;

/**
 * *****************************************************************************************
 *
 * @ClassName Order
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/7/21 00:08
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       00:082/7/21     cjc                       初版
 * ******************************************************************************************
 */
@Data
public class Order {
    private  String orderNo;
    private BigDecimal amount;
    private int state = 0;
    private String remark;
}
