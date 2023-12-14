package com.kiszka.BookStore.dbconnection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User_info,Long> {
    User_info findByEmail(String email);
}
