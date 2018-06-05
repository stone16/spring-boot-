package com.leileichen.sell.service.impl;

import com.leileichen.sell.dataTransferObject.OrderDTO;
import com.leileichen.sell.dataobject.OrderDetail;
import com.leileichen.sell.enums.OrderStatusEnum;
import com.leileichen.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1527678394989944712";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerAddress("qingdao");
        orderDTO.setBuyerName("leilei");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("1234563432");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123");
        o1.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】 result={}", result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result = {}", orderDTO);
        Assert.assertEquals(ORDER_ID, orderDTO.getOrderId());

    }

    @Test
    public void findList() {

        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);

        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}