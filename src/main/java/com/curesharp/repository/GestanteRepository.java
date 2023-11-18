package com.curesharp.repository;

import com.curesharp.config.h2.ConnectionFactoryH2;
import com.curesharp.model.Gestante;
import com.curesharp.util.Raca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestanteRepository {

    public Connection conexao;

    public GestanteRepository() throws SQLException, ClassNotFoundException {
        super();
        this.conexao = new ConnectionFactoryH2().conexao();
    }

    public void inserir(Gestante gestante) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO GESTANTE (ID_USUARIO, NOME_GESTANTE, RG, RACA, CONTATO) " +
                "VALUES (?, ?, ?, ?, ?)");
        stmt.setLong(1, gestante.getIdUsuario());
        stmt.setString(2, gestante.getNome());
        stmt.setString(3, gestante.getRg());
        stmt.setString(4, String.valueOf(gestante.getRaca()));
        stmt.setLong(5, gestante.getContato());
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Gestante cadastrada com sucesso");
    }

    public ArrayList<Gestante> listar() throws SQLException {
        ArrayList<Gestante> listaGestantes = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM GESTANTE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Gestante gestante = new Gestante();
            gestante.setIdGestante(rs.getLong(1));
            gestante.setIdUsuario(rs.getLong(2));
            gestante.setNome(rs.getString(3));
            gestante.setRg(rs.getString(4));
            gestante.setRaca(Raca.valueOf(rs.getString(5)));
            gestante.setContato(rs.getLong(6));

            listaGestantes.add(gestante);
        }

        rs.close();
        stmt.close();

        return listaGestantes;
    }

    public Gestante bucarPorID(Long id) throws SQLException {
        Gestante gestante = new Gestante();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM GESTANTE WHERE ID_GESTANTE = ?");
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            gestante.setIdGestante(rs.getLong(1));
            gestante.setIdUsuario(rs.getLong(2));
            gestante.setNome(rs.getString(3));
            gestante.setRg(rs.getString(4));
            gestante.setRaca(Raca.valueOf(rs.getString(5)));
            gestante.setContato(rs.getLong(6));
        }

        rs.close();
        stmt.close();

        return gestante;
    }

    public Gestante bucarPorRG(String rg) throws SQLException {
        Gestante gestante = new Gestante();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM GESTANTE WHERE RG = ?");
        stmt.setString(1, rg);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            gestante.setIdGestante(rs.getLong(1));
            gestante.setIdUsuario(rs.getLong(2));
            gestante.setNome(rs.getString(3));
            gestante.setRg(rs.getString(4));
            gestante.setRaca(Raca.valueOf(rs.getString(5)));
            gestante.setContato(rs.getLong(6));
        }

        rs.close();
        stmt.close();

        return gestante;
    }

    public void alterar(Long id, Gestante gestante) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("UPDATE GESTANTE SET " +
                "ID_USUARIO = ?, NOME_GESTANTE = ?, RACA = ?, CONTATO = ? " +
                "WHERE ID_GESTANTE = ?");
        stmt.setLong(1, gestante.getIdUsuario());
        stmt.setString(2, gestante.getNome());
        stmt.setString(3, String.valueOf(gestante.getRaca()));
        stmt.setLong(4, gestante.getContato());
        stmt.setLong(5, id);
        stmt.execute();

        stmt.close();

        System.out.println("[INFO] Gestante atualizada com sucesso");
    }

    public void deletar(Long id) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM GESTANTE WHERE ID_GESTANTE = ?");
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Gestante deletada com sucesso");
    }
}
