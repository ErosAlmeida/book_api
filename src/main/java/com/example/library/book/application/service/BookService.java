
package com.example.library.book.application.service;

import com.example.library.book.application.dto.BookResponseDTO;
import com.example.library.book.domain.entity.Book;
import com.example.library.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
      List<Book> books = repository.findAll();
      List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
      for (Book book : books) {
          bookResponseDTOList.add(new BookResponseDTO());
      }
      return bookResponseDTOList;

    }

    public BookResponseDTO findById(UUID id) {
        Book existingBook = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID de livro inexistente"));
        return new BookResponseDTO();
    }

    public BookResponseDTO create(BookResponseDTO book) {
        Book createdBook = new Book();
        createdBook.setId(book.getId());
        createdBook.setNome(book.getNome());
        createdBook.setDescription(book.getDescription());
        createdBook.setQuantityLent(book.getQuantityLent());
        createdBook.setDate(book.getDate());

        Book savedBook = repository.save(createdBook);

        return new BookResponseDTO();
    }

    public BookResponseDTO delete(UUID id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        repository.delete(book);
        return null;
    }
}
