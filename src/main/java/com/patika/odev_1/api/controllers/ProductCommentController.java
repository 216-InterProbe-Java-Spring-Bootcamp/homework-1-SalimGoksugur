package com.patika.odev_1.api.controllers;

import com.patika.odev_1.entities.ProductComment;
import com.patika.odev_1.service.abstracts.IProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping (path = "/api/v1/productComments")
@RequiredArgsConstructor
public class ProductCommentController {
    private final IProductCommentService productCommentService;



    @GetMapping
    public ResponseEntity<List<ProductComment>> getAllComments(){
        return new ResponseEntity<>(productCommentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductComment> getCommentById(@PathVariable long id){
        return new ResponseEntity<>(productCommentService.getById(id), HttpStatus.OK);
    }

    @PostMapping(path="{userId}/{productId}")
    public ResponseEntity<ProductComment> creteComment(@PathVariable long userId,
                                                       @PathVariable long productId,
                                                       @RequestBody ProductComment productComment){
        return new ResponseEntity<>(productCommentService.addComment( userId, productId, productComment), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductComment> updateComment(@RequestBody ProductComment productComment){
        return new ResponseEntity<>(productCommentService.updateComment(productComment), HttpStatus.GONE);
    }

    @DeleteMapping(path =" {id}")
    public ResponseEntity deleteComment(@PathVariable long id){
        productCommentService.removeComment(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping(path = "getCommentByUserId/{userId}")
    public ResponseEntity<List<ProductComment>> getCommentsByUserId(@PathVariable long userId){
        return new ResponseEntity<>(productCommentService.getCommentsByUserId(userId), HttpStatus.OK);
    }
    @GetMapping(path = "getCommentsByUserIdFilterByDates/{userId}/{firstCommentDate}/{lastCommentDate}")
    public ResponseEntity<List<ProductComment>> getCommentsByUserIdFilterByDates
            (@PathVariable long userId,
             @PathVariable@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date firstCommentDate,
             @PathVariable@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date lastCommentDate){

        return new ResponseEntity<>(productCommentService.
                getCommentsByUserIdFilterByCommentDate(userId,firstCommentDate,lastCommentDate), HttpStatus.OK);
    }

    @GetMapping(path = "getCommentByProductId/{productId}")
    public ResponseEntity<List<ProductComment>> getCommentsByProductId(@PathVariable long productId){
        return new ResponseEntity<>(productCommentService.getCommentsByProductId(productId), HttpStatus.OK);
    }

    @GetMapping(path = "getCommentsByProductIdFilterByDates/{productId}/{firstCommentDate}/{lastCommentDate}")
    public ResponseEntity<List<ProductComment>> getCommentsByProductIdFilterByDates
            (@PathVariable long productId,
             @PathVariable@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date firstCommentDate,
             @PathVariable@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date lastCommentDate){

        return new ResponseEntity<>(productCommentService.
                getCommentsByProductIdFilterByCommentDate(productId,firstCommentDate,lastCommentDate), HttpStatus.OK);
    }
}
