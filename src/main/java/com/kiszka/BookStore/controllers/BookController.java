package com.kiszka.BookStore.controllers;

import com.kiszka.BookStore.dbconnection.Book;
import com.kiszka.BookStore.dbconnection.BookRepository;
import com.kiszka.BookStore.dbconnection.UserDAO;
import com.kiszka.BookStore.dbconnection.User_info;
import com.kiszka.BookStore.security.UserRegistration;
import com.kiszka.BookStore.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    private final BookRepository bookRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO repository;
    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @GetMapping("/books")
    public String displayBooks(Model model, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,10);
        Page<Book> bookPage = bookRepository.findAll(pageable);
        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());
        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(WebRequest request, Model model){
        UserRegistration userRegistration = new UserRegistration();
        model.addAttribute("user",userRegistration);
        return "register";
    }
    @PostMapping("/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserRegistration userRegistration,
            HttpServletRequest request,
            Errors errors){
        ModelAndView mav = new ModelAndView();
        try {
            User_info registered = userService.registerNewUserAccount(userRegistration);
        } catch (Exception exp){
            mav.addObject("message","An account for that email already exists.");
            return mav;
        }
        return new ModelAndView("successRegister","user",userRegistration);
    }
}
