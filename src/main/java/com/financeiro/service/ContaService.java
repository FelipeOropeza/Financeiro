package com.financeiro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.financeiro.config.Conexao;
import com.financeiro.model.Contas;

public class ContaService {

    public static boolean insertConta(Contas contas) {
        try (Connection connection = Conexao.connect()) {

            String sql = "INSERT INTO contas (nome, valor, tipoconta) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, contas.getNome());
                pstmt.setDouble(2, contas.getValor());
                pstmt.setBoolean(3, contas.getTipoConta());

                pstmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
