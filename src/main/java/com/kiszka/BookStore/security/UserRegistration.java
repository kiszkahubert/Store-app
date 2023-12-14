package com.kiszka.BookStore.security;

import com.kiszka.BookStore.validation.PasswordMatches;
import com.kiszka.BookStore.validation.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@PasswordMatches
public class UserRegistration {
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
}
