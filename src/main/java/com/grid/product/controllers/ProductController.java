package com.grid.product.controllers;

import com.grid.product.assemblers.ProductAssembler;
import com.grid.product.converters.ProductMapper;
import com.grid.product.models.dtos.ProductDto;
import com.grid.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    private final ProductAssembler productAssembler;

    @GetMapping("/getByUniqueId/{uniqueId}")
    public EntityModel<ProductDto> getByUniqueId(@PathVariable String uniqueId){
        return productAssembler.toModel(productMapper.modelToDto(productService.getByUniqueId(uniqueId)));
    }

    @GetMapping("/getBySku/{sku}")
    public List<EntityModel<ProductDto>> getBySku(@PathVariable String sku){
        return productService.getBySku(sku).stream().map(productMapper::modelToDto).map(productAssembler::toModel).toList();
    }

}