package com.financeiro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            System.err.println("Erro ao buscar usuarios: " + e.getMessage());
            return false;
        }
    }

    public static List<Contas> selectContas(){
        String sql = "SELECT * from contas";
        List<Contas> contas = new ArrayList<>();

        try (Connection connection = Conexao.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){

            while (rs.next()) {
                Contas conta = new Contas(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"), rs.getBoolean("tipoconta"));
                contas.add(conta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuarios: " + e.getMessage());
        }

        return contas;
    }
    
    public static boolean atualizarConta(Contas conta){
        try (Connection connection = Conexao.connect()) {

            String sql = "UPDATE contas SET nome = ?, valor = ?, tipoconta = ? WHERE id = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, conta.getNome());
                pstmt.setDouble(2, conta.getValor());
                pstmt.setBoolean(3, conta.getTipoConta());
                pstmt.setInt(4, conta.getId());

                pstmt.execute();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deleta usuario: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteConta(int id){
        try (Connection connection = Conexao.connect()) {

            String sql = "DELETE from contas WHERE id = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, id);

                pstmt.execute();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deleta usuario: " + e.getMessage());
            return false;
        }
    }
}
