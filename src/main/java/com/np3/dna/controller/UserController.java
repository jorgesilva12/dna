package com.np3.dna.controller;

import com.np3.dna.model.User;
import com.np3.dna.service.UserService;
import com.np3.dna.service.impl.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ImplUserService userService;
    @GetMapping()
    public String user(){return "Bem vindo ao cadastro de user.";}
    @GetMapping("/list")
    public List<User> list(){return userService.list();}
    @PostMapping("/create")
    public User create(@RequestBody User user){return userService.create(user);}   
    @PutMapping("/update")
    public User update(@RequestBody User user){return userService.update(user);}
    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "uuid") UUID uuid){return userService.delete(uuid);}
}
