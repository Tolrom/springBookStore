package com.tolrom.springlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "editor")
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "label", nullable = false)
    @NotBlank(message = "Must have a label!")
    @Size(min = 2,max = 255, message = "Must be 2 characters long and shorter than 255")
    private String label;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Can't be null")
    @Size(min = 5,max = 255, message = "Must be 5 characters long and shorter than 255")
    private String description;

    public Editor() {
    }
    public Editor(int id, String label, String description) {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Editor{" + "id=" + id + ", label=" + label + ", description=" + description + '}';
    }
}
