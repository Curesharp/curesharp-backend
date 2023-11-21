package com.curesharp.business;

import com.curesharp.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class TokenBusiness {


    public Usuario pegarUsuarioPeloToken(String tokeHeader) throws Exception {
        try {
            String token = extrairToken(tokeHeader);

            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey("RJY4rJL6Mq3pgxY0aBZVf/kwVqT6JvPCvHb5ORX8YQg=")
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jws.getBody();

            UsuarioBusiness business = new UsuarioBusiness();
            Usuario usuario = business.bucarUsuarioPorEmail(claims.getSubject());

            return usuario;
        } catch (Exception e) {
            throw new Exception("Token JWT inválido");
        }
    }

    private String extrairToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7).trim();
        }
        return null;
    }

}
