package br.com.dbc.vemser.jedimasters.repository;

import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.model.entity.TipoPrint;
import br.com.dbc.vemser.jedimasters.repository.dao.CartaDAO;
import br.com.dbc.vemser.jedimasters.view.PrintsJogoView;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class CartaRepository {

    private final CartaDAO bancoCarta = new CartaDAO();
    private final Scanner input = new Scanner(System.in);
    private final PrintsJogoView printsJogoView = new PrintsJogoView();
    @Getter
    ArrayList<Carta> cartas = bancoCarta.listarCartas();

    public Carta criarCarta(Carta carta) {
        if (carta == null){
            printsJogoView.printCartaController(0, null, TipoPrint.CRIARCARTA);
            printsJogoView.printPartida(0, TipoPrint.TIPOCARTA);
            String tipo = input.nextLine(); // não mais utilizado
            printsJogoView.printPartida(0, TipoPrint.QUANTCARTA);
            int quant = Integer.parseInt(input.nextLine());
            printsJogoView.printPartida(0, TipoPrint.ATRIBUTOATIVOCARTA);
            String atributoAtivo = input.nextLine();
            return bancoCarta.salvarCarta(tipo, quant, atributoAtivo);
        } else {
            return bancoCarta.salvarCarta(carta.getTipo(), carta.getQuant(), carta.getAtributoAtivo());
        }
    }


    public ArrayList<Carta> listarCartas() {
        ArrayList<Carta> cartas = bancoCarta.listarCartas();
        ArrayList<Integer> cartas_ids = bancoCarta.retornarIndex();
        bancoCarta.chamarCartas();

        if (cartas.isEmpty()) {
            printsJogoView.printMonstroController(0, null, TipoPrint.NENHUMACARTA);
            return null;
        }

        for (int i = 0; i < cartas.size(); i++) {
            printsJogoView.printCartaController(cartas_ids.get(i), cartas.get(i), TipoPrint.LISTARCARTAS);
        }

        return cartas;
    }

    public Carta atualizarCarta(Integer id, Carta cartaAtualizar) {
        listarCartas();

        if (id == 0){
            System.out.print("Digite o ID dda carta que deseja renomear: ");
            int idEscolhido = Integer.parseInt(input.nextLine()); // não mais utilizado

            System.out.print("Novo tipo: ");
            String novoTipo = input.nextLine();

            System.out.print("Nova quantidade: ");
            int quantNovo = Integer.parseInt(input.nextLine());

            System.out.print("Novo atributo ativo: ");
            String atributoAtivoNovo = input.nextLine();

            return bancoCarta.atualizarCarta(idEscolhido, novoTipo, quantNovo, atributoAtivoNovo);
        }

        return bancoCarta.atualizarCarta(id, cartaAtualizar.getTipo(), cartaAtualizar.getQuant(), cartaAtualizar.getAtributoAtivo());
    }

    public void deletarCarta(Integer id) {
        listarCartas();

        if(id == 0) {
            System.out.print("Digite o ID da carta que deseja deletar: ");
            int idEscolhido = Integer.parseInt(input.nextLine()); // não mais utilizado
            bancoCarta.deletarCarta(idEscolhido);
        } else {
            bancoCarta.deletarCarta(id);
        }
    }
}
