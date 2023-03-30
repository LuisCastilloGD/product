package com.grid.product.controllers;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductControllerTest {

    private final MockMvc mockMvc;

    @Test
    @DisplayName(" Should get product ")
    public void getProductByUniqueIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/getByUniqueId/b6c0b6bea69c722939585baeac73c13d"))
               .andExpect(status().isOk());
    }

    @Test
    @DisplayName(" Should get products ")
    public void getProductsBySkuTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/getBySku/pp5006380337"))
               .andExpect(status().isOk());
    }


}
