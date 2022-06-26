package com.patika.odev_1.service;

import com.patika.odev_1.entities.Product;
import com.patika.odev_1.entities.ProductComment;
import com.patika.odev_1.entities.User;
import com.patika.odev_1.repository.abstracts.IProductCommentRepository;
import com.patika.odev_1.repository.abstracts.IProductRepository;
import com.patika.odev_1.repository.abstracts.IUserRepository;
import com.patika.odev_1.service.abstracts.IProductCommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentService implements IProductCommentService {

    private final IProductCommentRepository productCommentRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;



    @Override
    public List<ProductComment> getCommentsByProductId(long productId) {
        return productCommentRepository.findByProductId(productId);
    }

    @Override
    public List<ProductComment> getCommentsByUserId(long userId) {
        return productCommentRepository.findByUserId(userId);
    }

    @Override
    public List<ProductComment> getCommentsByProductIdFilterByCommentDate(long productId, Date firstCommentDate, Date lastCommentDate) {
        return productCommentRepository.findByProductIdAndCommentDateBetween(productId,firstCommentDate,lastCommentDate);
    }

    @Override
    public List<ProductComment> getCommentsByUserIdFilterByCommentDate(long userId, Date firstCommentDate, Date lastCommentDate) {
       List<ProductComment> productComments=
               productCommentRepository.findByUserIdAndCommentDateBetween(userId, firstCommentDate,lastCommentDate);
        return productComments;
    }

    @Override
    public List<ProductComment> getAllComments() {
        List<ProductComment> productComments=productCommentRepository.findAll();
        return productComments;
    }

    @Override
    public ProductComment getById(long id) {
        return productCommentRepository.findById(id).orElseThrow(()->new RuntimeException("Kayıt bulunamadı"));
    }

    @Override
    public ProductComment addComment(long userId, long productId,ProductComment productComment) {
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("Kullanıcı bulunamadı"));
        Product product=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Ürün bulunamadı"));
        productComment.setUser(user);
        productComment.setProduct(product);
        return productCommentRepository.save(productComment);
    }

    @Override
    public ProductComment updateComment(ProductComment productComment) {
        return  productCommentRepository.save(productComment);
    }

    @Override
    public void removeComment(long id) {
        productCommentRepository.deleteById(id);
    }
}
