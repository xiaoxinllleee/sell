package com.yaoyao.sell.service;

import com.yaoyao.sell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer categoryid);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);

    ProductCategory save(ProductCategory productCategory);
}
