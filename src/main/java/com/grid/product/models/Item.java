package com.grid.product.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {
    @NonNull
    @NotNull
    @NotBlank
    private String uniqId;

    @NonNull
    @NotNull
    private Long availability;
}
