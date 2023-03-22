package com.grid.product.services;

import com.grid.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getByUniqueId(String uniqueId);

    List<Product> getBySku(String sku);

}
