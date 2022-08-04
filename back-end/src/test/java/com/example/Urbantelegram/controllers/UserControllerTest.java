package com.example.Urbantelegram.controllers;

import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Mock
    List<Room> rooms;

    private User user = new User("username","password", rooms);

    @Test
    void createUser() {
        userService.createUser(user);

        verify(userService).createUser(user);
    }

    @Test
    void getUserByUsernameAndPassword() {
        userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        verify(userService).getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Test
    void updateUser() {
        userService.updateUser(user);

        verify(userService).updateUser(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(user);

        verify(userService).deleteUser(user);
    }
}