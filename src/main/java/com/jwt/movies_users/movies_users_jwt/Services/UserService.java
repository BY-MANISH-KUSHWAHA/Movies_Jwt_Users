package com.jwt.movies_users.movies_users_jwt.Services;


import com.jwt.movies_users.movies_users_jwt.Models.User;
import com.jwt.movies_users.movies_users_jwt.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository repository,TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId id){
        Optional<User> result = repository.findById(id);
        return result.orElseGet(result::get);
    }


    public String saveUser(User user){
        User savedUser = repository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created A User\","+
                "\"data\":"+savedUser+","+
                "\"token\":\""+tokenService.createToken(savedUser.getId())+"\"}";
    }


}
