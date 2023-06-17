package com.np3.dna.controller;

import com.np3.dna.model.Role;
import com.np3.dna.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RoleController {
    @Autowired
    public RoleServiceImpl roleService;
    @PreAuthorize("permitAll")
    @GetMapping
    public String role(){return "WelCome to Roles";}

    @PreAuthorize("permitAll")
    @GetMapping("/getAll")
    public List<Role> getAll(){return roleService.getAll();}

}
