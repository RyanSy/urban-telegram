package com.example.Urbantelegram.services;

import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(User user){ userRepo.save(user); }

    public User getUserByUsernameAndPassword(String username, String password){
        return userRepo.getUserByUsernameAndPassword(username, password); }

    public void updateUser(User user) { userRepo.save(user); }

    public void deleteUser(User user) { userRepo.delete(user); }
}
