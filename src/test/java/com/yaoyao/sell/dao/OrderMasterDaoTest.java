package com.yaoyao.sell.dao;

import com.yaoyao.sell.dataobject.OrderMaster;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID = "2018516";

    @Test
    public void saveOrder() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("0005");
        orderMaster.setBuyerName("徐攀要");
        orderMaster.setBuyerPhone("12345678989");
        orderMaster.setBuyerAddress("祁东");
        orderMaster.setBuyerOpenid("111");
        orderMaster.setOrderAmount(new BigDecimal(9.9));
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void  method1(){
        PageRequest request = new PageRequest(0,1);
        //Page<OrderMaster> result = orderMasterDao.findByBuyerOpenId(OPENID,request);

    }
}