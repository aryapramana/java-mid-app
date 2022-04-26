package com.software.tempe.appstation.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand", nullable = false, length = 255)
    private String brand;

    @Column(name = "display", nullable = false, length = 255)
    private String display;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "discount", nullable = false)
    private int discount;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

}
