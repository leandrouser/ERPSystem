package com.empresa.erp.services;

import com.empresa.erp.enums.Papel;
import com.empresa.erp.models.Usuario;
import com.empresa.erp.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional // Garante que a operação seja executada em uma transação
    public Usuario cadastrarUsuario(String username, String password, Papel papel, String cpf, String telefone) {
        // Valida CPF e telefone (obrigatórios para todos)
        if (cpf == null || cpf.isEmpty()) {
            throw new RuntimeException("CPF é obrigatório.");
        }
        if (telefone == null || telefone.isEmpty()) {
            throw new RuntimeException("Telefone é obrigatório.");
        }

        // Cria o usuário
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password)); // Criptografa a senha

        Set<Papel> papeis = new HashSet<>();
        papeis.add(papel);
        usuario.setPapeis(papeis);

        usuario.setCpf(cpf);
        usuario.setTelefone(telefone);

        // Salva o usuário no banco de dados
        return usuarioRepository.save(usuario);
    }
}