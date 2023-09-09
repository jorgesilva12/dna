package com.np3.dna.service;

import com.np3.dna.enums.RoleName;
import com.np3.dna.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    String role();// Classe da pagina de cadastro
    List<Role> list();// Trás todas as roles cadastradas
    Role create(Role role);// Inclui role
    Role update(Role role);// Altera role
    String delete(UUID uuid);// Deleta role
    Optional<Role> findByRoleName(RoleName roleName);
}
