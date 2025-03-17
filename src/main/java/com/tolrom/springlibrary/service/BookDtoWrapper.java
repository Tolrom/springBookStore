package com.tolrom.springlibrary.service;

import com.tolrom.springlibrary.dto.BookDTO;
import com.tolrom.springlibrary.model.Book;
import com.tolrom.springlibrary.model.Genre;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookDtoWrapper {
    public static BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getFirstname(),
                book.getPublicationDate(),
                book.getEditor().getLabel(),
                book
                        .getGenres()
                        .stream()
                        .map(Genre::getName)
                        .collect(Collectors.toSet())
        );
    }
}
