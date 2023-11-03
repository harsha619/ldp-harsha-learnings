package com.springboot.practiceprograming.Service;

import com.springboot.practiceprograming.Dto.BookDTO;
import com.springboot.practiceprograming.Entity.Book;
import com.springboot.practiceprograming.Repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements  BookService{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book=modelMapper.map(bookDTO,Book.class);
        book= bookRepository.save(book);
        BookDTO savedBook= modelMapper.map(book,BookDTO.class);
        return savedBook;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> allBooks= bookRepository.findAll();
        List<BookDTO> allBookDto=allBooks.stream().map(book -> modelMapper.map(book,BookDTO.class)).collect(Collectors.toList());
        return allBookDto;
    }
}
