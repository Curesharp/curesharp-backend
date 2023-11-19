package com.curesharp.business;

import com.curesharp.dto.DadosInserirDadosFeto;
import com.curesharp.dto.DadosSelecionarDadosFeto;
import com.curesharp.model.DadosFeto;
import com.curesharp.repository.DadosFetoRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DadosFetoBusiness {

    private DadosFetoRepository repository;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public DadosInserirDadosFeto inserirDadosFeto(DadosFeto dadosFeto) throws Exception {
        repository = new DadosFetoRepository();

        dadosFeto.setDataAvaliacao(new Date());
        repository.inserir(dadosFeto);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new DadosInserirDadosFeto(dadosFeto.getSaudeFeto(), sdf.format(dadosFeto.getDataAvaliacao()));
    }

    public ArrayList<DadosSelecionarDadosFeto> listarDadosFeto() throws Exception {
        repository = new DadosFetoRepository();
        ArrayList<DadosSelecionarDadosFeto> listaDTO = new ArrayList<>();
        ArrayList<DadosFeto> listaDados = repository.listar();

        for(DadosFeto dadosFeto : listaDados){
            DadosSelecionarDadosFeto dadosFetoDTO = new DadosSelecionarDadosFeto(
                    dadosFeto.getIdDadosFeto(),
                    dadosFeto.getIdFeto(),
                    dadosFeto.getIdade(),
                    dadosFeto.getFrequenciaCardiaca(),
                    dadosFeto.getAceleracoes(),
                    dadosFeto.getMovimentoFetalPorSegundo(),
                    dadosFeto.getContracoes(),
                    dadosFeto.getDesaceleracoes(),
                    dadosFeto.getDesaceleracoesSeveras(),
                    dadosFeto.getDesaceleracoesProlongadas(),
                    dadosFeto.getVariacaoAnormalCurtoPrazo(),
                    dadosFeto.getVariacaoMediaCurtoPrazo(),
                    dadosFeto.getPorcentagemTempoVariacaoAnormal(),
                    dadosFeto.getMediaVariacaoLongoPrazo(),
                    dadosFeto.getLarguraHistograma(),
                    dadosFeto.getValorMinimoHistograma(),
                    dadosFeto.getValorMaximoHistograma(),
                    dadosFeto.getNumeroPicosHistograma(),
                    dadosFeto.getNumeroZerosHistograma(),
                    dadosFeto.getModuloHistograma(),
                    dadosFeto.getMediaHistograma(),
                    dadosFeto.getMedianaHistograma(),
                    dadosFeto.getVarianciaHistograma(),
                    dadosFeto.getTendenciaHistograma(),
                    dadosFeto.getSaudeFeto(),
                    sdf.format(dadosFeto.getDataAvaliacao())
            );

            listaDTO.add(dadosFetoDTO);
        }

        return listaDTO;
    }
}
