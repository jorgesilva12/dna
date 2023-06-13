package com.np3.dna.service.impl;

import com.np3.dna.model.User;
import com.np3.dna.model.form.UserForm;
import com.np3.dna.repository.UserRepository;
import com.np3.dna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User create(UserForm userForm) {
        Optional<User> userOptional = findByUserName(userForm.getUsername());
        User user = new User();
        if (userOptional.isEmpty()){
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setUsername(userForm.getUsername());
            user.setPassword(encoder.encode(userForm.getPassword()));
            userForm.getRoles().forEach(role -> {
                user.getRoles().add(role);;
            });
        return userRepository.save(user);
        }else {
            throw new RuntimeException("Exist a count with username: "+userForm.getName());
        }
    }

    @Override
    public User update(UserForm userForm) {
        Optional<User> userOptional = findByUserName(userForm.getUsername());
        User user = new User();
        if (!userOptional.isEmpty()){
            user.setId(userOptional.get().getId());
            user.setName(userOptional.get().getUsername());
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setEmail(encoder.encode(userForm.getPassword()));
            userForm.getRoles().forEach(role -> {
                user.getRoles().add(role);
            });
        return userRepository.save(user);
        }else{
            throw new RuntimeException("User not found with name:" + userForm.getName());
        }
    }

    @Override
    public User delete(UUID uuid) {
        Optional<User> userOptional = userRepository.findById(uuid);
        if(userOptional.isEmpty()){
            throw new RuntimeException("Not found a user with id:"+uuid);
        }else {
            userRepository.deleteById(uuid);
            return userOptional.get();
        }
    }

    @Override
    public User createStart(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getId(UUID uuid) {
        return userRepository.getById(uuid);
    }
}
