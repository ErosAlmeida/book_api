package com.example.library.book.application.dto;

import java.time.LocalDate;
import java.util.UUID;

public record BookRequestDTO(
        UUID id,
        String nome,
        String description,
        int quantity,
        int quantityLent,
        LocalDate date
) {}