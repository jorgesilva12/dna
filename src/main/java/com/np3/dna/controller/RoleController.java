package com.np3.dna.controller;

import com.np3.dna.model.Role;
import com.np3.dna.service.RoleService;
import com.np3.dna.service.impl.ImplRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private ImplRoleService roleService;
    @GetMapping()
    String role(){return "A página de cadastro de Roles está em desenvolvimento.";}
    @GetMapping("/list")
    List<Role> list(){return roleService.list();}
    @PostMapping("/create")
    Role create(@RequestBody Role role){return roleService.create(role);}
    @PutMapping("/update")
    Role update(@RequestBody Role role){return roleService.update(role);}
    @DeleteMapping("/delete")
    String delete(@RequestParam(value = "uuid") UUID uuid){return roleService.delete(uuid);}
}
