package com.wgymt.sell.dto;

import com.wgymt.sell.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信 openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0, 表示新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态, 默认为0, 表示未支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
