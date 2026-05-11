package com.rachaai.model;

import java.time.LocalDate;

public class Fatura {
    private int id;
    private String nome;
    private LocalDate vencimento;
    private LocalDate criacao;

    public Fatura (int id, String nome, LocalDate vencimento, LocalDate criacao) {
        this.id = id;
        this.nome = nome;
        this.vencimento = vencimento;
        this.criacao = criacao;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public LocalDate getVencimento() { return vencimento; }
    public LocalDate getCriacao() { return criacao; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setVencimento(LocalDate vencimento) { this.vencimento = vencimento; }
    public void setCriacao(LocalDate criacao) { this.criacao = criacao; }

    @Override
    public String toString() { return nome; }
}
