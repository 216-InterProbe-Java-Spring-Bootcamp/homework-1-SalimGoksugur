package com.patika.odev_1.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUCTCOMMENTS")
@Getter
@Setter
public class ProductComment implements Serializable {
    @Id
    @GeneratedValue(generator = "ProductComment")
    @SequenceGenerator(name = "ProductComment", sequenceName = "Product_Comment_Id_Seq", allocationSize = 1)
    private Long id;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    @ManyToOne (cascade = CascadeType.ALL)
    private Product product;

}

