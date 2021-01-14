package com.wgymt.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

}
