package com.grid.product.converters;

import com.grid.product.models.Product;
import com.grid.product.models.Product.ProductBuilder;
import com.grid.product.models.dtos.ProductDto;
import com.grid.product.models.dtos.ProductDto.ProductDtoBuilder;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-27T14:55:59-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto modelToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.uniqId( product.getUniqId() );
        productDto.sku( product.getSku() );
        productDto.availability( product.getAvailability() );
        productDto.name_title( product.getName_title() );
        productDto.description( product.getDescription() );
        if ( product.getList_price() != null ) {
            productDto.list_price( new BigDecimal( product.getList_price() ) );
        }
        productDto.sale_price( product.getSale_price() );
        productDto.category( product.getCategory() );
        productDto.category_tree( product.getCategory_tree() );
        productDto.average_product_rating( product.getAverage_product_rating() );
        productDto.product_url( product.getProduct_url() );
        productDto.brand( product.getBrand() );

        return productDto.build();
    }

    @Override
    public Product dtoToModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.uniqId( productDto.getUniqId() );
        product.sku( productDto.getSku() );
        product.availability( productDto.getAvailability() );
        product.name_title( productDto.getName_title() );
        product.description( productDto.getDescription() );
        if ( productDto.getList_price() != null ) {
            product.list_price( productDto.getList_price().toString() );
        }
        product.sale_price( productDto.getSale_price() );
        product.category( productDto.getCategory() );
        product.category_tree( productDto.getCategory_tree() );
        product.average_product_rating( productDto.getAverage_product_rating() );
        product.product_url( productDto.getProduct_url() );
        product.brand( productDto.getBrand() );

        return product.build();
    }
}
