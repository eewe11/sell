package com.wgymt.sell.repository;

import com.wgymt.sell.entity.ProductInfo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest extends TestCase {

    @Resource
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testSave() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductPrice(new BigDecimal("3.2"));
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好喝的粥, 健康的粥!");
        productInfo.setCategoryType(2);

        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertNotNull(productInfoList);
    }
}