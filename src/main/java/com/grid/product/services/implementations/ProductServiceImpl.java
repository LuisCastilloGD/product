package com.grid.product.services.implementations;

import com.grid.product.exceptions.ProductNotAvailableException;
import com.grid.product.feignclients.CatalogFeignClient;
import com.grid.product.feignclients.InventoryFeignClient;
import com.grid.product.models.Article;
import com.grid.product.models.Item;
import com.grid.product.models.Product;
import com.grid.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CatalogFeignClient catalogFeignClient;

    private final InventoryFeignClient inventoryFeignClient;

    @Override
    public Product getByUniqueId(final String uniqueId) {
        Article article = catalogFeignClient.getProductByUniqueId(uniqueId);
        Item item = inventoryFeignClient.getItemByUniqueId(uniqueId);
        if(item.getAvailability() <= 0){
            throw new ProductNotAvailableException();
        }else{
            return Product.builder()
                          .uniqId(article.getUniqId())
                          .sku(article.getSku())
                          .availability(item.getAvailability())
                          .name_title(article.getName_title())
                          .description(article.getDescription())
                          .list_price(article.getList_price())
                          .sale_price(article.getSale_price())
                          .category(article.getCategory())
                          .category_tree(article.getCategory_tree())
                          .product_url(article.getProduct_url())
                          .average_product_rating(article.getAverage_product_rating())
                          .brand(article.getBrand())
                          .build();
        }
    }

    @Override
    public List<Product> getBySku(final String sku) {
        List<Article> articles = catalogFeignClient.getProductBySku(sku);
        return articles.stream()
                       .map(article -> {
                           Item item = inventoryFeignClient.getItemByUniqueId(article.getUniqId());
                           assert item != null;
                           return Product.builder()
                                         .uniqId(article.getUniqId())
                                         .sku(article.getSku())
                                         .availability(item.getAvailability())
                                         .name_title(article.getName_title())
                                         .description(article.getDescription())
                                         .list_price(article.getList_price())
                                         .sale_price(article.getSale_price())
                                         .category(article.getCategory())
                                         .category_tree(article.getCategory_tree())
                                         .product_url(article.getProduct_url())
                                         .average_product_rating(article.getAverage_product_rating())
                                         .brand(article.getBrand())
                                         .build();
                       }).filter(product -> product.getAvailability()>0L).toList();
    }
}
