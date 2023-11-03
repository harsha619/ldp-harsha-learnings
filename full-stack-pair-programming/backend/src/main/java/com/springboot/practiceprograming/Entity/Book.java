package com.springboot.practiceprograming.Entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
@Table(name="book")
@jakarta.persistence.Entity
@Data
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Integer id;
    @Column
    @NotNull(message = "book should not be null")
    private  String book;
    @Column
    @NotNull(message = "description should not be null")
    private String description;
}
