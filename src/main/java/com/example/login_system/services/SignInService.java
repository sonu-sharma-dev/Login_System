package com.example.login_system.services;

import com.example.login_system.Entities.User;
import com.example.login_system.repositories.SignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignInService {
    @Autowired
    private SignRepo signInRepository;


    public String createUserAccount(User user){
        try{

           signInRepository.save(user);

            return "User Created Successfully!";
        }
        catch (Exception e){
            e.printStackTrace();

            return "Something went wrong!!";
        }
    }

        public String logInUser(String username, String password) {
            // Retrieve the user by username from the database
            Optional<User> optionalUser = SignRepo.findByUsername(username);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                // Check if the provided password matches the stored password
                if (password.equals(user.getPassword())) {
                    // Successful login
                    return "success";
                } else {
                    // Incorrect password
                    return "Incorrect password";
                }
            } else {
                // User not found
                return "User not found";
            }
        }
}
