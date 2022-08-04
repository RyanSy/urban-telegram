package com.example.Urbantelegram.controllers;

import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.services.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

    @InjectMocks
    RoomController roomController;

    @Mock
    RoomService roomService;


    @Mock
    User user;
    private final Room room = new Room(1,user, "Password", "Chatroom", "A place to talk");

    @Test
    void testRoomCreation(){
        roomController.createRoom(room);

        verify(roomService).createRoom(room);
    }

    @Test
    void testRoomDeletion(){
        roomController.deleteRoom(room);

        verify(roomService).deleteRoom(room);
    }
}
