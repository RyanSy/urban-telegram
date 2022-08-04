package com.example.Urbantelegram.repo;

import com.example.Urbantelegram.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User getUserByUsernameAndPassword(String username, String password);
}
