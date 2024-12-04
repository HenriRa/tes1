package com.backend.tes.repository;

import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@DataJpaTest
@ActiveProfiles("test")
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
    void testCreateAndFindProduct() {
        // Create a new product
        Product product = new Product();
        product.setName("Test Product");
        product.setCode("TP001");
        product.setShortDescription("This is a test product");
        product.setOrderCount(BigInteger.valueOf(10));

        // Save the product
        Product savedProduct = productRepository.save(product);

        // Find the product by ID
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());

        // Assert the product was found and the details are correct
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Test Product");
        assertThat(foundProduct.get().getCode()).isEqualTo("TP001");
        assertThat(foundProduct.get().getShortDescription()).isEqualTo("This is a test product");
        assertThat(foundProduct.get().getOrderCount()).isEqualTo(BigDecimal.valueOf(19.99));
    }


    @Test
    public void testNativeQuery() {

        Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Order.desc("orderCount")));

        // Execute the query
        final Page<Product> products = productRepository.findProductsByFilters(
                List.of("Mobile phones"),
                List.of("Redmi"),
                /*List.of("Black")*/null,
                null,
                /*List.of("price_monthly_50_100","price_monthly_100_150")*/null,
//                "price_desc"
                pageable
        );
        assertThat(products).isNotEmpty();
        assertThat(products).hasSize(1);
        assertThat(products.getContent()).hasSize(1);
        //List<ProductVariant> prodVars = products.getContent().getFirst().getProductVariants();

        System.out.println(products.getContent().getFirst().toString());
        System.out.println(products.getTotalPages());
//        assertEquals(2, products.get(0).length);

    }

    @Test
    public void findById_findOneProduct(){
        final Product product = productRepository.findById(1L).get();

        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(1L);
        List<ProductVariant> prodVars = product.getProductVariants();
        System.out.println(prodVars.toString());

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