package com.pawelpiechowiak.manager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    private List<User> users;

    public UserProvider() {
        this.users = new ArrayList<>();
    }

    public List<User> deserialize() throws IOException {
        String webPage = "http://jsonplaceholder.typicode.com/users";

        try (InputStream is = new URL(webPage).openStream();
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            for(JsonElement element: jsonArray){
                users.add(gson.fromJson(element, User.class));
            }
            return users;
        }
    }
}
