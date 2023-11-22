package com.curesharp.business;

import com.curesharp.dto.DadosAnalisarDadosFeto;
import com.curesharp.dto.DadosSelecionarDadosFeto;
import com.curesharp.integration.IA;
import com.curesharp.model.DadosFeto;
import com.curesharp.model.Feto;
import com.curesharp.model.Gestante;
import com.curesharp.repository.DadosFetoRepository;
import com.curesharp.repository.FetoRepository;
import com.curesharp.repository.GestanteRepository;
import com.curesharp.util.SaudeEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DadosFetoBusiness {

    private DadosFetoRepository repository;
    private IA iaIntegration;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public DadosAnalisarDadosFeto inserirDadosFeto(DadosFeto dadosFeto) throws Exception {
        repository = new DadosFetoRepository();
        iaIntegration = new IA();

        SaudeEnum saudeFeto = iaIntegration.analisarSaudeFeto(dadosFeto);
        dadosFeto.setSaudeFeto(saudeFeto);
        dadosFeto.setDataAvaliacao(new Date());
        repository.inserir(dadosFeto);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new DadosAnalisarDadosFeto(dadosFeto.getSaudeFeto(), sdf.format(dadosFeto.getDataAvaliacao()));
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

    public DadosSelecionarDadosFeto buscarDadosFetoPorId(Long id) throws Exception {
        repository = new DadosFetoRepository();
        ArrayList<DadosSelecionarDadosFeto> listaDTO = new ArrayList<>();
        DadosFeto dadosFeto = repository.buscarPorId(id);

        if(dadosFeto.getIdDadosFeto() == null){
            throw new Exception("Dados não encontrados");
        }

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

        return dadosFetoDTO;
    }

    public ArrayList<DadosSelecionarDadosFeto> buscarDadosFetoPorIdDoFeto(Long idDoFeto) throws Exception {
        repository = new DadosFetoRepository();
        ArrayList<DadosSelecionarDadosFeto> listaDTO = new ArrayList<>();

        FetoRepository fetoRepository = new FetoRepository();
        Feto verificacaoFeto = fetoRepository.bucarPorID(idDoFeto);

        if (verificacaoFeto.getIdFeto() == null){
            throw new Exception("O ID digitado é inválido");
        }


        ArrayList<DadosFeto> listaDados = repository.buscarPorIdDoFeto(idDoFeto);

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

    public ArrayList<DadosSelecionarDadosFeto> buscarDadosFetoPorRgDaMae(String rg) throws Exception {
        repository = new DadosFetoRepository();
        ArrayList<DadosSelecionarDadosFeto> listaDTO = new ArrayList<>();

        GestanteRepository gestanteRepository = new GestanteRepository();
        Gestante verificacaoGestante = gestanteRepository.bucarPorRG(rg);

        if(verificacaoGestante.getIdGestante() == null){
            throw new Exception("O RG digitado é inválido");
        }


        ArrayList<DadosFeto> listaDados = repository.buscarPorRgDaMae(rg);

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

    public DadosAnalisarDadosFeto alterarDadosFeto(Long id, DadosFeto dadosFeto) throws Exception {
        repository = new DadosFetoRepository();
        iaIntegration = new IA();

        DadosFeto verificacaoFeto = repository.buscarPorId(id);
        if(verificacaoFeto.getIdDadosFeto() == null){
            throw new Exception("O ID digitado é inválido.");
        }

        SaudeEnum saudeFeto = iaIntegration.analisarSaudeFeto(dadosFeto);
        dadosFeto.setSaudeFeto(saudeFeto);
        dadosFeto.setDataAvaliacao(new Date());

        repository.alterar(id, dadosFeto);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new DadosAnalisarDadosFeto(dadosFeto.getSaudeFeto(), sdf.format(dadosFeto.getDataAvaliacao()));
    }

    public void deletarDadosFeto(Long id) throws Exception {
        repository = new DadosFetoRepository();

        DadosFeto verificacaoFeto = repository.buscarPorId(id);
        if(verificacaoFeto.getIdDadosFeto() == null){
            throw new Exception("O ID digitado é inválido.");
        }

        repository.deletar(id);
    }

}
