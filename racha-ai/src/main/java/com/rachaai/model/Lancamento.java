package com.rachaai.model;

import java.time.LocalDate;

public class Lancamento {
    private int id;
    private String descricao;
    private double valorParcela;
    private int totalParcelas;
    private int parcelaAtual;
    private LocalDate dataInicio;
    private Pessoa responsavel;
    private Fatura fatura;

    public Lancamento(int id, String descricao, double valorParcela, int totalParcelas,
                      int parcelaAtual, LocalDate dataInicio, Pessoa responsavel, Fatura fatura) {
        this.id = id;
        this.descricao = descricao;
        this.valorParcela = valorParcela;
        this.totalParcelas = totalParcelas;
        this.parcelaAtual = parcelaAtual;
        this.dataInicio = dataInicio;
        this.responsavel = responsavel;
        this.fatura = fatura;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValorParcela() { return valorParcela; }
    public int getTotalParcelas() { return totalParcelas; }
    public int getParcelaAtual() { return parcelaAtual; }
    public LocalDate getDataInicio() { return dataInicio; }
    public Pessoa getResponsavel() { return responsavel; }
    public Fatura getFatura() { return fatura; }

    public void setId(int id) { this.id = id; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setValorParcela(double valorParcela) { this.valorParcela = valorParcela; }
    public void setTotalParcelas(int totalParcelas) { this.totalParcelas = totalParcelas; }
    public void setParcelaAtual(int parcelaAtual) { this.parcelaAtual = parcelaAtual; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public void setResponsavel(Pessoa responsavel) { this.responsavel = responsavel; }
    public void setFatura(Fatura fatura) { this.fatura = fatura; }

    @Override
    public String toString() {
        return descricao + " (" + parcelaAtual + "/" + totalParcelas + ")";
    }
}