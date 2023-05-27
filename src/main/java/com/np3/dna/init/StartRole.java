package com.np3.dna.init;

import com.np3.dna.enums.RoleName;
import com.np3.dna.model.Role;
import com.np3.dna.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StartRole {
    @Autowired
    private RoleServiceImpl roleService;

    public Role startRole(){
        List<RoleName> roleNames = Arrays.asList(RoleName.values());
        Role roleAdmin = new Role();
        for(int i = 0; i < roleNames.size(); i++){
            Optional<Role> roleOptional = roleService.findByRoleName(roleNames.get(i));
            Role role = new Role();
            if (roleOptional.isEmpty()){
                role.setRoleName(roleNames.get(i));
                if (roleNames.get(i) == RoleName.ROLE_ADMIN){
                    roleAdmin = roleService.create(role);
                }else{
                    roleService.create(role);
                }
            }else{
                if(roleNames.get(i) == RoleName.ROLE_ADMIN) roleAdmin =roleOptional.get();
            }
        }
        return roleAdmin;
    }
}
