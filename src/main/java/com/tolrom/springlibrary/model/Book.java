package com.tolrom.springlibrary.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="description", nullable = false)
    private  String description;

    @Column(name= "publication_date", nullable = false)
    private Date publicationDate;

    @Column(name="genre", nullable = true)
    private String genre;

    @Column(name="author", nullable = true)
    private String author;

    @Column(name = "editor", nullable = true)
    private String editor;

    public Book() {}

    public Book(String title, String description, Date publicationDate ) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return title + "\t" + description + "\t" + publicationDate + "\n";
    }

}