package com.pawelpiechowiak.manager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void index() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

//    @Test
//    public void table() throws Exception{
//        this.mockMvc.perform(get("/table"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("table"));
//    }
//
//    @Test
//    public void adjust() throws Exception{
//        this.mockMvc.perform(get("/adjust"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("adjust"));
//    }
}