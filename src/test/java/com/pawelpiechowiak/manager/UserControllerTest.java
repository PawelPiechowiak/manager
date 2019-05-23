package com.pawelpiechowiak.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    public void index() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void table() throws Exception {
        when(userProvider.getUsers()).thenReturn(new UserProvider().getUsers());
        mockMvc.perform(get("/table"))
                .andExpect(status().isOk())
                .andExpect(view().name("table"));
    }

    @Test
    public void adjust() throws Exception {
        when(userProvider.getUsers()).thenReturn(new UserProvider().getUsers());
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("adjust"));
    }
}