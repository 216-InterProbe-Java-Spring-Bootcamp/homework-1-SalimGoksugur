package com.patika.odev_1.repository.abstracts;

import com.patika.odev_1.entities.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface IProductCommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findByProductId(long productId);
    List<ProductComment> findByProductIdAndCommentDateBetween(long productId, Date firstCommentDate, Date lastCommentDate);
    List<ProductComment> findByUserId(long userId);
    List<ProductComment> findByUserIdAndCommentDateBetween(long userId, Date firstCommentDate, Date lastCommentDate);

}
