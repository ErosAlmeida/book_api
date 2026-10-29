package com.example.library.book.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private UUID id;

    public BookResponseDTO(UUID id, String description, String nome) {
        this.id = id;
        this.date = date;
        this.quantityLent = quantityLent;
        this.quantity = quantity;
        this.description = description;
        this.nome = nome;
    }

    private String nome;
    private String description;
    private int quantity;
    private int quantityLent;
    private LocalDate date;

    public BookResponseDTO(UUID id, String nome, String description, int quantity) {
    }
}
