package com.leileichen.sell.service;

import com.leileichen.sell.dataTransferObject.OrderDTO;
import com.leileichen.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderService {

    /** create order
     *
     * 这里不直接用OrderMaster 因为会对应很多个orderDetail
     * 建立一个新的dataTransferObject对象
     */

    OrderDTO create(OrderDTO orderDTO);

    /** search one order*/
    OrderDTO findOne(String orderId);

    /** search order list*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** cancel order*/
    OrderDTO cancel (OrderDTO orderDTO);

    /** finish order*/
    OrderDTO finish (OrderDTO orderDTO);

    /** pay for order*/
    OrderDTO paid (OrderDTO orderDTO);
}
