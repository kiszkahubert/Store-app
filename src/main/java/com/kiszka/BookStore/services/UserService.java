package com.kiszka.BookStore.services;

import com.kiszka.BookStore.dbconnection.UserDAO;
import com.kiszka.BookStore.dbconnection.User_info;
import com.kiszka.BookStore.security.UserRegistration;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public User_info registerNewUserAccount(UserRegistration userRegistration) throws Exception {
        if(emailExists(userRegistration.getEmail())){
            throw new Exception("There is an account with that email address: ");
        }
        User_info user = new User_info();
        user.setEmail(userRegistration.getEmail());
        user.setPassword(userRegistration.getPassword());
        return userDAO.save(user);
    }
    private boolean emailExists(String email){
        return userDAO.findByEmail(email) != null;
    }
}
