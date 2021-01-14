package com.wgymt.sell.service.impl;

import com.wgymt.sell.dto.OrderDTO;
import com.wgymt.sell.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private static final String OPENID = "110110";

    @Resource
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("贝克街");
        orderDTO.setBuyerName("阿拉基");
        orderDTO.setBuyerPhone("13800138000");
        orderDTO.setBuyerOpenid(OPENID);

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("223457");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123457");
        orderDetail1.setProductQuantity(4);
        orderDetailList.add(orderDetail1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}", result);

        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}