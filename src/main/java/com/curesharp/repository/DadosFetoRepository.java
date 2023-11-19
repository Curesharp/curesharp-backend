package com.curesharp.repository;

import com.curesharp.config.h2.ConnectionFactoryH2;
import com.curesharp.model.DadosFeto;
import com.curesharp.util.SaudeEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DadosFetoRepository {
    public Connection conexao;

    public DadosFetoRepository() throws SQLException, ClassNotFoundException {
        super();
        this.conexao = new ConnectionFactoryH2().conexao();
    }


    public void inserir(DadosFeto dadosFeto) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO DADOS_FETO (ID_FETO, IDADE, FREQUENCIA_CARDIACA, ACELERACOES, MOVIMENTO_FETAL_POR_SEGUNDO, CONTRACOES, DESACELERACOES, DESACELERACOES_SEVERAS, DESACELERACOES_PROLONGADAS, VARIACAO_ANORMAL_CURTO_PRAZO, VARIACAO_MEDIA_CURTO_PRAZO, PORCENTAGEM_TEMPO_VARIACAO_ANORMAL, MEDIA_VARIACAO_LONGO_PRAZO, LARGURA_HISTOGRAMA, VALOR_MINIMO_HISTOGRAMA, VALOR_MAXIMO_HISTOGRAMA, NUMERO_PICOS_HISTOGRAMA, NUMERO_ZEROS_HISTOGRAMA, MODULO_HISTOGRAMA, MEDIA_HISTOGRAMA, MEDIANA_HISTOGRAMA, VARIANCIA_HISTOGRAMA, TENDENCIA_HISTOGRAMA, SAUDE_FETO, DATA_AVALIACAO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setLong(1, dadosFeto.getIdFeto());
        stmt.setInt(2, dadosFeto.getIdade());
        stmt.setFloat(3, dadosFeto.getFrequenciaCardiaca());
        stmt.setFloat(4, dadosFeto.getAceleracoes());
        stmt.setFloat(5, dadosFeto.getMovimentoFetalPorSegundo());
        stmt.setFloat(6, dadosFeto.getContracoes());
        stmt.setFloat(7, dadosFeto.getDesaceleracoes());
        stmt.setFloat(8, dadosFeto.getDesaceleracoesSeveras());
        stmt.setFloat(9, dadosFeto.getDesaceleracoesProlongadas());
        stmt.setFloat(10, dadosFeto.getVariacaoAnormalCurtoPrazo());
        stmt.setFloat(11, dadosFeto.getVariacaoMediaCurtoPrazo());
        stmt.setFloat(12, dadosFeto.getPorcentagemTempoVariacaoAnormal());
        stmt.setFloat(13, dadosFeto.getMediaVariacaoLongoPrazo());
        stmt.setFloat(14, dadosFeto.getLarguraHistograma());
        stmt.setFloat(15, dadosFeto.getValorMinimoHistograma());
        stmt.setFloat(16, dadosFeto.getValorMaximoHistograma());
        stmt.setFloat(17, dadosFeto.getNumeroPicosHistograma());
        stmt.setFloat(18, dadosFeto.getNumeroZerosHistograma());
        stmt.setFloat(19, dadosFeto.getModuloHistograma());
        stmt.setFloat(20, dadosFeto.getMediaHistograma());
        stmt.setFloat(21, dadosFeto.getMedianaHistograma());
        stmt.setFloat(22, dadosFeto.getVarianciaHistograma());
        stmt.setFloat(23, dadosFeto.getTendenciaHistograma());
        stmt.setString(24, String.valueOf(dadosFeto.getSaudeFeto()));
        stmt.setTimestamp(25, new java.sql.Timestamp(dadosFeto.getDataAvaliacao().getTime()));

        stmt.execute();
        stmt.close();

        System.out.println("[INFO] Dados do feto cadastrados com sucesso");
    }

    public ArrayList<DadosFeto> listar() throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<DadosFeto> listaDados = new ArrayList<>();
        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM DADOS_FETO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            DadosFeto dadosFeto = new DadosFeto();
            dadosFeto.setIdDadosFeto(rs.getLong(1));
            dadosFeto.setIdFeto(rs.getLong(2));
            dadosFeto.setIdade(rs.getInt(3));
            dadosFeto.setFrequenciaCardiaca(rs.getFloat(4));
            dadosFeto.setAceleracoes(rs.getFloat(5));
            dadosFeto.setMovimentoFetalPorSegundo(rs.getFloat(6));
            dadosFeto.setContracoes(rs.getFloat(7));
            dadosFeto.setDesaceleracoes(rs.getFloat(8));
            dadosFeto.setDesaceleracoesSeveras(rs.getFloat(9));
            dadosFeto.setDesaceleracoesProlongadas(rs.getFloat(10));
            dadosFeto.setVariacaoAnormalCurtoPrazo(rs.getFloat(11));
            dadosFeto.setVariacaoMediaCurtoPrazo(rs.getFloat(12));
            dadosFeto.setPorcentagemTempoVariacaoAnormal(rs.getFloat(13));
            dadosFeto.setMediaVariacaoLongoPrazo(rs.getFloat(14));
            dadosFeto.setLarguraHistograma(rs.getFloat(15));
            dadosFeto.setValorMinimoHistograma(rs.getFloat(16));
            dadosFeto.setValorMaximoHistograma(rs.getFloat(17));
            dadosFeto.setNumeroPicosHistograma(rs.getFloat(18));
            dadosFeto.setNumeroZerosHistograma(rs.getFloat(19));
            dadosFeto.setModuloHistograma(rs.getFloat(20));
            dadosFeto.setMediaHistograma(rs.getFloat(21));
            dadosFeto.setMedianaHistograma(rs.getFloat(21));
            dadosFeto.setVarianciaHistograma(rs.getFloat(23));
            dadosFeto.setTendenciaHistograma(rs.getFloat(24));
            dadosFeto.setSaudeFeto(SaudeEnum.valueOf(rs.getString(25)));
            dadosFeto.setDataAvaliacao(rs.getTimestamp(26));

            listaDados.add(dadosFeto);
        }

        rs.close();
        stmt.close();

        return listaDados;
    }
}
