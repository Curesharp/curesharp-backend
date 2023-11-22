package com.curesharp.business;

import com.curesharp.dto.DadosAnalisarDadosGravidez;
import com.curesharp.dto.DadosSelecionarDadosGravidez;
import com.curesharp.integration.IA;
import com.curesharp.model.DadosGravidez;
import com.curesharp.model.Gestante;
import com.curesharp.repository.DadosGravidezRepository;
import com.curesharp.repository.GestanteRepository;
import com.curesharp.util.RiscoEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DadosGravidezBusiness {

    private IA iaIntegration;
    private DadosGravidezRepository repository;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public DadosAnalisarDadosGravidez inserirDadosGravidez(DadosGravidez dadosGravidez) throws Exception {
        repository = new DadosGravidezRepository();
        iaIntegration = new IA();

        RiscoEnum risco = iaIntegration.analisarRiscoGravidez(dadosGravidez);

        dadosGravidez.setRisco(risco);
        dadosGravidez.setDataAvaliacao(new Date());
        repository.inserir(dadosGravidez);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new DadosAnalisarDadosGravidez(dadosGravidez.getRisco(),
                sdf.format(dadosGravidez.getDataAvaliacao()));
    }

    public ArrayList<DadosSelecionarDadosGravidez> listarDadosGravidez() throws Exception {
        repository = new DadosGravidezRepository();
        ArrayList<DadosSelecionarDadosGravidez> listaDTO = new ArrayList<>();
        ArrayList<DadosGravidez> listaDados = repository.listar();

        for(DadosGravidez dadosGravidez: listaDados){
            DadosSelecionarDadosGravidez dadosGravidezDTO = new DadosSelecionarDadosGravidez(
                    dadosGravidez.getIdDadosGravidez(),
                    dadosGravidez.getIdGestante(),
                    dadosGravidez.getIdadeGestante(),
                    dadosGravidez.getPressaoSanguineaSistolica(),
                    dadosGravidez.getPressaoSanguineaDiastolica(),
                    dadosGravidez.getNivelGlicoseSangue(),
                    dadosGravidez.getFrequenciaCardiaca(),
                    dadosGravidez.getTemperaturaCorporalGravidez(),
                    dadosGravidez.getRisco(),
                    sdf.format(dadosGravidez.getDataAvaliacao())
            );

            listaDTO.add(dadosGravidezDTO);
        }

        return listaDTO;
    }

    public DadosSelecionarDadosGravidez bucarDadosGravidezPorId(Long id) throws Exception {
        repository = new DadosGravidezRepository();
        DadosGravidez dadosGravidez = repository.bucarPorID(id);

        if(dadosGravidez.getIdDadosGravidez() == null){
            throw new Exception("Dados não encontrados");
        } else {
            DadosSelecionarDadosGravidez dadosGravidezDTO = new DadosSelecionarDadosGravidez(
                    dadosGravidez.getIdDadosGravidez(),
                    dadosGravidez.getIdGestante(),
                    dadosGravidez.getIdadeGestante(),
                    dadosGravidez.getPressaoSanguineaSistolica(),
                    dadosGravidez.getPressaoSanguineaDiastolica(),
                    dadosGravidez.getNivelGlicoseSangue(),
                    dadosGravidez.getFrequenciaCardiaca(),
                    dadosGravidez.getTemperaturaCorporalGravidez(),
                    dadosGravidez.getRisco(),
                    sdf.format(dadosGravidez.getDataAvaliacao())
            );

            return dadosGravidezDTO;
        }
    }

    public ArrayList<DadosSelecionarDadosGravidez> bucarDadosGravidezPorIdDaGestante(Long id) throws Exception {
        repository = new DadosGravidezRepository();
        GestanteRepository gestanteRepository = new GestanteRepository();
        Gestante verificacaoGestante = gestanteRepository.bucarPorID(id);

        if(verificacaoGestante.getIdGestante() == null){
            throw new Exception("O ID digitado é inválido");
        }

        ArrayList<DadosGravidez> listaDados = repository.bucarDadosPorIdDaGestante(id);
        ArrayList<DadosSelecionarDadosGravidez> listaDTO = new ArrayList<>();

        for(DadosGravidez dadosGravidez: listaDados){
            DadosSelecionarDadosGravidez dadosGravidezDTO = new DadosSelecionarDadosGravidez(
                    dadosGravidez.getIdDadosGravidez(),
                    dadosGravidez.getIdGestante(),
                    dadosGravidez.getIdadeGestante(),
                    dadosGravidez.getPressaoSanguineaSistolica(),
                    dadosGravidez.getPressaoSanguineaDiastolica(),
                    dadosGravidez.getNivelGlicoseSangue(),
                    dadosGravidez.getFrequenciaCardiaca(),
                    dadosGravidez.getTemperaturaCorporalGravidez(),
                    dadosGravidez.getRisco(),
                    sdf.format(dadosGravidez.getDataAvaliacao())
            );

            listaDTO.add(dadosGravidezDTO);
        }

        return listaDTO;

    }

    public ArrayList<DadosSelecionarDadosGravidez> bucarDadosGravidezPorRGDaGestante(String rg) throws Exception {
        repository = new DadosGravidezRepository();

        GestanteRepository gestanteRepository = new GestanteRepository();
        Gestante gestante = gestanteRepository.bucarPorRG(rg);

        if(gestante.getIdGestante() == null){
            throw new Exception("O RG digitado é inválido");
        }

        ArrayList<DadosGravidez> listaDados = repository.bucarDadosGravidezPorRGDaGestante(rg);
        ArrayList<DadosSelecionarDadosGravidez> listaDTO = new ArrayList<>();

        for(DadosGravidez dadosGravidez: listaDados){
            DadosSelecionarDadosGravidez dadosGravidezDTO = new DadosSelecionarDadosGravidez(
                    dadosGravidez.getIdDadosGravidez(),
                    dadosGravidez.getIdGestante(),
                    dadosGravidez.getIdadeGestante(),
                    dadosGravidez.getPressaoSanguineaSistolica(),
                    dadosGravidez.getPressaoSanguineaDiastolica(),
                    dadosGravidez.getNivelGlicoseSangue(),
                    dadosGravidez.getFrequenciaCardiaca(),
                    dadosGravidez.getTemperaturaCorporalGravidez(),
                    dadosGravidez.getRisco(),
                    sdf.format(dadosGravidez.getDataAvaliacao())
            );

            listaDTO.add(dadosGravidezDTO);
        }

        return listaDTO;
    }

    public DadosAnalisarDadosGravidez atualizarDadosGravidez(Long id, DadosGravidez dadosGravidez) throws Exception {
        repository = new DadosGravidezRepository();
        iaIntegration = new IA();

        DadosGravidez dadosBanco = repository.bucarPorID(id);
        if(dadosBanco == null){
            throw new Exception("Não foi possivel encontrar esse cadastro");
        }

        RiscoEnum risco = iaIntegration.analisarRiscoGravidez(dadosGravidez);
        dadosGravidez.setRisco(risco);
        dadosGravidez.setDataAvaliacao(new Date());
        dadosGravidez.setDataAvaliacao(new Date());

        repository.alterar(id, dadosGravidez);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new DadosAnalisarDadosGravidez(dadosGravidez.getRisco(),
                sdf.format(dadosGravidez.getDataAvaliacao()));
    }

    public void deletarDadosGravidez(Long id) throws Exception {
        repository = new DadosGravidezRepository();
        DadosGravidez dadosGravidez = repository.bucarPorID(id);

        if(dadosGravidez.getIdDadosGravidez() == null){
            throw new Exception("Não foi possivel encontrar esse cadastro");
        }

        repository.deletar(id);
    }
}
