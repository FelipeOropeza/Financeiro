package com.financeiro.model;

public class Contas {
    private int id;
    private String nome;
    private double valor;
    private boolean tipoConta;

    public Contas(int id, String nome, double valor, boolean tipoConta) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.tipoConta = tipoConta;
    }

    public Contas(String nome, double valor, boolean tipoConta) {
        this.nome = nome;
        this.valor = valor;
        this.tipoConta = tipoConta;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public boolean getTipoConta(){
        return tipoConta;
    }

    public void setTipoConta(boolean tipoConta){
        this.tipoConta = tipoConta;
    }
}
