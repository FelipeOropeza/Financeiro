package com.financeiro.screen;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.financeiro.Main;
import com.financeiro.model.Contas;
import com.financeiro.service.ContaService;

public class FormCad extends JFrame {
    private final JTextField txtNome;
    private final JTextField txtValor;
    private final JComboBox<String> cmbTipoConta;

    public FormCad() {
        setTitle("Cadastro de Conta");

        setLayout(null);
        setSize(415, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 50, 80, 20);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 50, 250, 25);
        add(txtNome);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(20, 90, 80, 20);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(100, 90, 250, 25);
        add(txtValor);

        JLabel lblTipoConta = new JLabel("Tipo de Conta:");
        lblTipoConta.setBounds(20, 130, 100, 20);
        add(lblTipoConta);

        cmbTipoConta = new JComboBox<>(new String[] { "Entrada", "Saída" });
        cmbTipoConta.setBounds(120, 130, 230, 25);
        add(cmbTipoConta);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 180, 200, 30);
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> cadastrarConta());

        JButton btnVoltar = new JButton("Voltar para Menu");
        btnVoltar.setBounds(100, 220, 200, 30);
        add(btnVoltar);

        btnVoltar.addActionListener(e -> voltarParaMenu());

        setLocationRelativeTo(null);
    }

    private void cadastrarConta() {
        String nome = txtNome.getText();
        double valor = 0;

        try {
            valor = Double.parseDouble(txtValor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Por favor, insira um valor numérico.");
            return;
        }

        boolean tipoConta = cmbTipoConta.getSelectedIndex() == 0;

        Contas contas = new Contas(nome, valor, tipoConta);

        boolean result = ContaService.insertConta(contas);

        if (result) {
            JOptionPane.showMessageDialog(this, "A conta foi inserida com sucesso");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir a conta. Tente novamente.");
        }

        txtNome.setText("");
        txtValor.setText("");
        cmbTipoConta.setSelectedIndex(0);
    }

    private void voltarParaMenu() {
        new Main().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormCad formCad = new FormCad();
            formCad.setVisible(true);
        });
    }
}
