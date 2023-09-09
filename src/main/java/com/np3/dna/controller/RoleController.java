package com.np3.dna.controller;

import com.np3.dna.model.Role;
import com.np3.dna.service.RoleService;
import com.np3.dna.service.impl.ImplRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RoleController {
    @Autowired
    private ImplRoleService roleService;
    @GetMapping()
    @PreAuthorize("permitAll")
    String role(){return "A página de cadastro de Roles está em desenvolvimento.";}
    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Role> list(){return roleService.list();}
    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Role create(@RequestBody Role role){return roleService.create(role);}
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Role update(@RequestBody Role role){return roleService.update(role);}
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String delete(@RequestParam(value = "uuid") UUID uuid){return roleService.delete(uuid);}
}
