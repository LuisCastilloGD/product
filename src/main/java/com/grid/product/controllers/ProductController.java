package com.grid.product.controllers;

import com.grid.product.converters.ProductMapper;
import com.grid.product.models.dtos.ProductDto;
import com.grid.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/getByUnique_id/{uniq_id}")
    public ProductDto getByUniqueId(@PathVariable String uniq_id){
        return productMapper.modelToDto(productService.getByUniqueId(uniq_id));
    }

    @GetMapping("/getBySku/{sku}")
    public List<ProductDto> getBySku(@PathVariable String sku){
        return productService.getBySku(sku).stream().map(productMapper::modelToDto).toList();
    }

}