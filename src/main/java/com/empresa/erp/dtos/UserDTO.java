package com.empresa.erp.dtos;

import com.empresa.erp.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO {
    @Schema(description = "Nome de usuário", example = "usuario_teste")
    private String username;

    @Schema(description = "Senha do usuário", example = "senha123")
    private String password;

    @Schema(description = "Papel do usuário", example = "ADMIN", allowableValues = {"ADMIN", "VENDEDOR", "CLIENTE"})
    private Role role;

    @Schema(description = "CPF do usuário", example = "12345678901")
    private String cpf;

    @Schema(description = "Telefone do usuário", example = "11987654321")
    private String telefone;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}