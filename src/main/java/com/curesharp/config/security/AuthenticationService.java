package com.curesharp.config.security;

import com.curesharp.dto.DadosLoginUsuario;
import com.curesharp.model.Usuario;
import com.curesharp.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {

    private static final String SECRET_KEY = "RJY4rJL6Mq3pgxY0aBZVf/kwVqT6JvPCvHb5ORX8YQg=";

    public String generateToken(DadosLoginUsuario dadosLoginUsuario) throws Exception {

        boolean usuarioAutenticado = autenticacaoUsuario(dadosLoginUsuario);

        UsuarioRepository repository = new UsuarioRepository();
        Usuario usuario = repository.bucarPorEmail(dadosLoginUsuario.getEmail());

        if(usuarioAutenticado){
            return Jwts.builder()
                    .setSubject(usuario.getEmail())
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        } else {
            throw new Exception("E-mail ou senha inválido(a)");
        }
    }

    public boolean autenticacaoUsuario(DadosLoginUsuario dados) throws Exception {
        UsuarioRepository repository = new UsuarioRepository();
        Usuario usuario = repository.bucarPorEmail(dados.getEmail());

        if(usuario.getEmail() == null){
            throw new Exception("E-mail ou senha inválido(a)");
        }

        return usuario.getSenha().equals(dados.getSenha());
    }
}
