package com.example.demo.services.impl;

import com.example.demo.models.Client;
import com.example.demo.repos.ClientRepo;
import com.example.demo.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }
    @Override
    public String signIn(String login, String password, String email){
        Client client = clientRepo.findByLogin(login);
        if(client == null) {
            String validation = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";

            Pattern pattern = Pattern.compile(validation);
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()&&password.length()>=8) {
                Client client1 = new Client();
                client1.setLogin(login);
                client1.setPassword(password);
                client1.setUserEmail(email);
                client1.setRole("USER");
                clientRepo.save(client1);
                return "Successful registration";
            }
        }
        return "Incorrect login or password";
    }
    @Override
    public boolean logIn(String login, String password) {
        Client client = clientRepo.findByLogin(login);
        if (client == null) {
            return false;
        }
        else if (client != null && !password.equals(client.getPassword())){

                return false;
        }
        return true;
    }
}
