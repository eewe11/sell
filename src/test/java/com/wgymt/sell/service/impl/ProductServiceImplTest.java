package com.wgymt.sell.service.impl;

import com.wgymt.sell.entity.ProductInfo;
import com.wgymt.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Resource
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        Pageable pageable = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageable);
        long totalElements = productInfoPage.getTotalElements();
//        System.out.println(totalElements);
        Assert.assertNotEquals(0, totalElements);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("223457");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductPrice(new BigDecimal("32.0"));
        productInfo.setProductName("红豆冰沙");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductStock(100);
        productInfo.setProductDescription("红豆生南国, 此物醉相思");
        productInfo.setCategoryType(3);

        ProductInfo save = productService.save(productInfo);
        Assert.assertNotNull(save);
    }

}