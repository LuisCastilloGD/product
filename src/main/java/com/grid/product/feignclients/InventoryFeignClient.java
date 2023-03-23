package com.grid.product.feignclients;

import com.grid.product.models.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "inventory-application", url = "http://localhost:8082")
public interface InventoryFeignClient {

    @GetMapping("/inventory/quantity/{uniqueId}")
    Item getItemByUniqueId(@PathVariable("uniqueId") String uniqueId);


}
