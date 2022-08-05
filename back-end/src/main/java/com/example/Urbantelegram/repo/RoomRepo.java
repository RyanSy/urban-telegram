package com.example.Urbantelegram.repo;

import com.example.Urbantelegram.models.Room;
import com.example.Urbantelegram.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Integer> {

    List<Room> findByOwner(User owner_id);
}
