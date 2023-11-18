package com.curesharp.model;

import com.curesharp.util.SexoEnum;

public class Feto {

    private Long idFeto;
    private Long idGestante;
    private String nome;
    private int idade;
    private SexoEnum sexo;

    public Long getIdFeto() {
        return idFeto;
    }

    public void setIdFeto(Long idFeto) {
        this.idFeto = idFeto;
    }

    public Long getIdGestante() {
        return idGestante;
    }

    public void setIdGestante(Long idGestante) {
        this.idGestante = idGestante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }
}
