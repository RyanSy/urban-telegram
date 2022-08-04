package com.example.Urbantelegram.controllers;


import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/")
    @ResponseBody
    public void createRoom(@RequestBody Room room){roomService.createRoom(room);}

    @DeleteMapping
    @ResponseBody
    public void deleteRoom(@RequestBody Room room) {roomService.deleteRoom(room);}

}
