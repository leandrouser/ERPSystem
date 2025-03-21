package com.empresa.erp.controllers;

import com.empresa.erp.enums.Papel;
import com.empresa.erp.models.Usuario;
import com.empresa.erp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrarUsuario(@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam Papel papel,
                                    @RequestParam String cpf,
                                    @RequestParam String telefone) {
        return usuarioService.cadastrarUsuario(username, password, papel, cpf, telefone);
    }
}