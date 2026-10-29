package com.example.library.book.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

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

    public Book() {

    }

    public int getDescription(String description) {
        return quantity;
    }

    public int getQuantityLent(int quantityLent) {
        quantityLent = quantityLent - quantity;
        return quantityLent;
    }
}
