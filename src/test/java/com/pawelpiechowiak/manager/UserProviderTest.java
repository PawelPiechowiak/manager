package com.pawelpiechowiak.manager;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserProviderTest {

    private UserProvider userProvider;

    @Before
    public void setUp() throws IOException {
        userProvider = new UserProvider();
    }

    @Test
    public void getUserWithAppropriateIndex() {
        assertEquals("Gwenborough", userProvider.getUser(1).getAddress().getCity());
    }

    @Test
    public void getUserWithWrongIndex() {
        assertNull(userProvider.getUser(-1));
    }
}