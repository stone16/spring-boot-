package com.leileichen.sell.repository;

import com.leileichen.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
// here connect with database with inner tool in spring boot framework
import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * A new method that take categoryTypeList into account and return ProductCategory back
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


}
