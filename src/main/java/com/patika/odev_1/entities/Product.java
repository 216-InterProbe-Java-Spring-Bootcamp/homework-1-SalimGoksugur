package com.patika.odev_1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.odev_1.entities.enums.EnumCurrency;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
public class Product implements  Serializable{

    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PRICE", precision = 12, scale =2, nullable = false )
    private BigDecimal price;

    @Column(name = "CURRENCY", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumCurrency currency=EnumCurrency.TL;

    @Column(name="EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Version
    private int version;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductComment> comments=new ArrayList<>();

}

