package com.financeiro;
import com.financeiro.model.Contas;

public class Main {
    public static void main(String[] args) {
        Contas contas = new Contas(2, "Conta de luz", 200.00, false);
        contas.setId(5);

        System.out.println(contas.getId()+" "+contas.getNome()+" "+contas.getValor()+" "+contas.getTipoConta());
    }
}