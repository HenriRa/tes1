package com.backend.tes.repository;

import com.backend.tes.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBrandNameIn(Collection<String> brandNames);

    List<Product> findByProductVariantsColorNameIn(Collection<String> colorNames);

    List<Product> findByBrandNameInAndProductVariantsColorNameIn(Collection<String> brandName, Collection<String> colorName);

//    List<Product> findByProductVariantsPriceBetweenOrProductVariantsPriceBetweenOrProductVariantsPriceBetweenOrProductVariantsPriceBetweenOrProductVariantsPriceBetween(
//            BigDecimal startPrice1, BigDecimal endPrice1,
//            BigDecimal startPrice2, BigDecimal endPrice2,
//            BigDecimal startPrice3, BigDecimal endPrice3,
//            BigDecimal startPrice4, BigDecimal endPrice4,
//            BigDecimal startPrice5, BigDecimal endPrice5);

    List<Product> findByProductVariantsStockQtyInStockGreaterThan(Integer qty);



    List<Product> findByProductVariantsStockQtyInStockIsNull();

    List<Product> findByProductVariantsStockQtyInStockIsNotNull();

    List<Product> findByProductVariantsMonthlyPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    // Create a new query method to find products by their brand name and color name and monthly price between two values
    List<Product> findByBrandNameInAndProductVariantsColorNameInAndProductVariantsMonthlyPriceBetween
        (Collection<String> brandName, Collection<String> colorName, BigDecimal startPrice, BigDecimal endPrice);

    // Create a new query method to find products by applying multiple monthly price filters
    // for example, price is between 0-10 and between 50-100 and between 150-200
    @Query("""
            select p from Product p inner join p.productVariants productVariants
            where productVariants.monthlyPrice between ?1 and ?2 and productVariants.monthlyPrice between ?3 and ?4 and productVariants.monthlyPrice between ?5 and ?6""")
    List<Product> findByProductVariantsMonthlyPriceBetweenAndProductVariantsMonthlyPriceBetweenAndProductVariantsMonthlyPriceBetween
        (BigDecimal startPrice1, BigDecimal endPrice1, BigDecimal startPrice2, BigDecimal endPrice2, BigDecimal startPrice3, BigDecimal endPrice3);



}
