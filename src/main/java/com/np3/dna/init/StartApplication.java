package com.np3.dna.init;

import com.np3.dna.model.Role;
import com.np3.dna.model.User;
import com.np3.dna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private StartRole startRole;
    @Autowired
    private PasswordEncoder encoder;
    @Value("${security.password}")
    private String password;
    @Value("${security.name}")
    private String name;
    @Value("${security.username}")
    private String username;
    @Value("${security.email}")
    private String email;
    @Value("${security.number}")
    private Long number;


    @Override
    public void run(String... args) throws Exception {

        // Criação automatica da tabelas de Roles
        Role roleAdmin = startRole.startRole();

        // Criação automatica do usuário admin
        Optional<User> userOptional = userService.findByUsername(username);
        if(userOptional.isEmpty()){
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(encoder.encode(password));
            user.setEmail(email);
            user.setNumber(number);
            user.getRoles().add(roleAdmin);
            userService.createStart(user);
        }
    }
}
