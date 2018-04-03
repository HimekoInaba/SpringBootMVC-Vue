package com.syrym.bootvue.bootvue.controller;

import com.syrym.bootvue.bootvue.model.User;
import com.syrym.bootvue.bootvue.pojos.UserRegistration;
import com.syrym.bootvue.bootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.regex.Pattern;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createnewuser")
    public String register(@RequestBody UserRegistration userRegistration){
        if(!userRegistration.getPassword().equals(userRegistration.getConfirmPassword()))
            return "Error the two passwords do not match";
        else if(userService.findByUsername(userRegistration.getUsername()) != null)
            return "Error this username already exists";

        //Checking for non alphanumerical characters in the username.
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if(pattern.matcher(userRegistration.getUsername()).find())
            return "No special characters are allowed in the username";

        userService.add(new User(userRegistration.getUsername(), userRegistration.getPassword(),
                userRegistration.getConfirmPassword(), userRegistration.getEmail()));
        return "User created";
    }
}
