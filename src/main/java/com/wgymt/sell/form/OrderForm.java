package com.wgymt.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号码
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家收货地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家 openid, 用作查询订单
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
