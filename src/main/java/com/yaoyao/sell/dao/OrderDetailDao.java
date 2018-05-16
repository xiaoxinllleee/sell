package com.yaoyao.sell.dao;

import com.yaoyao.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderId);
}
