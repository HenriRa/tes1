package com.backend.tes.repository;

import com.backend.tes.domain.Product;
import com.backend.tes.domain.query.ProductByFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@EnableSpringDataWebSupport
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

//    @Test
//    void findByBrandNameIn_oneBrand() {
//
//        final List<Product> result = productRepository.findByBrandNameIn(List.of("Apple"));
//
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getBrand().getName()).isEqualTo("Apple");
//    }
//    @Test
//    void findByBrandNameIn_twoBrands() {
//
//        final List<Product> result = productRepository.findByBrandNameIn(List.of("Samsung", "Apple"));
//
//        assertThat(result).hasSize(2);
//        assertThat(result.get(0).getBrand().getName()).isEqualTo("Samsung");
//        assertThat(result.get(1).getBrand().getName()).isEqualTo("Apple");
//    }
//
//    @Test
//    void findByProductVariantsColorNameIn_oneColor() {
//        final List<Product> result = productRepository.findByProductVariantsColorNameIn(List.of("Black"));
//
//        assertThat(result).hasSize(2);
//        assertThat(result.get(0).getProductVariants()).hasSize(3);
//        assertThat(result.get(0).getProductVariants().get(0).getColor().getName()).isEqualTo("Black");
//        assertThat(result.get(1).getProductVariants()).hasSize(3);
//        assertThat(result.get(1).getProductVariants().get(0).getColor().getName()).isEqualTo("Black");
//    }
//
//    @Test
//    void findByProductVariantsColorNameIn_twoColors() {
//        final List<Product> result = productRepository.findByProductVariantsColorNameIn(List.of("Black", "Blue"));
//
//        assertThat(result).hasSize(2);
//        assertThat(result.get(0).getProductVariants()).hasSize(3);
//        assertThat(result.get(0).getProductVariants().get(0).getColor().getName()).isEqualTo("Black");
//        assertThat(result.get(0).getProductVariants().get(1).getColor().getName()).isEqualTo("Blue");
//        assertThat(result.get(1).getProductVariants()).hasSize(3);
//        assertThat(result.get(1).getProductVariants().get(0).getColor().getName()).isEqualTo("Black");
//        assertThat(result.get(1).getProductVariants().get(1).getColor().getName()).isEqualTo("Blue");
//    }

    @Test
    public void testNativeQuery() {
        // Set up data
//        Product product = new Product();
//        entityManager.persist(product);
//        entityManager.flush();

        // Execute the query
        List<ProductByFilter> products = productRepository.findProductsByFilter(
                List.of("Samsung","Xiaomi"),
                List.of("Black"),
                true,
                List.of("price_monthly_50_100")
//                "price_asc"
        );
        assertThat(products).isNotEmpty();
        assertThat(products).hasSize(5);
//        Product product = (Product) products.get(0)[0];
//        System.out.print(product.toString());
//        assertEquals(2, products.get(0).length);

    }


//    @Test
//    void findByProductFilters() {
//
////        Pageable pageable = PageRequest.of(0, 5);
////        final Page<Object[]> page = productRepository.findProductsByFilters
////                        (List.of("Samsung","Xiaomi"),
////                        List.of("Black"),
////                        true,
////                        List.of("price_monthly_50_100"),
//////                        "price_asc",
////                        pageable);
////        final List<Object[]> result = page.getContent();
//
//        // Assertions
////        assertThat(result).hasSize(5);
//
//        final List<Object[]> result = productRepository.findProductsByFilter(
//                        List.of("Samsung","Xiaomi"),
//                        List.of("Black"),
//                        true,
//                        List.of("price_monthly_50_100"),
//                 "price_asc");
//
//        assertThat(result).hasSize(2);

//        assertThat(result).hasSize(1);
//        assertThat(result.get().findFirst().get().get(0).brand()).isEqualTo("Apple");
//        assertThat(result.get(0).getProductVariants()).hasSize(3);
//        assertThat(result.get(0).getProductVariants().get(0).getColor().getName()).isEqualTo("Black");
//        assertThat(result.get(0).getProductVariants().get(0).getMonthlyPrice()).isEqualTo(1000);
//    }
}