package com.tolrom.springlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Must have a name!")
    @Size(min = 3,max = 255, message = "Must be 3 characters long and shorter than 255")
    private String name;

    public Genre() {
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }
}
