package com.pawelpiechowiak.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserProvider userProvider;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
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
}
