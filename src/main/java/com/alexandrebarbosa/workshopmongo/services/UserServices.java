package com.alexandrebarbosa.workshopmongo.services;

import com.alexandrebarbosa.workshopmongo.domain.User;
import com.alexandrebarbosa.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository rep;

    public List<User> findAll() {
       return rep.findAll();
    }

}
