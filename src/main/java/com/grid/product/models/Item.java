package com.grid.product.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
