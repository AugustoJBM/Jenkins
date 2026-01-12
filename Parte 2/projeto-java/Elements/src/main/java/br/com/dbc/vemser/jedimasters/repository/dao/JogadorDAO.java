package br.com.dbc.vemser.jedimasters.repository.dao;

import br.com.dbc.vemser.jedimasters.config.ConexaoFactoryConfig;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;

import java.sql.*;
import java.util.ArrayList;

public class JogadorDAO {

    public Jogador salvarJogador(String nome) {
        String sql = "INSERT INTO JOGADORES (id_jogador, nome) VALUES (SEQ_JOGADORES.NEXTVAL, ?)";
        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, nome);
            stm.executeUpdate();

            System.out.println("Jogador salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar jogador: " + e.getMessage());
        }
        return new Jogador(nome);
    }

    public ArrayList<Jogador> listarJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM JOGADORES";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Jogador jogador = new Jogador(
                        rs.getString("NOME")
                );
                jogadores.add(jogador);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar jogadores: " + e.getMessage());
        }

        return jogadores;
    }

    public Jogador atualizarJogador(int id, String nomeNovo) {
        String sql = "UPDATE JOGADORES SET NOME = ? WHERE ID_JOGADOR = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, nomeNovo);
            stm.setInt(2, id);

            int linhas = stm.executeUpdate();

            if (linhas > 0)
                System.out.println("Jogador atualizado com sucesso!");
            else
                System.out.println("Jogador não encontrado.");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar jogador: " + e.getMessage());
        }
        return new Jogador(nomeNovo);
    }

    public void deletarJogador(int id) {
        String sql = "DELETE FROM JOGADORES WHERE ID_JOGADOR = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id);

            int linhas = stm.executeUpdate();

            if (linhas > 0)
                System.out.println("Jogador deletado com sucesso!");
            else
                System.out.println("Jogador não encontrado.");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar jogador: " + e.getMessage());
        }
    }
}
