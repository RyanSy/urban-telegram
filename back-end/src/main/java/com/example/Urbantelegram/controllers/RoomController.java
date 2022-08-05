package com.example.Urbantelegram.controllers;


import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/")
    @ResponseBody
    public void createRoom(@RequestBody Room room){roomService.createRoom(room);}

    @GetMapping("/")
    @ResponseBody
    public List<Room> getRoomsByOwner(@RequestBody User user){
        return roomService.findByOwner(user);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteRoom(@RequestBody Room room) {roomService.deleteRoom(room);}

}
