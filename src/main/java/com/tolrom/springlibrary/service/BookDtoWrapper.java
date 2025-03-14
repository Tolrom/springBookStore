package com.tolrom.springlibrary.service;

import com.tolrom.springlibrary.dto.BookDTO;
import com.tolrom.springlibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookDtoWrapper {
    public static BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationDate(), book.getEditor());
    }
}
