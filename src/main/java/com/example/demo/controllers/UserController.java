package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")

public class UserController {
    private final UserRepo userRepo;
    private final UserServiceImpl userService;

    public UserController(UserRepo userRepo, UserServiceImpl userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }


    @GetMapping("/list{id}")
    public Client userList(@PathVariable int id){
        return userRepo.findAll().get(id-1);
    }
    @GetMapping("/login/{login}/{password}")
    public boolean logIn (@PathVariable String login, @PathVariable String password){
        return userService.logIn(login, password);
    }
    @PostMapping("/sign")
    public String signIn(@RequestBody Client client){
       return userService.signIn(client.getLogin(), client.getPassword());
    }

//    @GetMapping(value = "/signup", produces = MediaType.TEXT_HTML_VALUE)
//    @ResponseBody
//    public String showSignupForm() {
//        return "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>Регистрация</title>\n" +
//                "<script th:src=\"@{/app.js}\"></script>" +
//                "</head>\n" +
//                "<body>\n" +
//                "<h1>Регистрация пользователя</h1>\n" +
//                "<form action=\"/api/v1/users/sign\" method=\"post\">\n" +
//                "    <label for=\"login\">Логин:</label>\n" +
//                "    <input type=\"text\" id=\"login\" name=\"login\" required><br>\n" +
//                "\n" +
//                "    <label for=\"password\">Пароль:</label>\n" +
//                "    <input type=\"password\" id=\"password\" name=\"password\" required><br>\n" +
//                "\n" +
//                "    <input type=\"submit\" value=\"Зарегистрироваться\">\n" +
//                "</form>\n" +
//                "</body>\n" +
//                "</html>";
//    }




}







