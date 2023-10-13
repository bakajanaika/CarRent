package com.example.demo.models;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Users")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String password;
    String userEmail;

    public Client(String login, String password, String userEmail) {
        this.login = login;
        this.password = password;
        this.userEmail = userEmail;
    }
}
