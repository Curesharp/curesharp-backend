package com.curesharp.model;

import com.curesharp.util.SaudeEnum;

import java.util.Date;

public class DadosFeto {

    private Long idDadosFeto;
    private Long idFeto;
    private int idade;
    private Float frequenciaCardiaca;
    private Float aceleracoes;
    private Float movimentoFetalPorSegundo;
    private Float contracoes;
    private Float desaceleracoes;
    private Float desaceleracoesSeveras;
    private Float desaceleracoesProlongadas;
    private Float variacaoAnormalCurtoPrazo;
    private Float variacaoMediaCurtoPrazo;
    private Float porcentagemTempoVariacaoAnormal;
    private Float mediaVariacaoLongoPrazo;
    private Float larguraHistograma;
    private Float valorMinimoHistograma;
    private Float valorMaximoHistograma;
    private Float numeroPicosHistograma;
    private Float numeroZerosHistograma;
    private Float moduloHistograma;
    private Float mediaHistograma;
    private Float medianaHistograma;
    private Float varianciaHistograma;
    private Float tendenciaHistograma;
    private SaudeEnum saudeFeto;
    private Date dataAvaliacao;

    public Long getIdDadosFeto() {
        return idDadosFeto;
    }

    public void setIdDadosFeto(Long idDadosFeto) {
        this.idDadosFeto = idDadosFeto;
    }

    public Long getIdFeto() {
        return idFeto;
    }

    public void setIdFeto(Long idFeto) {
        this.idFeto = idFeto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Float getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(Float frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public Float getAceleracoes() {
        return aceleracoes;
    }

    public void setAceleracoes(Float aceleracoes) {
        this.aceleracoes = aceleracoes;
    }

    public Float getMovimentoFetalPorSegundo() {
        return movimentoFetalPorSegundo;
    }

    public void setMovimentoFetalPorSegundo(Float movimentoFetalPorSegundo) {
        this.movimentoFetalPorSegundo = movimentoFetalPorSegundo;
    }

    public Float getContracoes() {
        return contracoes;
    }

    public void setContracoes(Float contracoes) {
        this.contracoes = contracoes;
    }

    public Float getDesaceleracoes() {
        return desaceleracoes;
    }

    public void setDesaceleracoes(Float desaceleracoes) {
        this.desaceleracoes = desaceleracoes;
    }

    public Float getDesaceleracoesSeveras() {
        return desaceleracoesSeveras;
    }

    public void setDesaceleracoesSeveras(Float desaceleracoesSeveras) {
        this.desaceleracoesSeveras = desaceleracoesSeveras;
    }

    public Float getDesaceleracoesProlongadas() {
        return desaceleracoesProlongadas;
    }

    public void setDesaceleracoesProlongadas(Float desaceleracoesProlongadas) {
        this.desaceleracoesProlongadas = desaceleracoesProlongadas;
    }

    public Float getVariacaoAnormalCurtoPrazo() {
        return variacaoAnormalCurtoPrazo;
    }

    public void setVariacaoAnormalCurtoPrazo(Float variacaoAnormalCurtoPrazo) {
        this.variacaoAnormalCurtoPrazo = variacaoAnormalCurtoPrazo;
    }

    public Float getVariacaoMediaCurtoPrazo() {
        return variacaoMediaCurtoPrazo;
    }

    public void setVariacaoMediaCurtoPrazo(Float variacaoMediaCurtoPrazo) {
        this.variacaoMediaCurtoPrazo = variacaoMediaCurtoPrazo;
    }

    public Float getPorcentagemTempoVariacaoAnormal() {
        return porcentagemTempoVariacaoAnormal;
    }

    public void setPorcentagemTempoVariacaoAnormal(Float porcentagemTempoVariacaoAnormal) {
        this.porcentagemTempoVariacaoAnormal = porcentagemTempoVariacaoAnormal;
    }

    public Float getMediaVariacaoLongoPrazo() {
        return mediaVariacaoLongoPrazo;
    }

    public void setMediaVariacaoLongoPrazo(Float mediaVariacaoLongoPrazo) {
        this.mediaVariacaoLongoPrazo = mediaVariacaoLongoPrazo;
    }

    public Float getLarguraHistograma() {
        return larguraHistograma;
    }

    public void setLarguraHistograma(Float larguraHistograma) {
        this.larguraHistograma = larguraHistograma;
    }

    public Float getValorMinimoHistograma() {
        return valorMinimoHistograma;
    }

    public void setValorMinimoHistograma(Float valorMininoHistograma) {
        this.valorMinimoHistograma = valorMininoHistograma;
    }

    public Float getValorMaximoHistograma() {
        return valorMaximoHistograma;
    }

    public void setValorMaximoHistograma(Float valorMaximoHistograma) {
        this.valorMaximoHistograma = valorMaximoHistograma;
    }

    public Float getNumeroPicosHistograma() {
        return numeroPicosHistograma;
    }

    public void setNumeroPicosHistograma(Float numeroPicosHistograma) {
        this.numeroPicosHistograma = numeroPicosHistograma;
    }

    public Float getNumeroZerosHistograma() {
        return numeroZerosHistograma;
    }

    public void setNumeroZerosHistograma(Float numeroZerosHistograma) {
        this.numeroZerosHistograma = numeroZerosHistograma;
    }

    public Float getModuloHistograma() {
        return moduloHistograma;
    }

    public void setModuloHistograma(Float moduloHistograma) {
        this.moduloHistograma = moduloHistograma;
    }

    public Float getMediaHistograma() {
        return mediaHistograma;
    }

    public void setMediaHistograma(Float mediaHistograma) {
        this.mediaHistograma = mediaHistograma;
    }

    public Float getMedianaHistograma() {
        return medianaHistograma;
    }

    public void setMedianaHistograma(Float medianaHistograma) {
        this.medianaHistograma = medianaHistograma;
    }

    public Float getVarianciaHistograma() {
        return varianciaHistograma;
    }

    public void setVarianciaHistograma(Float varianciaHistograma) {
        this.varianciaHistograma = varianciaHistograma;
    }

    public Float getTendenciaHistograma() {
        return tendenciaHistograma;
    }

    public void setTendenciaHistograma(Float tendenciaHistograma) {
        this.tendenciaHistograma = tendenciaHistograma;
    }

    public SaudeEnum getSaudeFeto() {
        return saudeFeto;
    }

    public void setSaudeFeto(SaudeEnum saudeFeto) {
        this.saudeFeto = saudeFeto;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}

