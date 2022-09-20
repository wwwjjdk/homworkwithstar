package com.example.homework140922.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "timestamp")
    private Date date;

    @Column(nullable = false, name = "product")
    private String productName;

    @Column(nullable = false, name = "amount")
    private int amount;

    @Column(nullable = false, name = "price")
    private int price;

    @ManyToOne(optional = false)
    Customer customer;
}
