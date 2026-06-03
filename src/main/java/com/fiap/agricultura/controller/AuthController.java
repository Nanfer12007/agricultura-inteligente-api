package com.fiap.agricultura.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import com.fiap.agricultura.dto.request.LoginRequestDTO;
import com.fiap.agricultura.dto.response.LoginResponseDTO;
import com.fiap.agricultura.security.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(),
                        dto.senha()
                )
        );

        String token =
                jwtService.gerarToken(dto.email());

        return ResponseEntity.ok(
                new LoginResponseDTO(token)
        );
    }
}