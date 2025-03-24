package com.empresa.erp.services;

import com.empresa.erp.enums.Role;
import com.empresa.erp.models.UserModel;
import com.empresa.erp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    @Transactional
    public UserModel cadastrarUsuario(String username, String password, Role role, String cpf, String telefone) {
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(passwordEncoder.encode(password));
        userModel.setRole(role);
        userModel.setCpf(cpf);
        userModel.setTelefone(telefone);

        return userRepository.save(userModel);
    }

    // Método para buscar um usuário pelo username
    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Método para validar credenciais e retornar mensagens específicas
    public String validarCredenciais(String username, String password) {
        Optional<UserModel> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            return "Usuário não cadastrado"; // Usuário não encontrado
        }

        UserModel user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Senha incorreta"; // Senha incorreta
        }

        return "Login bem-sucedido"; // Credenciais válidas
    }
}