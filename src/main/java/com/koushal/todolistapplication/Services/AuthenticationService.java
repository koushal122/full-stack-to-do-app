package com.koushal.todolistapplication.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    //we can have some authentication methods here.
    public boolean authenticateUser(String userName,String password){
        return userName.equals("Koushal") && password.equals("dummy");
    }
}
