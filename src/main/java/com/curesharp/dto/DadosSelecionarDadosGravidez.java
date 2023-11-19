package com.curesharp.dto;

import com.curesharp.util.RiscoEnum;

public class DadosSelecionarDadosGravidez {
    private Long idDadosGravidez;
    private Long idGestante;
    private int idadeGestante;
    private Float pressaoSanguineaSistolica;
    private Float pressaoSanguineaDiastolica;
    private Float nivelGlicoseSangue;
    private Float frequenciaCardiaca;
    private Float temperaturaCorporalGravidez;
    private RiscoEnum risco;
    private String dataDaAvaliacao;

    public DadosSelecionarDadosGravidez(Long idDadosGravidez, Long idGestante, int idadeGestante, Float pressaoSanguineaSistolica, Float pressaoSanguineaDiastolica, Float nivelGlicoseSangue, Float frequenciaCardiaca, Float temperaturaCorporalGravidez, RiscoEnum risco, String dataDaAvaliacao) {
        this.idDadosGravidez = idDadosGravidez;
        this.idGestante = idGestante;
        this.idadeGestante = idadeGestante;
        this.pressaoSanguineaSistolica = pressaoSanguineaSistolica;
        this.pressaoSanguineaDiastolica = pressaoSanguineaDiastolica;
        this.nivelGlicoseSangue = nivelGlicoseSangue;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.temperaturaCorporalGravidez = temperaturaCorporalGravidez;
        this.risco = risco;
        this.dataDaAvaliacao = dataDaAvaliacao;
    }

    public Long getIdDadosGravidez() {
        return idDadosGravidez;
    }

    public void setIdDadosGravidez(Long idDadosGravidez) {
        this.idDadosGravidez = idDadosGravidez;
    }

    public Long getIdGestante() {
        return idGestante;
    }

    public void setIdGestante(Long idGestante) {
        this.idGestante = idGestante;
    }

    public int getIdadeGestante() {
        return idadeGestante;
    }

    public void setIdadeGestante(int idadeGestante) {
        this.idadeGestante = idadeGestante;
    }

    public Float getPressaoSanguineaSistolica() {
        return pressaoSanguineaSistolica;
    }

    public void setPressaoSanguineaSistolica(Float pressaoSanguineaSistolica) {
        this.pressaoSanguineaSistolica = pressaoSanguineaSistolica;
    }

    public Float getPressaoSanguineaDiastolica() {
        return pressaoSanguineaDiastolica;
    }

    public void setPressaoSanguineaDiastolica(Float pressaoSanguineaDiastolica) {
        this.pressaoSanguineaDiastolica = pressaoSanguineaDiastolica;
    }

    public Float getNivelGlicoseSangue() {
        return nivelGlicoseSangue;
    }

    public void setNivelGlicoseSangue(Float nivelGlicoseSangue) {
        this.nivelGlicoseSangue = nivelGlicoseSangue;
    }

    public Float getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(Float frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public Float getTemperaturaCorporalGravidez() {
        return temperaturaCorporalGravidez;
    }

    public void setTemperaturaCorporalGravidez(Float temperaturaCorporalGravidez) {
        this.temperaturaCorporalGravidez = temperaturaCorporalGravidez;
    }

    public RiscoEnum getRisco() {
        return risco;
    }

    public void setRisco(RiscoEnum risco) {
        this.risco = risco;
    }

    public String getDataDaAvaliacao() {
        return dataDaAvaliacao;
    }

    public void setDataDaAvaliacao(String dataDaAvaliacao) {
        this.dataDaAvaliacao = dataDaAvaliacao;
    }
}
