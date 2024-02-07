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
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false,unique = true,length = 50)
    private String name;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Category(String name) {
        this.name = name;
    }
}
