package com.np3.dna.service;

import com.np3.dna.model.Role;
import com.np3.dna.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    String user();// Classe da pagina de cadastro
    List<User> list();// Trás todos os usuarios cadastradas
    User create(User user);// Inclui usuario
    User update(User user);// Altera usuario
    String delete(UUID uuid);// Deleta usuario
}
