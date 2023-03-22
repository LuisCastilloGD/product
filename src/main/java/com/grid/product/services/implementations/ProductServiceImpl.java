package com.grid.product.services.implementations;

import com.grid.product.models.Product;
import com.grid.product.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getByUniqueId(final String uniqueId) {
        return null;
    }

    @Override
    public List<Product> getBySku(final String sku) {
        return null;
    }
}
