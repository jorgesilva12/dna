package com.np3.dna.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "np3_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Long number;

    @ManyToMany
    @JoinTable( name = "np3_user_role", 
            joinColumns = @JoinColumn(name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id"))

    private List<Role> roles = new ArrayList<>();

}
