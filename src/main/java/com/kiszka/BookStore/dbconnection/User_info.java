package com.kiszka.BookStore.dbconnection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED,force = true)
public class User_info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user_info;
    private String email;
    private String password;
}
