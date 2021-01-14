package com.wgymt.sell.repository;

import com.wgymt.sell.entity.OrderMaster;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private static final String OPENID = "110110";

    @Resource
    private OrderMasterRepository repository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("大壮");
        orderMaster.setBuyerPhone("13800138000");
        orderMaster.setBuyerAddress("长安壹号");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal("2.5"));

        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid() {
        Pageable request = new PageRequest(0, 1);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}