package com.tolrom.springlibrary.controller;

import com.tolrom.springlibrary.exception.BookAlreadyExistsException;
import com.tolrom.springlibrary.exception.BookNotFoundException;
import com.tolrom.springlibrary.exception.NoBookFoundException;
import com.tolrom.springlibrary.model.Book;
import com.tolrom.springlibrary.repository.BookRepository;
import com.tolrom.springlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> getAllBooks() {
        if (bookService.countBooks() == 0) {
            throw new NoBookFoundException();
        }
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        System.out.println(bookService.findBookById(id));
        return bookService.findBookById(id).orElseThrow(
                ()-> new BookNotFoundException(id)
        );
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        if(bookRepository.existsBookByTitle(book.getTitle())) {
            if(bookRepository.existsBookByDescription(book.getDescription())) {
                if(bookRepository.existsBookByPublicationDate(book.getPublicationDate())) {
                    throw new BookAlreadyExistsException(book.getTitle());
                }
            }
        }
        return bookService.add(book);
    }

    @PatchMapping("/update/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if(bookRepository.existsById(id)) {
            return bookService.update(book, id);
        }
        else {
            throw new BookNotFoundException(id);
        }
    }

    @DeleteMapping("/remove")
    public Iterable<Book> removeBook(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
