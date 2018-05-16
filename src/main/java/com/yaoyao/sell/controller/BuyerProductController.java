package com.yaoyao.sell.controller;

import com.yaoyao.sell.dataobject.ProductCategory;
import com.yaoyao.sell.dataobject.ProductInfo;
import com.yaoyao.sell.service.CategoryService;
import com.yaoyao.sell.service.ProductService;
import com.yaoyao.sell.utils.ResultVOUtil;
import com.yaoyao.sell.vo.ProductInfoVo;
import com.yaoyao.sell.vo.ProductVo;
import com.yaoyao.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //查所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询类目 一次性查询
        //List<Integer> categoryTypeList = new ArrayList<>();
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList= categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据凭装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryname(productCategory.getCategoryName());
            productVo.setCategorytype(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }


        return ResultVOUtil.success(productVoList);
    }
}
