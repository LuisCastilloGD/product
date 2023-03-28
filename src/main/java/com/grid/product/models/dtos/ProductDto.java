package com.grid.product.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private String uniqId;

    private String sku;

    private Long availability;
    private String name_title;

    private String description;

    private BigDecimal list_price;

    private String sale_price;

    private String category;

    private String category_tree;

    private String average_product_rating;

    private String product_url;

    private String brand;

}
