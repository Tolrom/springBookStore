package com.tolrom.springlibrary.service;

import com.tolrom.springlibrary.dto.BookDTO;
import com.tolrom.springlibrary.model.Book;
import com.tolrom.springlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Long countBooks() {
        return bookRepository.count();
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public ArrayList<BookDTO> findAllBookDTOs() {
        Iterable<Book> books = findAllBooks();
        ArrayList<BookDTO> dtos = new ArrayList<>();
        for (Book book : books) {
            dtos.add(BookDtoWrapper.toDTO(book));
        }
        return dtos;
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<BookDTO> findBookDTOById(Long id) {
        return bookRepository.findById(id).map(BookDtoWrapper::toDTO);
    }

    public Book add(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book book, Long id) {
        Optional<Book> oldBook = bookRepository.findById(id);
        if(oldBook.isPresent()) {
            ((Book) oldBook.get()).setTitle(book.getTitle());
            ((Book) oldBook.get()).setDescription(book.getDescription());
            ((Book) oldBook.get()).setPublicationDate(book.getPublicationDate());
            return bookRepository.save(oldBook.get());
        }
        return null;
    }

    public Iterable<Book> delete(Long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        bookRepository.delete(book);
        return this.findAllBooks();
    }
}
