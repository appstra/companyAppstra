package com.appstra.company.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.ArrayList;

@Component
public class TokenFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "Appstr@2024"; // Clave secreta utilizada para firmar y verificar el token JWT. Cambia esto si usas HS256.

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Obtener el encabezado "Authorization" de la solicitud
        final String authorizationHeader = request.getHeader("Authorization");

        // Verificar si el encabezado "Authorization" existe y comienza con "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extraer el token JWT, eliminando el prefijo "Bearer "
            String jwt = authorizationHeader.substring(7);
            try {
                // Verificar y analizar el token JWT usando la clave secreta
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY) // Usar la clave secreta para verificar el token
                        .parseClaimsJws(jwt) // Parsear el JWT
                        .getBody(); // Obtener los "claims" del cuerpo del token

                // Crear un objeto de autenticación con los "claims" extraídos (usualmente el "subject" es el usuario)
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        claims.getSubject(), null, new ArrayList<>()); // El usuario (subject) se establece como el principal
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // Agregar detalles adicionales a la autenticación
                SecurityContextHolder.getContext().setAuthentication(authentication); // Establecer la autenticación en el contexto de seguridad de Spring

            } catch (Exception e) {
                // Si ocurre un error (token inválido o expirado), se captura la excepción
                System.out.println("Token inválido: " + e.getMessage()); // Imprimir el mensaje de error
            }
        }

        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}

