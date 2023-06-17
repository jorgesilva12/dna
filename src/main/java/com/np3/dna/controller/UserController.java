package com.np3.dna.controller;

import com.np3.dna.model.User;
import com.np3.dna.model.form.UserForm;
import com.np3.dna.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {
    @Autowired
    private UserServiceImpl userService;;

    @PreAuthorize("permitAll")
    @GetMapping
    public String user(){return "User - this method is in build";}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getAll")
    public List<User> getAll(){return userService.getAll();}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getId/{uuid}")
    public User getId(@PathVariable() UUID uuid){return userService.getId(uuid);}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public User create(@RequestBody UserForm userForm){return userService.create(userForm);}

}
