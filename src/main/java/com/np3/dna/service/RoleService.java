package com.np3.dna.service;

import com.np3.dna.enums.RoleName;
import com.np3.dna.model.Role;

import java.util.Optional;

public interface RoleService {
    public Optional<Role> findByRoleName(RoleName roleName);
    public Role roleName(RoleName roleName);
    public Role create(Role role);
}
