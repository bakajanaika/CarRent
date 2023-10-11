package com.example.demo.repos;

import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Client,Integer> {
    public Client findByLogin(String login);

}
