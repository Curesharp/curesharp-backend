package com.curesharp.business;

import com.curesharp.model.Gestante;
import com.curesharp.model.Usuario;
import com.curesharp.repository.GestanteRepository;
import com.curesharp.repository.UsuarioRepository;

import java.util.ArrayList;

public class GestanteBusiness {

    private GestanteRepository repository;

    public void inserirGestante(Gestante gestante) throws Exception {
        repository = new GestanteRepository();
        Gestante verificacaoRG = repository.bucarPorRG(gestante.getRg());

        if(verificacaoRG.getRg() != null){
            throw new Exception("Essa pessoa já foi cadastrada na nossa base de dados");
        }

        repository.inserir(gestante);
    }

    public ArrayList<Gestante> listarGestantes() throws Exception {
        repository = new GestanteRepository();
        return repository.listar();
    }

    public  Gestante bucarGestantePorId(Long id) throws Exception {
        repository = new GestanteRepository();
        Gestante gestante = repository.bucarPorID(id);

        if(gestante.getIdGestante() == null){
            throw new Exception("Cadastro não encontrado");
        } else {
            return gestante;
        }
    }

    public Gestante bucarGestantePorRG(String rg) throws Exception {
        repository = new GestanteRepository();
        Gestante gestante = repository.bucarPorRG(rg);

        if(gestante.getRg() == null){
            throw new Exception("O e-mail não foi encontrado");
        } else {
            return gestante;
        }
    }

    public void atualizarGestante(Long id, Gestante gestante) throws Exception {
        repository = new GestanteRepository();
        Gestante gestanteBanco = repository.bucarPorID(id);

        if(gestanteBanco.getIdGestante() == null){
            throw new Exception("Não foi possivel encontrar esse cadastro");
        }

        repository.alterar(id, gestante);
    }

    public void deletarGestante(Long id) throws Exception {
        repository = new GestanteRepository();
        Gestante gestante = repository.bucarPorID(id);

        if(gestante.getIdGestante() == null){
            throw new Exception("Não foi possivel encontrar esse cadastro");
        }

        repository.deletar(id);
    }

}
