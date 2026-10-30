
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

    public BookResponseDTO create(BookResponseDTO dto) {

        Book book = new Book();

        book.setNome(dto.getNome());
        book.setDescription(dto.getDescription());
        book.setQuantity(dto.getQuantity());
        book.setQuantityLent(dto.getQuantityLent());
        book.setDate(dto.getDate());

        Book savedBook = repository.save(book);

        return toDTO(savedBook);
    }

    public List<BookResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public BookResponseDTO findById(UUID id) {

        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Livro não encontrado"));

        return toDTO(book);
    }

    public BookResponseDTO update(BookResponseDTO dto) {

        Book book = repository.findById(dto.getId())
                .orElseThrow(() ->
                        new RuntimeException("Livro não encontrado"));

        book.setNome(dto.getNome());
        book.setDescription(dto.getDescription());
        book.setQuantity(dto.getQuantity());
        book.setQuantityLent(dto.getQuantityLent());
        book.setDate(dto.getDate());

        Book updatedBook = repository.save(book);

        return toDTO(updatedBook);
    }

    public void delete(UUID id) {

        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Livro não encontrado"));

        repository.delete(book);
    }

    private BookResponseDTO toDTO(Book book) {

        return new BookResponseDTO(
                book.getId(),
                book.getNome(),
                book.getDescription(),
                book.getQuantity(),
                book.getQuantityLent(),
                book.getDate()
        );
    }
}
