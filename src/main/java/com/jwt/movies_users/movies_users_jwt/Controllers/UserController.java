package com.jwt.movies_users.movies_users_jwt.Controllers;

import com.jwt.movies_users.movies_users_jwt.Models.User;
import com.jwt.movies_users.movies_users_jwt.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUser")
    public User GatUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ObjectId userId =  (ObjectId) req.getAttribute("userId");
        if(userId==null){
            System.out.println("Null");
            res.sendError(HttpServletResponse.SC_BAD_REQUEST,"token Expired.");
            return null;
        }
        return  userService.getUser(userId);
    }

}

