package com.yaoyao.sell.dao;

import com.yaoyao.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDao extends JpaRepository<OrderMaster,String>{
   // Page<OrderMaster> findByBuyerOpenId(String buyerOpenid, Pageable pageable);
}
