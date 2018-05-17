package com.yaoyao.sell.dto;

import com.yaoyao.sell.dataobject.OrderDetail;
import com.yaoyao.sell.enums.OrderStatusEnum;
import com.yaoyao.sell.enums.PayStatusEnum;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    List<OrderDetail> orderDetailList;
}
