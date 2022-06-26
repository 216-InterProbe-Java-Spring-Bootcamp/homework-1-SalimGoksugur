package com.patika.odev_1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.odev_1.entities.ProductComment;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User  implements Serializable{
    @Id
    @GeneratedValue(generator = "User")
    @SequenceGenerator(name = "User", sequenceName = "User_Id_Seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "SURNAME", length = 50)
    private String surname;

    @Email
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name="PHONE", length = 15, nullable = false)
    private String phoneNumber;

    @Version
    private Integer version;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ProductComment> comments = new ArrayList<>();

}