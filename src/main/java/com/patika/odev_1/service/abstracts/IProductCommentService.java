package com.patika.odev_1.service.abstracts;

import com.patika.odev_1.entities.ProductComment;

import java.util.Date;
import java.util.List;

public interface IProductCommentService {
    List<ProductComment> getCommentsByProductId(long productId);

    List<ProductComment> getCommentsByUserId(long userId);

    List<ProductComment> getCommentsByProductIdFilterByCommentDate(long productId, Date firstCommentDate, Date lastCommentDate);

    List<ProductComment> getCommentsByUserIdFilterByCommentDate(long userId, Date firstCommentDate, Date lastCommentDate);

    List<ProductComment> getAllComments();

    ProductComment getById(long id);
    ProductComment addComment(long userId, long productId,ProductComment productComment);
    ProductComment updateComment(ProductComment productComment);
    void removeComment(long id);

}
