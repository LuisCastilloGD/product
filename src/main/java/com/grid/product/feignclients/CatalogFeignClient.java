package com.grid.product.feignclients;

import com.grid.product.config.CustomFeignConfiguration;
import com.grid.product.models.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "catalog-application", configuration = CustomFeignConfiguration.class)
public interface CatalogFeignClient {

    @GetMapping("/catalog/get/uniqueId/{uniqueId}")
    Article getProductByUniqueId(@PathVariable("uniqueId") String uniqueId);

    @GetMapping("/catalog/get/sku/{sku}")
    List<Article> getProductBySku(@PathVariable("sku") String sku);

}
