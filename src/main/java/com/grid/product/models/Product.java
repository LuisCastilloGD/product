package com.grid.product.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@Builder
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

    private String list_price;

    private String sale_price;

    private String category;

    private String category_tree;

    private String average_product_rating;

    private String product_url;

    private String brand;

}
