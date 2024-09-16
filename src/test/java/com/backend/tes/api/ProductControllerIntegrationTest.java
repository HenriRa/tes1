package com.backend.tes.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts() throws Exception {
        mockMvc.perform(get("/api/shop/products")
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.[0].brand").value("Samsung"))
                .andExpect(jsonPath("$.[0].productVariants", hasSize(3)))
                .andExpect(jsonPath("$.[0].productVariants.[0].color").value("Black"))
                .andExpect(jsonPath("$.[0].productVariants.[1].color").value("Blue"))
                .andExpect(jsonPath("$.[0].productVariants.[2].color").value("White"))
                .andExpect(jsonPath("$.[1].brand").value("Xiaomi"))
                .andExpect(jsonPath("$.[1].productVariants", hasSize(3)))
                .andExpect(jsonPath("$.[1].productVariants.[0].color").value("Black"))
                .andExpect(jsonPath("$.[1].productVariants.[1].color").value("Blue"))
                .andExpect(jsonPath("$.[1].productVariants.[2].color").value("White"))
                .andExpect(jsonPath("$.[2].brand").value("Apple"))
                .andExpect(jsonPath("$.[2].productVariants", hasSize(2)))
                .andExpect(jsonPath("$.[2].productVariants.[0].color").value("Pink"))
                .andExpect(jsonPath("$.[2].productVariants.[1].color").value("Red"));

    }

    @Test
    void getProductById() throws Exception {
        mockMvc.perform(get("/api/shop/products/{id}",1)
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.brand").value("Samsung"))
                .andExpect(jsonPath("$.code").value("G10SAM FL6 512 GR"))
                .andExpect(jsonPath("$.name").value("Samsung Galaxy Flip6"))
                .andExpect(jsonPath("$.shortDescription").value("A feature-packed Galaxy smartphone with a sleek design and a high-quality camera."))
                .andExpect(jsonPath("$.productVariants", hasSize(3)))
                .andExpect(jsonPath("$.productVariants[0].color").value("Black"))
                .andExpect(jsonPath("$.productVariants[0].imgUrl").value("/images/samsung_Galaxy_Flip6_black.png"))
                .andExpect(jsonPath("$.productVariants[0].fullPrice").value(1149.00))
                .andExpect(jsonPath("$.productVariants[0].monthlyPrice").value(95.75))
                .andExpect(jsonPath("$.productVariants[0].defaultVariant").value(true))
                .andExpect(jsonPath("$.productVariants[0].qtyInStock").value(10))
                .andExpect(jsonPath("$.productVariants[1].color").value("Blue"))
                .andExpect(jsonPath("$.productVariants[1].imgUrl").value("/images/samsung_Galaxy_Flip6_blue.png"))
                .andExpect(jsonPath("$.productVariants[1].fullPrice").value(1149.00))
                .andExpect(jsonPath("$.productVariants[1].monthlyPrice").value(95.75))
                .andExpect(jsonPath("$.productVariants[1].defaultVariant").value(false))
                .andExpect(jsonPath("$.productVariants[1].qtyInStock").value(5))
                .andExpect(jsonPath("$.productVariants[2].color").value("White"))
                .andExpect(jsonPath("$.productVariants[2].imgUrl").value("/images/samsung_Galaxy_Flip6_white.png"))
                .andExpect(jsonPath("$.productVariants[2].fullPrice").value(1149.00))
                .andExpect(jsonPath("$.productVariants[2].monthlyPrice").value(95.75))
                .andExpect(jsonPath("$.productVariants[2].defaultVariant").value(false))
                .andExpect(jsonPath("$.productVariants[2].qtyInStock").value(3));
    }
}