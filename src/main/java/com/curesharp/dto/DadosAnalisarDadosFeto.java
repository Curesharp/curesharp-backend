package com.curesharp.dto;

import com.curesharp.util.SaudeEnum;

public class DadosAnalisarDadosFeto {

    private SaudeEnum saudeFeto;
    private String dataAvaliacao;

    public DadosAnalisarDadosFeto(SaudeEnum saudeFeto, String dataAvaliacao) {
        this.saudeFeto = saudeFeto;
        this.dataAvaliacao = dataAvaliacao;
    }

    public SaudeEnum getSaudeFeto() {
        return saudeFeto;
    }

    public void setSaudeFeto(SaudeEnum saudeFeto) {
        this.saudeFeto = saudeFeto;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
