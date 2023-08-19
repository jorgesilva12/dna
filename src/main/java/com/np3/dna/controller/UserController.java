package com.np3.dna.controller;

import com.np3.dna.model.User;
import com.np3.dna.service.UserService;
import com.np3.dna.service.impl.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ImplUserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user){return userService.create(user);}
}
