package com.np3.dna.repository;

import com.np3.dna.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

}
