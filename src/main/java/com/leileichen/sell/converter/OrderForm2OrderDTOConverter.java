package com.leileichen.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leileichen.sell.dataTransferObject.OrderDTO;
import com.leileichen.sell.dataobject.OrderDetail;
import com.leileichen.sell.enums.ResultEnum;
import com.leileichen.sell.exception.SellException;
import com.leileichen.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误， String = {}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }


        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
