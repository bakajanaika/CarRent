package com.example.demo.services;

public interface ClientService {
    public boolean logIn(String login, String password);
    public String signIn(String login, String password, String email);
}
