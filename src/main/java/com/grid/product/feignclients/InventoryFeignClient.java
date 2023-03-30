package com.grid.product.feignclients;

import com.grid.product.config.CustomFeignConfiguration;
import com.grid.product.models.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-application", configuration = CustomFeignConfiguration.class)
public interface InventoryFeignClient {

    @GetMapping("/inventory/quantity/{uniqueId}")
    Item getItemByUniqueId(@PathVariable("uniqueId") String uniqueId);


}
