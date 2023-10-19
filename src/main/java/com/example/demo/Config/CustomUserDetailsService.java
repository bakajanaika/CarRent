package com.example.demo.Config;

import com.example.demo.models.Client;
import com.example.demo.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client = clientRepo.findByLogin(username);
        if (client == null) {
            throw new UsernameNotFoundException("User is not found.");
        }
        if (!client.getPassword().equals(client.getPassword())) {
            throw new UsernameNotFoundException("Incorrect password.");
        }

        return org.springframework.security.core.userdetails.User.withUsername(client.getLogin())
                .password(client.getPassword())
                .roles(client.getRole())
                .build();
    }
}