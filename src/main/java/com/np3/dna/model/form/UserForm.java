package com.np3.dna.model.form;

import com.np3.dna.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String name;
    private String username;
    private String password;
    private String email;
    private List<Role> roles = new ArrayList<>();
}
