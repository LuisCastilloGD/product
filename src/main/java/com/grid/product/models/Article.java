package com.grid.product.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Article {

    @NonNull
    @NotNull
    @NotBlank
    private String uniqId;

    private String sku;

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
