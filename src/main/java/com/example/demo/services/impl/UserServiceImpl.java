package com.example.demo.services.impl;

import com.example.demo.models.Client;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public String signIn(String login, String password){
        Client client = userRepo.findByLogin(login);
        if(client == null) {
            String validation = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";

            Pattern pattern = Pattern.compile(validation);
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()&&password.length()>=8) {
                Client newClient;
                userRepo.save(new Client(login, password));
                return "Successful registration";
            }
        }
        return "Incorrect login or password";
    }
    @Override
    public boolean logIn(String login, String password) {
        Client client = userRepo.findByLogin(login);
        if (client == null) {
            return false;
        }
        else if (client != null && !password.equals(client.getPassword())){

                return false;
        }
        return true;
    }
}
