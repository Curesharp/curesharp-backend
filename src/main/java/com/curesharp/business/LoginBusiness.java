package com.curesharp.business;

import com.curesharp.dto.DadosLoginUsuario;
import com.curesharp.model.Usuario;
import com.curesharp.repository.UsuarioRepository;

public class LoginBusiness {

    private UsuarioRepository repository;

    public Usuario logar(DadosLoginUsuario dados) throws Exception {
        repository = new UsuarioRepository();
        Usuario usuario = repository.bucarPorEmail(dados.getEmail());

        if(usuario.getEmail() == null){
            throw new Exception("Usuário ou senha inválido");
        }

        if(!usuario.getSenha().equals(dados.getSenha())){
            throw new Exception("Usuário ou senha inválido");
        }

        return usuario;
    }
}
