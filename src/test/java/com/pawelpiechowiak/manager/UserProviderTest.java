package com.pawelpiechowiak.manager;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserProviderTest {

    private UserProvider userProvider;

    @Before
    public void setUp() throws IOException {
        userProvider = new UserProvider();
    }

    @Test
    public void getUsers() {
        assertEquals("Gwenborough", userProvider.getUsers().get(0).getAddress().getCity());
    }

    @Test
    public void checkIfUsersAreNull() {
        assertNotNull(userProvider.getUsers());
    }
}