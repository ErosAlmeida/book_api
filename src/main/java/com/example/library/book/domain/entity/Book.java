package com.example.library.book.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int quantityLent;

    @Column(nullable = false)
    private LocalDate date;
}
