package com.wgymt.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {

    /**
     * 订单详情ID
     */
    @Id
    private String detailId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 创建时间
     */
//    private Date createTime;

    /**
     * 更新时间
     */
//    private Date updateTime;

}
