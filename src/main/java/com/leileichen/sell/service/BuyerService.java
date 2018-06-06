package com.leileichen.sell.service;

import com.leileichen.sell.dataTransferObject.OrderDTO;

public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消一个订单
    OrderDTO cancelOrder(String openid, String orderId);
}
