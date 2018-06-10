package com.leileichen.sell.dataobject;

import com.leileichen.sell.enums.OrderStatusEnum;
import com.leileichen.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
/**
 * Customer can create order, here, class OrderMaster contains basic information in the class. As for OrderDetail, it contains info
 * for a specific product in the order.
 */
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    // default is create new order
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 默认等待支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

}
