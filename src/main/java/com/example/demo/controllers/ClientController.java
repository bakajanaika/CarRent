package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.repos.ClientRepo;
import com.example.demo.services.impl.ClientServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")

public class ClientController {
    private final ClientRepo clientRepo;
    private final ClientServiceImpl userService;

    public ClientController(ClientRepo clientRepo, ClientServiceImpl userService) {
        this.clientRepo = clientRepo;
        this.userService = userService;
    }


    @GetMapping("/list{id}")
    public Client userList(@PathVariable int id){
        return clientRepo.findAll().get(id-1);
    }
    @PostMapping("/sign")
    public String signIn(@RequestBody Client client){
       return userService.signIn(client.getLogin(), client.getPassword(), client.getUserEmail());
    }
}







