package com.backend.tes.service;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.repository.ProductRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void testService_FindAllProducts() {}

    @Test
    void testService_FindProductById() {

        final ProductDto productDto = productService.findProductById(1L);
        assertNotNull(productDto);
        System.out.println(productDto.toString());
    }

}
