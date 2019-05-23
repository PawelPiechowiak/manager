package com.pawelpiechowiak.manager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProvider userProvider;

    private List<User> users;

    @Before
    public void setUp() {
        users = new ArrayList<>();
        users.add(new User(new Address(new Geo()), new Company()));
        users.add(new User(new Address(new Geo()), new Company()));
    }

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void table() throws Exception {
        when(userProvider.getUsers()).thenReturn(users);
        mockMvc.perform(get("/table"))
                .andExpect(status().isOk())
                .andExpect(view().name("table"));
    }

    @Test
    public void adjust() throws Exception {
        when(userProvider.getUsers()).thenReturn(users);
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("adjust"));
    }
}