package com.np3.dna.service.impl;

import com.np3.dna.enums.RoleName;
import com.np3.dna.model.Role;
import com.np3.dna.repository.RoleRepository;
import com.np3.dna.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Role> findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role roleName(RoleName roleName) {
        Optional<Role> roleOptional = roleRepository.findByRoleName(roleName);
        Role role = roleOptional.get();
        return role;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAll() {return roleRepository.findAll(); }
}
