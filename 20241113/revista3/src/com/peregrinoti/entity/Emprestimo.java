package com.peregrinoti.entity;

import java.sql.Date;

public class Emprestimo {

    private Long id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Amigo amigo;
    private Revista revista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    // Getters espec�ficos para nome e telefone do amigo
    public String getNomeAmigo() {
        return amigo != null ? amigo.getNome() : null;
    }

    public String getTelefoneAmigo() {
        return amigo != null ? amigo.getTelefone() : null;
    }

    // Getter espec�fico para o nome da revista
    public String getNomeRevista() {
        return revista != null ? revista.getNome() : null;
    }
}
