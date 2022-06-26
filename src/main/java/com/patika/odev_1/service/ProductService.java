package com.patika.odev_1.service;

import com.patika.odev_1.entities.Product;
import com.patika.odev_1.repository.abstracts.IProductRepository;
import com.patika.odev_1.service.abstracts.IProductService;
import com.patika.odev_1.service.helpers.DateHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Kayıt bulunamadı"));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
     return  productRepository.save(product);
    }





    public List<Product> getExpiredProducts() throws ParseException {
        Date expirationDate=DateHelper.getCurrentDate();

        return productRepository.findByExpirationDateLessThanOrExpirationDateEquals(expirationDate, expirationDate);
    }

    @Override
    public List<Product> getUnexpiredProducts() throws ParseException {
        Date expirationDate=DateHelper.getCurrentDate();
        return productRepository.findByExpirationDateGreaterThanOrExpirationDateIsNull(expirationDate);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
