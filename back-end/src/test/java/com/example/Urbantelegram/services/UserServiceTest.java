package com.example.Urbantelegram.services;

import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepo userRepo;

    private User user = new User("username","password");

    @Test
    public void createUser() {
        userService.createUser(user);

        verify(userRepo).save(user);
    }

    @Test
    void getUserByUsername() {
        when(userRepo.getUserByUsernameAndPassword(any(String.class), any(String.class))).thenReturn(user);
        User result = userService.getUserByUsernameAndPassword("username","password");
        assertEquals(user, result);
    }

    @Test
    void updateUser() {
        userService.updateUser(user);

        verify(userRepo).save(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(user);

        verify(userRepo).delete(user);
    }

}