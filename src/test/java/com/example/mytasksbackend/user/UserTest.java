package com.example.mytasksbackend.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void createUserWithId() {
        User user = new User("John", "john@email.com", "123456");

        assertEquals("John", user.getName());
        assertEquals("john@email.com", user.getEmail());
        assertEquals("123456", user.getPassword());
        assertNotNull(user.getId());
        assertNotNull(user.getCreatedAt());
    }
}
