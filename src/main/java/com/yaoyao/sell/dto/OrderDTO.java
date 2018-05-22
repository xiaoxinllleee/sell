package com.yaoyao.sell.dto;

import com.yaoyao.sell.dataobject.OrderDetail;
import com.yaoyao.sell.enums.OrderStatusEnum;
import com.yaoyao.sell.enums.PayStatusEnum;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    //private Date createTime;

    //private Date updateTime;

    List<OrderDetail> orderDetailList;
}
