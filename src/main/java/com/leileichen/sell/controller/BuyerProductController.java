package com.leileichen.sell.controller;

import com.leileichen.sell.VO.ProductInfoVO;
import com.leileichen.sell.VO.ProductVO;
import com.leileichen.sell.VO.ResultVO;
import com.leileichen.sell.dataobject.ProductCategory;
import com.leileichen.sell.dataobject.ProductInfo;
import com.leileichen.sell.service.CategoryService;
import com.leileichen.sell.service.impl.ProductServiceImpl;
import com.leileichen.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")

    public ResultVO list() {
        //  1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //  2. 查询类目  一次性查询

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //  3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
