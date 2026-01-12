package br.com.dbc.vemser.jedimasters.repository.dao;

import br.com.dbc.vemser.jedimasters.config.ConexaoFactoryConfig;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.TipoMonstro;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.*;
import br.com.dbc.vemser.jedimasters.service.Inicializador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MonstroDAO {
    ConexaoFactoryConfig conexaoFactoryConfig = new ConexaoFactoryConfig();
    //Inicializador inicializador;
    // Metodo para inserir um novo Monstro no banco
    public Monstro salvarMonstro(TipoMonstro elemento, String nome, int vida, int danoBase) {

        String sql = "INSERT INTO MONSTRO(id_monstro, id_elemento, nome, vida, danoBase) " +
                "VALUES(SEQ_MONSTRO.NEXTVAL, ?, ?, ?, ?)";

        try (Connection conn = conexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(2, nome);

            stm.setInt(3, vida);

            stm.setInt(4, danoBase);
            
            switch (elemento) {
                case FOGO:
                    stm.setInt(1, 1);
                    stm.execute();
                    System.out.println("Monstro '" + nome + "' inserido com sucesso!");
                    return new MonstroFogo(vida, nome, danoBase);

                case AGUA:
                    stm.setInt(1, 2);
                    stm.execute();
                    System.out.println("Monstro '" + nome + "' inserido com sucesso!");
                    return new MonstroAgua(vida, nome, danoBase);

                case AR:
                    stm.setInt(1, 3);
                    stm.execute();
                    System.out.println("Monstro '" + nome + "' inserido com sucesso!");
                    return new MonstroAr(vida, nome, danoBase);

                case TERRA:
                    stm.setInt(1, 4);
                    stm.execute();
                    System.out.println("Monstro '" + nome + "' inserido com sucesso!");
                    return new MonstroTerra(vida, nome, danoBase);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao salvar o monstro: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void listarMonstros() {
        String sql = "SELECT ID_MONSTRO, NOME, VIDA, DANOBASE FROM MONSTRO ORDER BY ID_MONSTRO";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rst = stm.executeQuery()) { // executeQuery é para SELECT

            System.out.println("--- MONSTROS ATIVOS ---");

            while (rst.next()) {
                int id = rst.getInt("ID_MONSTRO");
                String nome = rst.getString("NOME");
                int vida = rst.getInt("VIDA");
                int dano = rst.getInt("DANOBASE");

                System.out.printf("ID: %d | Nome: %s | Vida: %d | Dano: %d\n", id, nome, vida, dano);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
    }

    public void chamarMonstros() {
        String sql = "SELECT ID_MONSTRO, ID_ELEMENTO, NOME, VIDA, DANOBASE FROM MONSTRO ORDER BY ID_MONSTRO";
        Monstro monstro = null;
        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rst = stm.executeQuery()) { // executeQuery é para SELECT

            while (rst.next()) {
                int id = rst.getInt("ID_MONSTRO");
                int id_elemento = rst.getInt("ID_ELEMENTO");
                String nome = rst.getString("NOME");
                int vida = rst.getInt("VIDA");
                int dano = rst.getInt("DANOBASE");

                if(id_elemento == 1){
                    monstro = new MonstroFogo(vida, nome, dano);
                }
                if(id_elemento == 2){
                    monstro = new MonstroAgua(vida, nome, dano);
                }
                if(id_elemento == 3){
                    monstro = new MonstroTerra(vida, nome, dano);
                }
                if(id_elemento == 4){
                    monstro = new MonstroAr(vida, nome, dano);
                }

                Inicializador.criarMonstros(monstro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
    }

    public ArrayList<Integer> retornarIndex(){
        String sql = "SELECT ID_MONSTRO FROM MONSTRO ORDER BY ID_MONSTRO";

        ArrayList<Integer> monstro_ids = new ArrayList<Integer>();

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet rst = stm.executeQuery()) {

            while (rst.next()) {
                int id = rst.getInt("ID_MONSTRO");
                monstro_ids.add(id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
        return monstro_ids;
    }


    public void atualizarMonstro(int id_monstro, String nome, int vida, int dano) {
        // Queremos mudar a VIDA para um novo valor, buscando pelo NOME
        String sql = "UPDATE MONSTRO SET NOME = ?, VIDA = ?, DANOBASE = ? WHERE ID_MONSTRO = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, nome);
            stm.setInt(2, vida);
            stm.setInt(3, dano);
            stm.setInt(4, id_monstro);

            int linhasAfetadas = stm.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("✅ Monstro Atualizado");
            } else {
                System.out.println("⚠️ Monstro não encontrado para atualização.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void deletarMonstro(int id_monstro) {

        String sql = "DELETE FROM MONSTRO WHERE ID_MONSTRO = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, id_monstro);

            int linhasAfetadas = stm.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("✅ Monstro Deletado");
            } else {
                System.out.println("⚠️ Monstro não encontrado para atualização.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar: " + e.getMessage());
        }
    }



    public void atualizarVida(String nomeMonstro, int novaVida) {

        String sql = "UPDATE MONSTRO SET VIDA = ? WHERE NOME = ?";

        try (Connection conn = ConexaoFactoryConfig.recuperarConexao();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setInt(1, novaVida);
            stm.setString(2, nomeMonstro);

            int linhasAfetadas = stm.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("✅ Vida do monstro " + nomeMonstro + " atualizada para " + novaVida + ".");
            } else {
                System.out.println("⚠️ Monstro não encontrado para atualização.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}
