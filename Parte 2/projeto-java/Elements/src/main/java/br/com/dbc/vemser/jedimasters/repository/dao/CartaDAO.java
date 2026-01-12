package br.com.dbc.vemser.jedimasters.repository.dao;

import br.com.dbc.vemser.jedimasters.config.ConexaoFactoryConfig;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.*;
import br.com.dbc.vemser.jedimasters.service.Inicializador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartaDAO {

    public Carta salvarCarta(String tipo, int quant, String atributoAtivo) {
        String sql = "INSERT INTO CARTAS (id_carta, tipo, quant, atributoAtivo) VALUES (SEQ_CARTAS.NEXTVAL, ?, ?, ?)";
        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, tipo);
            stm.setInt(2, quant);
            stm.setString(3, atributoAtivo);
            stm.execute();

            System.out.println("Carta salva com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar carta: " + e.getMessage());
            e.printStackTrace();
        }
        return new Carta(tipo, quant, atributoAtivo);
    }

    public ArrayList<Carta> listarCartas() {
        ArrayList<Carta> cartas = new ArrayList<>();
        String sql = "SELECT * FROM CARTAS";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Carta carta = new Carta(
                        rs.getString("TIPO"),
                        rs.getInt("QUANT"),
                        rs.getString("ATRIBUTOATIVO")
                );
                cartas.add(carta);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar cartas: " + e.getMessage());
        }

        return cartas;
    }

    public void chamarCartas() {
        String sql = "SELECT ID_CARTA, TIPO, QUANT, ATRIBUTOATIVO FROM CARTAS ORDER BY ID_CARTA";
        Carta carta = null;
        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rst = stm.executeQuery()) { // executeQuery é para SELECT

            while (rst.next()) {
                carta = new Carta(
                        rst.getString("TIPO"),
                        rst.getInt("QUANT"),
                        rst.getString("ATRIBUTOATIVO")
                );

                Inicializador.criarCartas(carta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
    }

    public ArrayList<Integer> retornarIndex(){
        String sql = "SELECT ID_CARTA FROM CARTAS ORDER BY ID_CARTA";

        ArrayList<Integer> carta_ids = new ArrayList<Integer>();

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rst = stm.executeQuery()) {

            while (rst.next()) {
                int id = rst.getInt("ID_CARTA");
                carta_ids.add(id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
        return carta_ids;
    }

    public Carta atualizarCarta(int id, String tipoNovo, int quantNovo, String atributoAtivoNovo) {
        String sql = "UPDATE CARTAS SET TIPO = ?, QUANT =?, ATRIBUTOATIVO = ? WHERE ID_CARTA = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, tipoNovo);
            stm.setInt(2, quantNovo);
            stm.setString(3, atributoAtivoNovo);
            stm.setInt(4, id);

            int linhas = stm.executeUpdate();

            if (linhas > 0)
                System.out.println("Carta atualizada com sucesso!");
            else
                System.out.println("Carta não encontrada.");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar carta: " + e.getMessage());
        }
        return new Carta(tipoNovo, quantNovo, atributoAtivoNovo);
    }

    public void deletarCarta(int id) {

        String sql = "DELETE FROM CARTAS WHERE ID_CARTA = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id);

            int linhas = stm.executeUpdate();

            if (linhas > 0) {
                System.out.println("Carta deletada com sucesso!");
            } else {
                System.out.println("Carta não encontrada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar carta: " + e.getMessage());
        }
    }
}
