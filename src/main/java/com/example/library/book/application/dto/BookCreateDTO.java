package com.example.library.book.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookCreateDTO(

        @NotBlank (message = "O nome do livro é obrigatorio")
        String name,

        @NotBlank(message = "Descrição obrigatoria")
        String description,

        @NotNull(message = "quantidade obrigatoria")
        @Min(value = 0, message = "Quantidade invalidade")
        Integer quantity

) {

}