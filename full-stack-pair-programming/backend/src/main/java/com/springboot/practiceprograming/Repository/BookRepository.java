package com.springboot.practiceprograming.Repository;

import com.springboot.practiceprograming.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book,Integer> {
}
