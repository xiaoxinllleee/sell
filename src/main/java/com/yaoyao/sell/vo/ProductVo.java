package com.yaoyao.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryname;

    @JsonProperty("type")
    private Integer categorytype;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
