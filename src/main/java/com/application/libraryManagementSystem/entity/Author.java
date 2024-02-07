package com.application.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false,length = 100,unique = true)
    private String name;
    @Column(name = "description",length = 250,nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
