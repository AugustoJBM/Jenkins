package br.com.dbc.vemser.jedimasters.view;

import java.util.Scanner;
import br.com.dbc.vemser.jedimasters.controller.*;
import br.com.dbc.vemser.jedimasters.repository.CartaRepository;
import br.com.dbc.vemser.jedimasters.repository.JogadorRepository;
import br.com.dbc.vemser.jedimasters.repository.MonstroRepository;

public class EscolhaView {
    MenuView menuView;
    Scanner input;
    MonstroRepository monstroController;
    GerenciamentoPartidaController gerencia;
    EntradaValidadaController validador;
    JogadorRepository jogadorController;
    CartaRepository cartaController;
    public EscolhaView(MenuView menuView) {
        this.menuView = menuView;
        this.input = new Scanner(System.in);
        this.monstroController = new MonstroRepository();
        this.gerencia = new GerenciamentoPartidaController(monstroController);
        this.validador = new EntradaValidadaController(input);
        this.jogadorController = new JogadorRepository();
        this.cartaController = new CartaRepository();
    }

    public void escolhas(){
        int opcao;
        do{
            menuView.menu();
            opcao = validador.validarInt();
            input.nextLine();
            switch (opcao){
                case 1:
                    gerencia.iniciarPartida();
                    break;
                case 2:
                    menuView.exibirRegras();
                    break;
                case 3:
                    crudMonstro();
                    break;
                case 4:
                    crudJogador();
                    break;
                case 5:
                    crudCarta();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.print("Digite uma das opções acima!\n");
                    break;
            }
        }while(opcao != 6);
    }

    public void crudCarta(){
        int opcao;
        do{
            menuView.menuCarta();
            opcao = validador.validarInt();
            input.nextLine();
            switch (opcao){
                case 1:
                    cartaController.listarCartas();
                    break;
                case 2:
                    cartaController.criarCarta(null);
                    break;
                case 3:
                    cartaController.atualizarCarta(0,null);
                    break;
                case 4:
                    cartaController.deletarCarta(0);
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.print("Digite uma das opções acima!\n");
                    break;
            }
        }while(opcao != 5);
    }

    public void crudMonstro(){
        int opcao;
        do{
            menuView.menuMonstro();
            opcao = validador.validarInt();
            input.nextLine();
            switch (opcao){
                case 1:
                    monstroController.listarMonstros();
                    break;
                case 2:
                    monstroController.criarMonstroCrud();
                    break;
                case 3:
                    monstroController.atualizarMonstro(0, null);
                    break;
                case 4:
                    monstroController.deletarMonstro(0);
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.print("Digite uma das opções acima!\n");
                    break;
            }
        }while(opcao != 5);
    }

    public void crudJogador(){
        int opcao;
        do{
            menuView.menuJogador();
            opcao = validador.validarInt();
            input.nextLine();
            switch (opcao){
                case 1:
                    jogadorController.listarJogadores();
                    break;
                case 2:
                    jogadorController.criarJogador(null);
                    break;

                case 3:
                    jogadorController.atualizarJogador(0, null);
                    break;
                case 4:
                    jogadorController.deletarJogador(0);
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.print("Digite uma das opções acima!\n");
                    break;
            }
        }while(opcao != 5);
    }
}
