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

public class FormAtualizarConta extends JFrame {
    private final JTextField txtNome;
    private final JTextField txtValor;
    private final JComboBox<String> cmbTipoConta;
    private final Contas conta;
    private final Main mainWindow;

    public FormAtualizarConta(Contas conta, Main mainWindow) {
        this.conta = conta;
        this.mainWindow = mainWindow;

        setTitle("Atualizar Conta");

        setLayout(null);
        setSize(415, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 50, 80, 20);
        add(lblNome);

        txtNome = new JTextField(conta.getNome());
        txtNome.setBounds(100, 50, 250, 25);
        add(txtNome);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(20, 90, 80, 20);
        add(lblValor);

        txtValor = new JTextField(String.valueOf(conta.getValor()));
        txtValor.setBounds(100, 90, 250, 25);
        add(txtValor);

        JLabel lblTipoConta = new JLabel("Tipo de Conta:");
        lblTipoConta.setBounds(20, 130, 100, 20);
        add(lblTipoConta);

        cmbTipoConta = new JComboBox<>(new String[] { "Entrada", "Saída" });
        cmbTipoConta.setSelectedIndex(conta.getTipoConta() ? 0 : 1);
        cmbTipoConta.setBounds(120, 130, 230, 25);
        add(cmbTipoConta);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 180, 200, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> atualizarConta());

        JButton btnVoltar = new JButton("Voltar para Menu");
        btnVoltar.setBounds(100, 220, 200, 30);
        add(btnVoltar);

        btnVoltar.addActionListener(e -> voltarParaMenu());

        setLocationRelativeTo(null);
    }

    private void atualizarConta() {
        String nome = txtNome.getText();
        double valor = 0;

        try {
            valor = Double.parseDouble(txtValor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Por favor, insira um valor numérico.");
            return;
        }

        boolean tipoConta = cmbTipoConta.getSelectedIndex() == 0;

        conta.setNome(nome);
        conta.setValor(valor);
        conta.setTipoConta(tipoConta);

        boolean result = ContaService.atualizarConta(conta);

        if (result) {
            JOptionPane.showMessageDialog(this, "Conta atualizada com sucesso");
            mainWindow.carregarContas();
            mainWindow.listaContas.setModel(mainWindow.model);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a conta. Tente novamente.");
        }

        dispose();
    }

    private void voltarParaMenu() {
        // Aqui você pode colocar o código para voltar para o menu principal
        // Por exemplo:
        // new Main().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Contas conta = new Contas("Conta Exemplo", 100.0, true);
                var formAtualizarConta = new FormAtualizarConta(conta, null);
                formAtualizarConta.setVisible(true);
            }
        });
    }
    
}
