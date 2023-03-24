package com.grid.product.converters;

import com.grid.product.models.Product;
import com.grid.product.models.Product.ProductBuilder;
import com.grid.product.models.dtos.ProductDto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T11:05:51-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto modelToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setUniqId( product.getUniqId() );
        productDto.setSku( product.getSku() );
        productDto.setAvailability( product.getAvailability() );
        productDto.setName_title( product.getName_title() );
        productDto.setDescription( product.getDescription() );
        if ( product.getList_price() != null ) {
            productDto.setList_price( new BigDecimal( product.getList_price() ) );
        }
        productDto.setSale_price( product.getSale_price() );
        productDto.setCategory( product.getCategory() );
        productDto.setCategory_tree( product.getCategory_tree() );
        productDto.setAverage_product_rating( product.getAverage_product_rating() );
        productDto.setProduct_url( product.getProduct_url() );
        productDto.setBrand( product.getBrand() );

        return productDto;
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
