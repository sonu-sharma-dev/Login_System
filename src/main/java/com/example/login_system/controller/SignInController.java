package com.example.login_system.controller;

import com.example.login_system.Entities.User;
import com.example.login_system.services.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class SignInController {
    @Autowired
    private SignInService signInService;


   @PostMapping("/create")
    public String create_Acc(@RequestBody User user){
       return signInService.createUserAccount(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestParam String username, @RequestParam String password) {
        String result = signInService.logInUser(username, password);

        if (result.equals("success")) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed: " + result, HttpStatus.UNAUTHORIZED);
        }
    }



}
