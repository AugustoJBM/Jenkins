package br.com.dbc.vemser.jedimasters.repository;

import br.com.dbc.vemser.jedimasters.repository.dao.JogadorDAO;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;
import br.com.dbc.vemser.jedimasters.model.entity.TipoPrint;
import br.com.dbc.vemser.jedimasters.view.PrintsJogoView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Scanner;

@Repository
public class JogadorRepository {

    private final JogadorDAO bancoJogador = new JogadorDAO();
    private final Scanner input = new Scanner(System.in);
    private final PrintsJogoView printsJogoView = new PrintsJogoView();

    public Jogador criarJogador(Jogador jogador) {
        if(jogador == null){
            printsJogoView.printPartida(0, TipoPrint.NOMEJOGADOR);
            String nome = input.nextLine(); // não mais utilizado
            return bancoJogador.salvarJogador(nome);
        } else {
            return bancoJogador.salvarJogador(jogador.getNome());
        }
    }

    public ArrayList<Jogador> listarJogadores() {
        ArrayList<Jogador> jogadores = bancoJogador.listarJogadores();

        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador encontrado.");
            return null;
        }

        for (int i = 0; i < jogadores.size(); i++) {
            System.out.printf("%d - %s\n", i + 1,
                    jogadores.get(i).getNome());
        }

        return jogadores;
    }

    public Jogador atualizarJogador(Integer id, Jogador jogadorAtualizar) {
        listarJogadores();

        if(id == 0) {
            System.out.print("Digite o ID do jogador que deseja renomear: ");
            int idEscolhido = Integer.parseInt(input.nextLine()); // não mais utilizado

            System.out.print("Novo nome: ");
            String novoNome = input.nextLine(); // não mais utilizado

            return bancoJogador.atualizarJogador(idEscolhido, novoNome);
        } else {
            return bancoJogador.atualizarJogador(id, jogadorAtualizar.getNome());
        }
    }

    public void deletarJogador(Integer id) {
        listarJogadores();

        if(id == 0) {
            System.out.print("Digite o ID do jogador que deseja deletar: ");
            int idEscolhido = Integer.parseInt(input.nextLine());
            bancoJogador.deletarJogador(idEscolhido);
            return;
        } else {
            bancoJogador.deletarJogador(id);
        }
    }
}
