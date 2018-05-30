package com.leileichen.sell.VO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

//    起名字的时候尽量具体点，但是可能和原本的api文档有不符合的地方，就用JsonProperty这个注解来进行相互之间的连接
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
