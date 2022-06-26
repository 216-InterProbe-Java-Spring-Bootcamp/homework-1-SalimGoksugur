package com.patika.odev_1.service.abstracts;

import com.patika.odev_1.entities.Product;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product addProduct(Product product);
    void removeProduct(long id);
    Product updateProduct(Product product);
    List<Product> getExpiredProducts() throws ParseException;
    List<Product> getUnexpiredProducts() throws ParseException;

}
