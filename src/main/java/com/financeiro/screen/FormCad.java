package com.financeiro.screen;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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

        cmbTipoConta = new JComboBox<>(new String[] {"Entrada", "Saída"});
        cmbTipoConta.setBounds(120, 130, 230, 25);
        add(cmbTipoConta);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 180, 200, 30);
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> cadastrarConta());

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

        JOptionPane.showMessageDialog(this, """
                                            Conta cadastrada com sucesso!
                                            Nome: """ + nome + "\n" +
                "Valor: R$ " + valor + "\n" +
                "Tipo de Conta: " + (tipoConta ? "Entrada" : "Saída"));
        
        txtNome.setText("");
        txtValor.setText("");
        cmbTipoConta.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormCad formCad = new FormCad();
            formCad.setVisible(true);
        });
    }
}
