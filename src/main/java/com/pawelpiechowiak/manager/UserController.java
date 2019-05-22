package com.pawelpiechowiak.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserController {

    @Autowired
    private UserProvider userProvider;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private class ResourceNotFoundException extends RuntimeException {
        private ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/table")
    public String table(Model model) {
        if (userProvider.getUsers().isEmpty()) {
            throw new ResourceNotFoundException("The resource does not exist.");
        } else {
            model.addAttribute("users", userProvider.getUsers());
            return "table";
        }
    }

    @GetMapping(value = "/users")
    public String adjust(Model model) {
        if (userProvider.getUsers().isEmpty()) {
            throw new ResourceNotFoundException("The resource does not exist.");
        } else {
            model.addAttribute("users", userProvider.getUsers());
            return "adjust";
        }
    }

}


