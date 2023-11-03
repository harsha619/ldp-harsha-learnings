package com.springboot.practiceprograming.Controller;

import com.springboot.practiceprograming.Dto.BookDTO;
import com.springboot.practiceprograming.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    private BookDTO saveBook(@Valid @RequestBody BookDTO bookDTO){
        return  bookService.saveBook(bookDTO);
    }
    @GetMapping
    private List<BookDTO> getAllBooks(){
        return  bookService.getAllBooks();
    }
}
