package com.leileichen.sell.service.impl;

import com.leileichen.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory result = categoryService.findOne(2);
        Assert.assertEquals(new Integer (2), result.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = categoryService.findAll();
        Assert.assertNotNull(result);

    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> resultList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0, resultList.size());

    }

    @Test
    public void save() {
        ProductCategory newObject = new ProductCategory("lolol", 3);
        ProductCategory result = categoryService.save(newObject);
        Assert.assertNotEquals(null,result);
    }
}