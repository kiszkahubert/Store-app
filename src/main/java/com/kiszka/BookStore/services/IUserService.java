package com.kiszka.BookStore.services;

import com.kiszka.BookStore.dbconnection.User_info;
import com.kiszka.BookStore.security.UserRegistration;
import org.springframework.security.core.userdetails.User;

public interface IUserService {
    User_info registerNewUserAccount(UserRegistration userRegistration) throws Exception;
}
