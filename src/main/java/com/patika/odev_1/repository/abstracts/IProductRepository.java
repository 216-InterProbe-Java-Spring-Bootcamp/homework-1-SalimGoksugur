package com.patika.odev_1.repository.abstracts;

import com.patika.odev_1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByExpirationDateGreaterThanOrExpirationDateIsNull(Date expirationDate);
    List<Product> findByExpirationDateLessThanOrExpirationDateEquals(Date expirationDate, Date expireDate);
}
