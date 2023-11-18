package com.curesharp.repository;

import com.curesharp.business.UsuarioBusiness;
import com.curesharp.config.h2.ConnectionFactoryH2;
import com.curesharp.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioRepository {

    public Connection conexao;

    public UsuarioRepository() throws SQLException, ClassNotFoundException {
        super();
        this.conexao = new ConnectionFactoryH2().conexao();
    }

    public void inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO USUARIO(EMAIL, NOME, SENHA) VALUES (?, ?, ?)");
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getSenha());
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Usuário cadastrado com sucesso");
    }

    public ArrayList<Usuario> listar() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(rs.getLong(1));
            usuario.setEmail(rs.getString(2));
            usuario.setNome(rs.getString(3));
            usuario.setSenha(rs.getString(4));

            listaUsuarios.add(usuario);
        }

        rs.close();
        stmt.close();

        return listaUsuarios;
    }

    public Usuario bucarPorId(Long id) throws SQLException {
        Usuario usuario = new Usuario();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO WHERE ID_USUARIO = ?");
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            usuario.setIdUsuario(rs.getLong(1));
            usuario.setEmail(rs.getString(2));
            usuario.setNome(rs.getString(3));
            usuario.setSenha(rs.getString(4));
        }

        rs.close();
        stmt.close();

        return usuario;
    }

    public Usuario bucarPorEmail(String email) throws SQLException {
        Usuario usuario = new Usuario();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ?");
        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            usuario.setIdUsuario(rs.getLong(1));
            usuario.setEmail(rs.getString(2));
            usuario.setNome(rs.getString(3));
            usuario.setSenha(rs.getString(4));
        }

        rs.close();
        stmt.close();

        return usuario;
    }

    public void alterar(Long id, Usuario usuario) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("UPDATE USUARIO SET EMAIL = ?, NOME = ?, SENHA = ? WHERE ID_USUARIO = ?");
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getSenha());
        stmt.setLong(4, id);
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Usuário atualizado com sucesso");
    }

    public void deletar(Long id) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO = ?");
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Usuário deletado com sucesso");
    }





    public String buscarEmail(String email) throws SQLException {
        String emailBanco = null;

        PreparedStatement stmt = conexao.prepareStatement("SELECT EMAIL FROM USUARIO WHERE EMAIL = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            emailBanco = rs.getString(1);
        }

        rs.close();
        stmt.close();

        return emailBanco;
    }

}
