package com.pawelpiechowiak.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserController {

    @Autowired
    private UserProvider userProvider;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        private ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") int id) {
        if (userProvider.getUser(id) != null) {
            return userProvider.getUser(id).getName();
        }else {
            throw new ResourceNotFoundException("The user does not exist.");
        }
    }

    @GetMapping(value = "/index/{id}")
    public String main(Model model, @PathVariable("id") int id) {
        if (userProvider.getUser(id) != null) {
            model.addAttribute("users", userProvider.getUsers());
        } else {
            throw new ResourceNotFoundException("The user does not exist.");
        }
        return "welcome"; //view
    }

}


