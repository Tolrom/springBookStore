package com.tolrom.springlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title", nullable = false)
    @NotBlank(message = "Must have a title!")
    @Size(min = 5,max = 255, message = "Must be 3 characters long and shorter than 255")
    private String title;

    @Column(name="description", nullable = false)
    @NotBlank(message = "Must have a description")
    @Size(min = 5,max = 255, message = "Must be 5 characters long and shorter than 255")
    private  String description;

    @Column(name= "publication_date", nullable = false)
    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @NotNull(message = "Must have an author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "id_editor")
    private Editor editor;

    @ManyToMany
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    public Book() {}

    public Book(String title, String description, Date publicationDate, User author, Editor editor) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.author = author;
        this.editor = editor;
        this.genres = new HashSet<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }


    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Genre> getGenres() {
        return genres;
    }
    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }
    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    @Override
    public String toString() {
        return title + "\t" + description + "\t" + publicationDate + "\n";
    }

}