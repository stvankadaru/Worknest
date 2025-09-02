package com.worknest.service;

import com.worknest.entity.User;
import com.worknest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    // 🔹 Add this method
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
