package com.np3.dna.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Long number;
    private List<Role> roles = new ArrayList<>();

}
