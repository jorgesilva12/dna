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
    private PasswordEncoder encoder;
    @Autowired
    private StartRole startRole;
    @Value("${security.password}")
    private String password;
    @Override
    public void run(String... args) throws Exception {
        Role roleadmin = startRole.startRole();

        Optional<User> userOptional = userService.findByUserName("admin");
        if(userOptional.isEmpty()){
            User user = new User();
            user.setName("adminsitrador");
            user.setEmail("admin@dna.com");
            user.setUsername("admin");
            user.setPassword(encoder.encode(password));
            user.getRoles().add(roleadmin);
            userService.createStart(user);
        }
    }
}
