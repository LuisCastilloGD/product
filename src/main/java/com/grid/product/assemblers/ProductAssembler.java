package com.grid.product.assemblers;

import com.grid.product.controllers.ProductController;
import com.grid.product.models.dtos.ProductDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class ProductAssembler implements RepresentationModelAssembler<ProductDto, EntityModel<ProductDto>> {

    @Override
    public EntityModel<ProductDto> toModel(final ProductDto entity) {
        return EntityModel.of(entity, linkTo(methodOn(ProductController.class).getByUniqueId(entity.getUniqId())).withSelfRel());
    }
}
