package com.financeiro;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.financeiro.screen.FormCad;

public class Main extends JFrame {

    public Main() {
        setTitle("Menu Principal");
        setLayout(null);
        setSize(415, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnCadastro = new JButton("Cadastro");
        btnCadastro.setBounds(0, 0, 200, 30);
        add(btnCadastro);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(200, 0, 200, 30);
        add(btnSair);

        btnSair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        btnCadastro.addActionListener((var e) -> {
            new FormCad().setVisible(true);
            dispose();
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main menu = new Main();
            menu.setVisible(true);
        });
    }
}
