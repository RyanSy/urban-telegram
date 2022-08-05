package com.example.Urbantelegram.services;

import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.repo.RoomRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @InjectMocks
    RoomService roomService;

    @Mock
    RoomRepo roomRepo;

    @Mock
    User user;

    private final Room room = new Room(1,user, "Password", "Chatroom", "A place to talk");

    private List<Room> rooms = new ArrayList<>();



    @Test
    void testRoomCreation(){
        roomService.createRoom(room);

        verify(roomRepo).save(room);
    }

    @Test
    void testRoomDeletion(){
        roomService.deleteRoom(room);

        verify(roomRepo).delete(room);
    }

    @Test
    void testGetRoomsByOwner(){
        rooms.add(room);
        when(roomRepo.findByOwner(any(User.class))).thenReturn(rooms);
        List<Room> result = roomService.findByOwner(user);
        assertEquals(rooms, result);
    }



}
