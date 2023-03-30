package com.grid.product.services;

import com.grid.product.feignclients.CatalogFeignClient;
import com.grid.product.feignclients.InventoryFeignClient;
import com.grid.product.models.Article;
import com.grid.product.models.Item;
import com.grid.product.models.Product;
import com.grid.product.services.implementations.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private CatalogFeignClient catalogFeignClient;
    @Mock
    private InventoryFeignClient inventoryFeignClient;

    private Product product1;

    private Item item1;
    private Article article1;
    private Product product2;
    private List<Product> productList;
    @BeforeEach
    public void setUp() {
        article1 = Article.builder()
                          .uniqId("abc1")
                          .sku("group1")
                          .name_title("shoes")
                          .category("clothes")
                          .category_tree("clothes")
                          .list_price("35.5")
                          .sale_price("40")
                          .description("shoes")
                          .product_url("https://urltoshoes.com")
                          .brand("niky")
                          .build();

        item1 = Item.builder()
                    .uniqId("abc1")
                    .availability(10L)
                    .build();

        product1 = Product.builder()
                    .uniqId("abc1")
                    .availability(10L)
                      .sku("group1")
                      .name_title("shoes")
                      .category("clothes")
                      .category_tree("clothes")
                      .list_price("35.5")
                      .sale_price("40")
                      .description("shoes")
                      .product_url("https://urltoshoes.com")
                      .brand("niky")
                    .build();

        productList = Arrays.asList(product1);
    }

    @Test
    @DisplayName(" should get item")
    public void testGetArticleByUniqueId() {
        String uniqueId = product1.getUniqId();
        when(catalogFeignClient.getProductByUniqueId(uniqueId)).thenReturn(article1);
        when(inventoryFeignClient.getItemByUniqueId(uniqueId)).thenReturn(item1);
        assertEquals(product1, productService.getByUniqueId(uniqueId));
    }

    @Test
    @DisplayName(" should get items ")
    public void testGetArticleBySku() {
        String sku = product1.getSku();
        when(catalogFeignClient.getProductBySku(sku)).thenReturn(List.of(article1));
        when(inventoryFeignClient.getItemByUniqueId(article1.getUniqId())).thenReturn(item1);
        assertEquals(productList, productService.getBySku(sku));
    }



}
