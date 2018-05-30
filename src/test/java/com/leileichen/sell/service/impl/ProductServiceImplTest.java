package com.leileichen.sell.service.impl;

import com.leileichen.sell.dataobject.ProductInfo;
import com.leileichen.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("123");
        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotNull(productInfoList);
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> resultPage = productService.findAll(pageRequest);
        System.out.println(resultPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("23","香蕉",new BigDecimal(8.8),500,"泰国产","https://ddd.png", ProductStatusEnum.UP.getCode(),3);
        productService.save(productInfo);
        Assert.assertNotNull(productService);
    }
}