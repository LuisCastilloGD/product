package com.grid.product.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Product {

    @NonNull
    @NotNull
    @NotBlank
    private String uniqId;

    private String sku;

    @NonNull
    @NotNull
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
