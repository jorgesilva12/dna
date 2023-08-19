package com.np3.dna.service.impl;

import com.np3.dna.model.User;
import com.np3.dna.repository.UserRepository;
import com.np3.dna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public String delete(UUID uuid) {
        return null;
    }
}
