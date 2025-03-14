package com.tolrom.springlibrary.repository;

import com.tolrom.springlibrary.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    boolean existsBookByTitle(String title);

    boolean existsBookByDescription(String description);

    boolean existsBookByPublicationDate(Date publicationDate);
}
