package com.kiszka.BookStore.dbconnection;

import org.springframework.stereotype.Service;

@Service
public class DefaultBookService{
    private BookRepository bookRepository;
    public Iterable<Book> listOfBooks(){
        return bookRepository.findAll();
    }
}
