package com.grid.product.controllers;

import com.grid.product.assemblers.ProductAssembler;
import com.grid.product.converters.ProductMapper;
import com.grid.product.exceptions.ProductNotAvailableException;
import com.grid.product.exceptions.ProductNotFoundedException;
import com.grid.product.models.dtos.ProductDto;
import com.grid.product.services.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CircuitBreaker(name = "productCB", fallbackMethod = "fallBackGetByUniqueId" )
    @GetMapping("/getByUniqueId/{uniqueId}")
    public ResponseEntity<EntityModel<ProductDto>> getByUniqueId(@PathVariable String uniqueId){
        return new ResponseEntity<>(productAssembler.toModel(productMapper.modelToDto(productService.getByUniqueId(uniqueId))),HttpStatus.OK);
    }

    @CircuitBreaker(name = "productCB", fallbackMethod = "fallBackGetBySku")
    @GetMapping("/getBySku/{sku}")
    public List<ResponseEntity<EntityModel<ProductDto>>> getBySku(@PathVariable String sku){
        return productService.getBySku(sku).stream().map(productMapper::modelToDto).map(productAssembler::toModel).map(ResponseEntity::ok).toList();
    }

    private ResponseEntity<EntityModel<ProductDto>> fallBackGetByUniqueId(@PathVariable String uniqueId,RuntimeException e){

        if(e.getClass().equals(ProductNotFoundedException.class)){
            throw new ProductNotFoundedException();
        }if(e.getClass().equals(ProductNotAvailableException.class)) {
            throw new ProductNotAvailableException();
        }else{
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


    private List<ResponseEntity<EntityModel<ProductDto>>> fallBackGetBySku(@PathVariable String sku,RuntimeException e){
        return List.of(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE));
    }


}