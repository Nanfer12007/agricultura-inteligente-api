package com.fiap.agricultura.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.fiap.agricultura.entity.Usuario;
import com.fiap.agricultura.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        System.out.println("BUSCANDO USUARIO: " + email);

        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));

        System.out.println("USUARIO ENCONTRADO: " + usuario.getEmail());

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getRole().name())
                .build();
    }
}