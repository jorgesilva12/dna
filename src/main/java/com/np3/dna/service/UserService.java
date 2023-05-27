package com.np3.dna.service;

import com.np3.dna.model.User;
import com.np3.dna.model.form.UserForm;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> findByUserName(String username);
    User create(UserForm userForm);
    User update(UserForm userForm);
    User delete(UUID uuid);
    User createStart(User user);
}
