package com.np3.dna.service.impl;

import com.np3.dna.model.Role;
import com.np3.dna.repository.RoleRepository;
import com.np3.dna.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImplRoleService implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public String role() {
        return null;
    }

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public String delete(UUID uuid) {
        Optional<Role> role = roleRepository.findById(uuid);
        if(role.get() == null){
            throw new RuntimeException("Role not found.");
        }else {
            roleRepository.deleteById(uuid);
            return "Role deleted with sucess!!!";
        }
    }
}
