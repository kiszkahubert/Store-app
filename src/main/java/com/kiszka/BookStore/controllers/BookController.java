package com.kiszka.BookStore.controllers;

import com.kiszka.BookStore.dbconnection.Book;
import com.kiszka.BookStore.dbconnection.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookRepository bookRepository;
    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @GetMapping("/books")
    public String displayBooks(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books",books);
        return "home";
    }
    @GetMapping("/test")
    public String test(){
        return "login";
    }
    @GetMapping("/test2")
    public String test2(){
        return "register";
    }
}
