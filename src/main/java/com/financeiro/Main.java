package com.financeiro;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import com.financeiro.model.Contas;
import com.financeiro.screen.FormCad;
import com.financeiro.service.ContaService;

public class Main extends JFrame {

    private final JList<String> listaContas;

    public Main() {
        setTitle("Menu Principal");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnCadastro = new JButton("Cadastro");
        btnCadastro.setBounds(0, 0, 250, 30);
        add(btnCadastro);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(250, 0, 250, 30);
        add(btnSair);

        btnSair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        btnCadastro.addActionListener((var e) -> {
            new FormCad().setVisible(true);
            dispose();
        });

        List<Contas> contas = ContaService.selectContas();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Contas conta : contas) {
            String contaInfo = String.format("ID: %d - Nome: %s - Valor: R$ %.2f - Tipo: %s",
                                             conta.getId(), conta.getNome(), conta.getValor(),
                                             conta.getTipoConta() ? "Entrada" : "Saída");
            model.addElement(contaInfo);
        }

        listaContas = new JList<>(model);
        listaContas.setBounds(0, 50, 500, 200);
        add(listaContas);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main menu = new Main();
            menu.setVisible(true);
        });
    }
}
