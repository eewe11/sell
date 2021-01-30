package com.wgymt.sell.enums;

import lombok.Getter;

/**
 * 支付状态码
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功");

    private final Integer code;

    private final String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
