package com.yaoyao.sell.dao;

import com.yaoyao.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2018516");
        orderDetail.setOrderId("0001");
        orderDetail.setProductIcon("https://image.baidu.com/search");
        orderDetail.setProductId("0001");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(4.5));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailDao.save(orderDetail);
        if (result != null){
            System.out.println("oooojjjjbbbbbkkkk");
        }
    }

    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("0001");
    }
}