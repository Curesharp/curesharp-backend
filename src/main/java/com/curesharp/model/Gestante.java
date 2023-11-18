package com.curesharp.model;

import com.curesharp.util.RacaEnum;

public class Gestante {

    private Long idGestante;
    private Long idUsuario;
    private String nome;
    private String rg;
    private RacaEnum racaEnum;
    private Long contato;

    public Long getIdGestante() {
        return idGestante;
    }

    public void setIdGestante(Long idGestante) {
        this.idGestante = idGestante;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public RacaEnum getRaca() {
        return racaEnum;
    }

    public void setRaca(RacaEnum racaEnum) {
        this.racaEnum = racaEnum;
    }

    public Long getContato() {
        return contato;
    }

    public void setContato(Long contato) {
        this.contato = contato;
    }
}
