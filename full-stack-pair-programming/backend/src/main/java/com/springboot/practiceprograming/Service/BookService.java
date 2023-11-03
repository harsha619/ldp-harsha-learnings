package com.springboot.practiceprograming.Service;

import com.springboot.practiceprograming.Dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO saveBook(BookDTO bookDTO);
    List<BookDTO> getAllBooks();
}
