package com.fiap.agricultura.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET =
            "AgriculturaInteligenteComDadosEspaciais2026JWT";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public String gerarToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000 // 24 horas
                        )
                )
                .signWith(key)
                .compact();
    }

    public String extrairEmail(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean tokenValido(
            String token,
            String email) {

        String emailToken = extrairEmail(token);

        return emailToken.equals(email)
                && !tokenExpirado(token);
    }

    private boolean tokenExpirado(String token) {

        Date expiracao = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        return expiracao.before(new Date());
    }
}