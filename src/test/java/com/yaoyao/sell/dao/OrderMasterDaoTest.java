package com.yaoyao.sell.dao;

import com.yaoyao.sell.dataobject.OrderMaster;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveOrder() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("0002");
        orderMaster.setBuyerName("徐攀要");
        orderMaster.setBuyerPhone("12345678989");
        orderMaster.setBuyerAddress("祁东");
        orderMaster.setBuyerOpenid("111");
        orderMaster.setOrderAmount(new BigDecimal(9.9));
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);


    }
}