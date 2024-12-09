package com.example.payment_gateway_app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.payment_gateway_app.entity.User;
import com.example.payment_gateway_app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;


public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        User user = User.builder()
                .username("test")
                .password("password")
                .email("abc@gmail.com")
                .build();
        User savedUser = User.builder()
                .id(1L).username("test")
                .password("password").email("abc@gmail.com").build();
        List<User> users = Collections.singletonList(savedUser);

        when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.getAllUsers();

        assert (user.getEmail()).equals(savedUser.getEmail());
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(user.getEmail(), result.get(0).getEmail());
        assertEquals(user.getUsername(), result.get(0).getUsername());
    }
}
