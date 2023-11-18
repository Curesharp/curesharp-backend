package com.curesharp.business;


import com.curesharp.model.Usuario;
import com.curesharp.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBusiness {

    private UsuarioRepository repository;

    public void inserirUsuario(Usuario usuario) throws Exception {
        repository = new UsuarioRepository();
        String verificacaoEmail = repository.buscarEmail(usuario.getEmail());

        if(verificacaoEmail != null){
            throw new Exception("Esse usuário já foi cadastrado na nossa base de dados");
        }

        repository.inserir(usuario);
    }

    public ArrayList<Usuario> listarUsuarios() throws Exception {
        repository = new UsuarioRepository();
        return repository.listar();
    }

    public  Usuario bucarUsuarioPorId(Long id) throws Exception {
        repository = new UsuarioRepository();
        Usuario usuario = repository.bucarPorId(id);

        if(usuario.getIdUsuario() == null){
            throw new Exception("O usuário não foi encontrado");
        } else {
            return usuario;
        }
    }

    public  Usuario bucarUsuarioPorEmail(String email) throws Exception {
        repository = new UsuarioRepository();
        Usuario usuario = repository.bucarPorEmail(email);

        if(usuario.getEmail() == null){
            throw new Exception("O e-mail não foi encontrado");
        } else {
            return usuario;
        }
    }

    public void atualizarUsuario(Long id, Usuario usuario) throws Exception {
        repository = new UsuarioRepository();
        Usuario usuarioBanco = repository.bucarPorId(id);

        if(usuarioBanco.getIdUsuario() == null){
            throw new Exception("Não foi possivel encontrar esse usuário");
        }

        repository.alterar(id, usuario);
    }

    public void deletarUsuario(Long id) throws Exception {
        repository = new UsuarioRepository();
        Usuario usuario = repository.bucarPorId(id);

        if(usuario.getIdUsuario() == null){
            throw new Exception("Não foi possivel encontrar esse usuário");
        }

        repository.deletar(id);
    }

}
