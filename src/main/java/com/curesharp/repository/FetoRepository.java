package com.curesharp.repository;

import com.curesharp.config.h2.ConnectionFactoryH2;
import com.curesharp.model.Feto;
import com.curesharp.model.Gestante;
import com.curesharp.util.RacaEnum;
import com.curesharp.util.SexoEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetoRepository {
    public Connection conexao;

    public FetoRepository() throws SQLException, ClassNotFoundException {
        super();
        this.conexao = new ConnectionFactoryH2().conexao();
    }

    public void inserir(Feto feto) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO FETO (ID_GESTANTE, NOME, IDADE_SEMANAS, SEXO) " +
                "VALUES (?, ?, ?, ?)");
        stmt.setLong(1, feto.getIdGestante());
        stmt.setString(2, feto.getNome());
        stmt.setInt(3, feto.getIdade());
        stmt.setString(4, String.valueOf(feto.getSexo()));
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Feto cadastrado com sucesso");
    }

    public ArrayList<Feto> listar() throws SQLException {
        ArrayList<Feto> listaFetos = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM FETO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Feto feto = new Feto();
            feto.setIdFeto(rs.getLong(1));
            feto.setIdGestante(rs.getLong(2));
            feto.setNome(rs.getString(3));
            feto.setIdade(rs.getInt(4));
            feto.setSexo(SexoEnum.valueOf(rs.getString(5)));

            listaFetos.add(feto);
        }

        rs.close();
        stmt.close();

        return listaFetos;
    }

    public Feto bucarPorID(Long id) throws SQLException {
        Feto feto = new Feto();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM FETO WHERE ID_FETO = ?");
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            feto.setIdFeto(rs.getLong(1));
            feto.setIdGestante(rs.getLong(2));
            feto.setNome(rs.getString(3));
            feto.setIdade(rs.getInt(4));
            feto.setSexo(SexoEnum.valueOf(rs.getString(5)));
        }

        rs.close();
        stmt.close();

        return feto;
    }

    public ArrayList<Feto> bucarFetoPorRGDaGestante(String rg) throws SQLException {
        ArrayList<Feto> listaFetos = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT F.ID_FETO, F.ID_GESTANTE, F.NOME, F.IDADE_SEMANAS, F.SEXO " +
                "FROM FETO F INNER JOIN GESTANTE G " +
                "ON F.ID_GESTANTE = G.ID_GESTANTE " +
                "WHERE G.RG = ?");
        stmt.setString(1, rg);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Feto feto = new Feto();
            feto.setIdFeto(rs.getLong(1));
            feto.setIdGestante(rs.getLong(2));
            feto.setNome(rs.getString(3));
            feto.setIdade(rs.getInt(4));
            feto.setSexo(SexoEnum.valueOf(rs.getString(5)));

            listaFetos.add(feto);
        }

        rs.close();
        stmt.close();

        return listaFetos;
    }

    public void alterar(Long id, Feto feto) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("UPDATE FETO " +
                "SET NOME = ?, IDADE_SEMANAS = ?, SEXO = ? " +
                "WHERE ID_FETO = ?");
        stmt.setString(1, feto.getNome());
        stmt.setInt(2, feto.getIdade());
        stmt.setString(3, String.valueOf(feto.getSexo()));
        stmt.setLong(4, id);
        stmt.execute();

        stmt.close();

        System.out.println("[INFO] Feto atualizado com sucesso");
    }

    public void deletar(Long id) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM FETO WHERE ID_FETO = ?");
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Feto deletado com sucesso");
    }
}
