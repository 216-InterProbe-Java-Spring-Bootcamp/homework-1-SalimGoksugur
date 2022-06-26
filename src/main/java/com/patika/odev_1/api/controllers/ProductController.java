package com.patika.odev_1.api.controllers;

import com.patika.odev_1.entities.Product;
import com.patika.odev_1.service.abstracts.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;


    @GetMapping
    public ResponseEntity< List<Product>> getProducts(){

        return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path="{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping(path="expiredProducts")
    public ResponseEntity<List<Product>> getExpiredProducts() throws ParseException {

        return new ResponseEntity<>(productService.getExpiredProducts(), HttpStatus.OK);
    }

    @GetMapping(path="unexpiredProducts")
    public ResponseEntity<List<Product>> getUnexpiredProducts() throws ParseException {

    return new ResponseEntity<>(productService.getUnexpiredProducts(), HttpStatus.OK);
}
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>( productService.addProduct(product), HttpStatus.CREATED) ;
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return  new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        productService.removeProduct(id);
        return  ResponseEntity.noContent().build();
    }
}

