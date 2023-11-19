package com.curesharp.dto;

import com.curesharp.util.RiscoEnum;

public class DadosInserirDadosGravidez {

    private RiscoEnum risco;
    private String dataDaAvaliacao;

    public DadosInserirDadosGravidez(RiscoEnum risco, String dataDaAvaliacao) {
        this.risco = risco;
        this.dataDaAvaliacao = dataDaAvaliacao;
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
