package com.wgymt.sell.enums;

import lombok.Getter;

/**
 * 商品状态码
 */
@Getter
public enum OrderStatusEnum {

    New(0, "新订单"),
    FINISHED(1, "已完成"),
    CANCEL(2, "已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
