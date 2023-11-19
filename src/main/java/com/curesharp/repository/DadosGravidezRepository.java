package com.curesharp.repository;

import com.curesharp.config.h2.ConnectionFactoryH2;
import com.curesharp.model.DadosGravidez;
import com.curesharp.util.RiscoEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DadosGravidezRepository {

    public Connection conexao;

    public DadosGravidezRepository() throws SQLException, ClassNotFoundException {
        super();
        this.conexao = new ConnectionFactoryH2().conexao();
    }

    public void inserir(DadosGravidez dadosGravidez) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO DADOS_GRAVIDEZ(ID_GESTANTE, IDADE_GESTANTE, PRESSAO_SANGUINEA_SISTOLICA, PRESSAO_SANGUINEA_DIASTOLICA, NIVEL_GLICOSE_SANGUE, FREQUENCIA_CARDIACA, TEMPERATURA_CORPORAL_GRAVIDEZ, RISCO_GRAVIDEZ, DATA_AVALIACAO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setLong(1, dadosGravidez.getIdGestante());
        stmt.setInt(2, dadosGravidez.getIdadeGestante());
        stmt.setFloat(3, dadosGravidez.getPressaoSanguineaSistolica());
        stmt.setFloat(4, dadosGravidez.getPressaoSanguineaDiastolica());
        stmt.setFloat(5, dadosGravidez.getNivelGlicoseSangue());
        stmt.setFloat(6, dadosGravidez.getFrequenciaCardiaca());
        stmt.setFloat(7, dadosGravidez.getTemperaturaCorporalGravidez());
        stmt.setString(8, String.valueOf(dadosGravidez.getRisco()));
        stmt.setTimestamp(9, new java.sql.Timestamp(dadosGravidez.getDataAvaliacao().getTime()));
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Dados cadastrados com sucesso");
    }

    public ArrayList<DadosGravidez> listar() throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<DadosGravidez> listaDados = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM DADOS_GRAVIDEZ");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            DadosGravidez dadosGravidez = new DadosGravidez();
            dadosGravidez.setIdDadosGravidez(rs.getLong(1));
            dadosGravidez.setIdGestante(rs.getLong(2));
            dadosGravidez.setIdadeGestante(rs.getInt(3));
            dadosGravidez.setPressaoSanguineaSistolica(rs.getFloat(4));
            dadosGravidez.setPressaoSanguineaDiastolica(rs.getFloat(5));
            dadosGravidez.setNivelGlicoseSangue(rs.getFloat(6));
            dadosGravidez.setFrequenciaCardiaca(rs.getFloat(7));
            dadosGravidez.setTemperaturaCorporalGravidez(rs.getFloat(8));
            dadosGravidez.setRisco(RiscoEnum.valueOf(rs.getString(9)));
            dadosGravidez.setDataAvaliacao(rs.getTimestamp(10));

            listaDados.add(dadosGravidez);
        }

        rs.close();
        stmt.close();

        return listaDados;
    }

    public DadosGravidez bucarPorID(Long id) throws SQLException {
        DadosGravidez dadosGravidez = new DadosGravidez();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM DADOS_GRAVIDEZ WHERE ID_DADOS_GRAVIDEZ = ?");
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            dadosGravidez.setIdDadosGravidez(rs.getLong(1));
            dadosGravidez.setIdGestante(rs.getLong(2));
            dadosGravidez.setIdadeGestante(rs.getInt(3));
            dadosGravidez.setPressaoSanguineaSistolica(rs.getFloat(4));
            dadosGravidez.setPressaoSanguineaDiastolica(rs.getFloat(5));
            dadosGravidez.setNivelGlicoseSangue(rs.getFloat(6));
            dadosGravidez.setFrequenciaCardiaca(rs.getFloat(7));
            dadosGravidez.setTemperaturaCorporalGravidez(rs.getFloat(8));
            dadosGravidez.setRisco(RiscoEnum.valueOf(rs.getString(9)));
            dadosGravidez.setDataAvaliacao(rs.getTimestamp(10));
        }

        rs.close();
        stmt.close();

        return dadosGravidez;
    }

    public ArrayList<DadosGravidez> bucarDadosPorIdDaGestante(Long idGestante) throws SQLException {
        ArrayList<DadosGravidez> listaDados = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM DADOS_GRAVIDEZ WHERE ID_GESTANTE = ?");
        stmt.setLong(1, idGestante);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            DadosGravidez dadosGravidez = new DadosGravidez();
            dadosGravidez.setIdDadosGravidez(rs.getLong(1));
            dadosGravidez.setIdGestante(rs.getLong(2));
            dadosGravidez.setIdadeGestante(rs.getInt(3));
            dadosGravidez.setPressaoSanguineaSistolica(rs.getFloat(4));
            dadosGravidez.setPressaoSanguineaDiastolica(rs.getFloat(5));
            dadosGravidez.setNivelGlicoseSangue(rs.getFloat(6));
            dadosGravidez.setFrequenciaCardiaca(rs.getFloat(7));
            dadosGravidez.setTemperaturaCorporalGravidez(rs.getFloat(8));
            dadosGravidez.setRisco(RiscoEnum.valueOf(rs.getString(9)));
            dadosGravidez.setDataAvaliacao(rs.getTimestamp(10));

            listaDados.add(dadosGravidez);
        }

        rs.close();
        stmt.close();

        return listaDados;
    }

    public ArrayList<DadosGravidez> bucarDadosGravidezPorRGDaGestante(String rg) throws SQLException {
        ArrayList<DadosGravidez> listaDados = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT D.ID_DADOS_GRAVIDEZ, D.ID_GESTANTE, D.IDADE_GESTANTE, D.PRESSAO_SANGUINEA_SISTOLICA, D.PRESSAO_SANGUINEA_DIASTOLICA, D.NIVEL_GLICOSE_SANGUE, D.FREQUENCIA_CARDIACA, D.TEMPERATURA_CORPORAL_GRAVIDEZ, D.RISCO_GRAVIDEZ, D.DATA_AVALIACAO " +
                "FROM DADOS_GRAVIDEZ D INNER JOIN GESTANTE G " +
                "ON D.ID_GESTANTE = G.ID_GESTANTE " +
                "WHERE G.RG = ?");
        stmt.setString(1, rg);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            DadosGravidez dadosGravidez = new DadosGravidez();
            dadosGravidez.setIdDadosGravidez(rs.getLong(1));
            dadosGravidez.setIdGestante(rs.getLong(2));
            dadosGravidez.setIdadeGestante(rs.getInt(3));
            dadosGravidez.setPressaoSanguineaSistolica(rs.getFloat(4));
            dadosGravidez.setPressaoSanguineaDiastolica(rs.getFloat(5));
            dadosGravidez.setNivelGlicoseSangue(rs.getFloat(6));
            dadosGravidez.setFrequenciaCardiaca(rs.getFloat(7));
            dadosGravidez.setTemperaturaCorporalGravidez(rs.getFloat(8));
            dadosGravidez.setRisco(RiscoEnum.valueOf(rs.getString(9)));
            dadosGravidez.setDataAvaliacao(rs.getTimestamp(10));

            listaDados.add(dadosGravidez);
        }

        rs.close();
        stmt.close();

        return listaDados;
    }

    public void alterar(Long id, DadosGravidez dadosGravidez) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("UPDATE DADOS_GRAVIDEZ " +
                "SET IDADE_GESTANTE = ?, PRESSAO_SANGUINEA_SISTOLICA = ?, PRESSAO_SANGUINEA_DIASTOLICA = ?, NIVEL_GLICOSE_SANGUE = ?, FREQUENCIA_CARDIACA = ?, TEMPERATURA_CORPORAL_GRAVIDEZ = ?,  RISCO_GRAVIDEZ = ?, DATA_AVALIACAO = ? " +
                "WHERE ID_DADOS_GRAVIDEZ = ?");
        stmt.setInt(1, dadosGravidez.getIdadeGestante());
        stmt.setFloat(2, dadosGravidez.getPressaoSanguineaSistolica());
        stmt.setFloat(3, dadosGravidez.getPressaoSanguineaDiastolica());
        stmt.setFloat(4, dadosGravidez.getNivelGlicoseSangue());
        stmt.setFloat(5, dadosGravidez.getFrequenciaCardiaca());
        stmt.setFloat(6, dadosGravidez.getTemperaturaCorporalGravidez());
        stmt.setString(7, String.valueOf(dadosGravidez.getRisco()));
        stmt.setTimestamp(8, new java.sql.Timestamp(dadosGravidez.getDataAvaliacao().getTime()));
        stmt.setLong(9, id);
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Dados atualizados com sucesso");
    }

    public void deletar(Long id) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM DADOS_GRAVIDEZ WHERE ID_DADOS_GRAVIDEZ = ?");
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Dados deletados com sucesso");
    }
}
