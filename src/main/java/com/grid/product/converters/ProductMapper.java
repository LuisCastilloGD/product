package com.grid.product.converters;

import com.grid.product.models.Product;
import com.grid.product.models.dtos.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToDto(Product product);

    Product dtoToModel(ProductDto productDto);

}
