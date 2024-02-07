package com.application.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false,unique = true,length = 50)
    private String name;

    @ManyToMany(mappedBy = "publishers",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Publisher(String name) {
        this.name = name;
    }

}
