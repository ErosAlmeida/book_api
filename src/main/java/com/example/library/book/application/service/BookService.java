
package com.example.library.book.application.service;

import com.example.library.book.application.dto.BookResponseDTO;
import com.example.library.book.domain.entity.Book;
import com.example.library.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookResponseDTO update(BookResponseDTO book) {
        Book existingBook = repository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        existingBook.setNome(book.getNome());
        existingBook.setDescription(book.getDescription());
        existingBook.setQuantityLent(book.getQuantityLent());
        existingBook.setDate(book.getDate());

        Book updatedBook = repository.save(existingBook);
        return new BookResponseDTO(
                updatedBook.getId(),
                updatedBook.getNome(),
                updatedBook.getDescription(),
                updatedBook.getQuantity()
        );
    }

    public List<BookResponseDTO> findAll() {
    }

    public BookResponseDTO findById(UUID id) {
    }

    public BookResponseDTO create(BookResponseDTO book) {
    }

    public BookResponseDTO delete(UUID id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        repository.delete(book);
        return null;
    }



}
