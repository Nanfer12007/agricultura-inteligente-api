package com.fiap.agricultura.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Email(message = "Email inválido")
        String email,

        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
        String senha

) {
}