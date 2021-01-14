package com.wgymt.sell.repository;

import com.wgymt.sell.entity.OrderDetail;
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
public class OrderDetailRepositoryTest {

    @Resource
    private OrderDetailRepository repository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("111112");
        orderDetail.setProductIcon("http//xxx.jpg");
        orderDetail.setProductId("111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal("2.2"));
        orderDetail.setProductQuantity(3);

        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("111112");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}
