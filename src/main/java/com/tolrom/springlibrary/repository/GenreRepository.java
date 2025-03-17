package com.tolrom.springlibrary.repository;

import com.tolrom.springlibrary.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
    Genre getGenreById(int id);
}
