package com.empresa.erp.controllers;

import com.empresa.erp.dtos.LoginDTO;
import com.empresa.erp.dtos.UserDTO;
import com.empresa.erp.enums.Role;
import com.empresa.erp.models.UserModel;
import com.empresa.erp.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        // Busca o usuário pelo username
        Optional<UserModel> userOpt = userService.findByUsername(loginDTO.getUsername());
        if (userOpt.isPresent()) {
            UserModel user = userOpt.get();
            // Verifica se a senha está correta (usando PasswordEncoder)
            if (userService.getPasswordEncoder().matches(loginDTO.getPassword(), user.getPassword())) {
                // Retorne uma resposta de sucesso (ou um token JWT, se estiver usando autenticação)
                return ResponseEntity.ok().body("Login bem-sucedido");
            } else {
                // Retorne uma resposta de erro
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        } else {
            // Retorne uma resposta de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não cadastrado");
        }
    }

    @PostMapping
    public UserModel cadastrarUsuario(@RequestBody UserDTO userDTO) {
        return userService.cadastrarUsuario(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getCpf(),
                userDTO.getTelefone()
        );
    }
}