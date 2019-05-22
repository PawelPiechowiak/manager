package com.pawelpiechowiak.manager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserProvider {

    private List<User> users;

    public UserProvider() throws IOException {
        users = new ArrayList<>();
        String webPage = "http://jsonplaceholder.typicode.com/users";

        try (InputStream is = new URL(webPage).openStream();
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            for (JsonElement element : jsonArray) {
                users.add(gson.fromJson(element, User.class));
            }
        }
    }
    public User getUser(int index){
        if(index > 0 && index <= 10){
            return users.get(index-1);
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
