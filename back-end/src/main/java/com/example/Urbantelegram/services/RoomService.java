package com.example.Urbantelegram.services;

import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public void createRoom(Room room){
        roomRepo.save(room);
    }

    public void deleteRoom(Room room){
        roomRepo.delete(room);
    }
}
