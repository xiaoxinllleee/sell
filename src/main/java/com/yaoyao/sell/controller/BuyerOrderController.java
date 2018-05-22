package com.yaoyao.sell.controller;

import com.yaoyao.sell.converter.OrderForm2OrderDTOConverter;
import com.yaoyao.sell.dto.OrderDTO;
import com.yaoyao.sell.enums.ResultEnum;
import com.yaoyao.sell.exception.SellException;
import com.yaoyao.sell.form.OrderForm;
import com.yaoyao.sell.service.OrderService;
import com.yaoyao.sell.utils.ResultVOUtil;
import com.yaoyao.sell.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    //创建订单
    @RequestMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult
            .getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0")
                                         Integer page,
                                         @RequestParam(value = "size",defaultValue = "10")
                                         Integer size){
        if (StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

}
