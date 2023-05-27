package com.np3.dna.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {
    @PreAuthorize("permitAll")
    @GetMapping
    public String user(){return "User - this method is in build";}

}
