package com.financeiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Menu Principal");
        setLayout(null);
        setSize(415, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(200, 0, 200, 30);
        add(btnSair);

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main menu = new Main();
                menu.setVisible(true);
            }
        });
    }
}
