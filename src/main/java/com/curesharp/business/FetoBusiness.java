package com.curesharp.business;

import com.curesharp.model.Feto;
import com.curesharp.model.Gestante;
import com.curesharp.repository.FetoRepository;
import com.curesharp.repository.GestanteRepository;

import java.util.ArrayList;

public class FetoBusiness {

    private FetoRepository repository;

    public void inserirFeto(Feto feto) throws Exception {
        repository = new FetoRepository();
        repository.inserir(feto);
    }

    public ArrayList<Feto> listarFetos() throws Exception {
        repository = new FetoRepository();
        return repository.listar();
    }

    public Feto bucarFetoPorId(Long id) throws Exception {
        repository = new FetoRepository();
        Feto feto = repository.bucarPorID(id);

        if(feto.getIdFeto() == null){
            throw new Exception("Cadastro não encontrado");
        } else {
            return feto;
        }
    }

    public ArrayList<Feto> bucarFetoPorRGDaGestante(String rg) throws Exception {
        repository = new FetoRepository();

        GestanteRepository gestanteRepository = new GestanteRepository();
        Gestante gestante = gestanteRepository.bucarPorRG(rg);

        if(gestante.getIdGestante() == null){
            throw new Exception("O RG digitado é inválido");
        }

        ArrayList<Feto> listaFetos = repository.bucarFetoPorRGDaGestante(rg);

        return listaFetos;
    }

    public void atualizarFeto(Long id, Feto feto) throws Exception {
        repository = new FetoRepository();
        Feto fetoBanco = repository.bucarPorID(id);

        if(fetoBanco.getIdFeto() == null){
            throw new Exception("Não foi possivel encontrar esse cadastro");
        }

        repository.alterar(id, feto);
    }

    public void deletarFeto(Long id) throws Exception {
        repository = new FetoRepository();
        Feto feto = repository.bucarPorID(id);

        if(feto.getIdFeto() == null){
            throw new Exception("Não foi possivel encontrar esse cadastro");
        }

        repository.deletar(id);
    }
}
