package com.curesharp.dto;

public class DadosResponseUsuario {
    private Long idUsuario;
    private String email;
    private String nome;

    public DadosResponseUsuario(Long idUsuario, String email, String nome) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nome = nome;
    }

    public Long getIdUsuario() {
    return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public String getNome() {
    return nome;
    }

    public void setNome(String nome) {
    this.nome = nome;
    }

}
