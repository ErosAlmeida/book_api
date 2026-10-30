
package com.example.library.book.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor//construtor vazio
public class BookResponseDTO {

    private UUID id;
    private String nome;
    private String description;
    private int quantity;
    private int quantityLent;
    private LocalDate date;
}
