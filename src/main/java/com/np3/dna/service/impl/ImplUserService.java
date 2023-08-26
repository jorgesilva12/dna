package com.np3.dna.service.impl;

import com.np3.dna.model.User;
import com.np3.dna.repository.UserRepository;
import com.np3.dna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImplUserService implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String user() {
        return null;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {return userRepository.save(user); }

    @Override
    public String delete(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if(user.isEmpty()){
            throw new RuntimeException("User not found.");
        }else{
            userRepository.deleteById(uuid);
            return  "User deleted with success";
        }
    }
}
