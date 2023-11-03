package com.springboot.practiceprograming.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BookDTO {
    private  Integer id;
    private  String book;
    private String description;
}
