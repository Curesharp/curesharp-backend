package com.curesharp.model;

import com.curesharp.util.RiscoEnum;

import java.util.Date;

public class DadosGravidez {

    private Long idDadosGravidez;
    private Long idGestante;
    private int idadeGestante;
    private Float pressaoSanguineaSistolica;
    private Float pressaoSanguineaDiastolica;
    private Float nivelGlicoseSangue;
    private Float frequenciaCardiaca;
    private Float temperaturaCorporalGravidez;
    private RiscoEnum risco;
    private Date dataAvaliacao;

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

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

}
