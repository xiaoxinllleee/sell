package com.yaoyao.sell.converter;

import com.yaoyao.sell.dataobject.OrderMaster;
import com.yaoyao.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OM2ODTO {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return  orderDTO;
    }

    public  static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
       return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
