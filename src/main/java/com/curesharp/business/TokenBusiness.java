package com.curesharp.business;

import com.curesharp.dto.DadosResponseUsuario;
import com.curesharp.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class TokenBusiness {


    public DadosResponseUsuario pegarUsuarioPeloToken(String tokeHeader) throws Exception {
        try {
            String token = extrairToken(tokeHeader);

            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey("RJY4rJL6Mq3pgxY0aBZVf/kwVqT6JvPCvHb5ORX8YQg=")
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jws.getBody();

            UsuarioBusiness business = new UsuarioBusiness();
            Usuario usuario = business.bucarUsuarioPorEmail(claims.getSubject());

            DadosResponseUsuario dadosUsuario = new DadosResponseUsuario(
                    usuario.getIdUsuario(),
                    usuario.getEmail(),
                    usuario.getNome()
            );

            return dadosUsuario;
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
