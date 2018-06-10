package com.leileichen.sell.repository;

import com.leileichen.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

     /**
      * Find product by product status, that if customer can get this product in the website
      * @param productStatus
      * @return
      */
     List<ProductInfo> findByProductStatus(Integer productStatus);
}
