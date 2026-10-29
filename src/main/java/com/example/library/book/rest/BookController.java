package com.example.library.book.rest;

import com.example.library.book.application.dto.BookResponseDTO;
import com.example.library.book.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService Service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponseDTO> findAll() {
        return Service.findAll();
    }

    @GetMapping(value = "{/id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookResponseDTO findById(@PathVariable("id") UUID id) {
        return Service.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BookResponseDTO create(@RequestBody BookResponseDTO book) {
        return Service.create(book);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BookResponseDTO update(@RequestBody BookResponseDTO book) {
        return Service.update(book);
    }
    @DeleteMapping(value = "/{id}")
    public BookResponseDTO delete(@PathVariable("id") UUID id) {
       return Service.delete(id);
    }
}