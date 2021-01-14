package com.wgymt.sell.exception;

import com.wgymt.sell.enums.ResultEnum;

public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        // 把枚举类中的信息传到父类中
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
