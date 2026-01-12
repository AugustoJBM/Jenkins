package br.com.dbc.vemser.jedimasters.controller;

import br.com.dbc.vemser.jedimasters.model.entity.*;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.PocaoCura;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.PocaoDano;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.PocaoSono;
import br.com.dbc.vemser.jedimasters.repository.MonstroRepository;
import br.com.dbc.vemser.jedimasters.service.Inicializador;
import br.com.dbc.vemser.jedimasters.view.MenuView;
import br.com.dbc.vemser.jedimasters.view.PrintsJogoView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GerenciamentoPartidaController {

    private final Inicializador inicializador;
    private ArrayList<Monstro> monstros ;
    private final ArrayList<Monstro> monstrosInimigo;
    private final MonstroRepository monstroController;
    private Partida partida;
    Random random;
    Scanner input;
    EntradaValidadaController entradaValidada;
    PlayMusicController playMusic;
    PrintsJogoView printsJogoView;
    MenuView menuView;

    public GerenciamentoPartidaController(MonstroRepository monstroController){
        this.inicializador = new Inicializador();
        this.monstros = monstroController.getMonstros();
        this.monstrosInimigo = monstroController.criarCopiaProfunda(Inicializador.getMonstros());
        this.monstroController = monstroController;
        this.random = new Random();
        this.input = new Scanner(System.in);
        this.entradaValidada = new EntradaValidadaController(input);
        this.playMusic = new PlayMusicController();
        this.printsJogoView = new PrintsJogoView();
        this.menuView = new MenuView();
    }

    public void atacar(Monstro atacante, ArrayList<Monstro> defensores){
        playMusic.somAtaque();
        int indiceSorteado = random.nextInt(defensores.size());
        defensores.get(indiceSorteado).setVida(defensores.get(indiceSorteado).getVida() - atacante.getDanoBase());

        printsJogoView.printAtaque(atacante, defensores.get(indiceSorteado), TipoPrint.ATAQUESORT);
    }

    public void atacar(Monstro atacante, Monstro defensor){
        playMusic.somAtaque();
        defensor.setVida(defensor.getVida() - atacante.getDanoBase());
        printsJogoView.printAtaque(atacante, defensor, TipoPrint.ATAQUE);
    }

    public void regenerar(){
        playMusic.somRegenerar();
        // Comentario para correção
        partida.getJogadorAtacante().getMonstroAtivo().setVida(partida.getJogadorAtacante().getMonstroAtivo().getVida() + random.nextInt(100));
        if (partida.getJogadorAtacante().getMonstroAtivo().getVida() > 120) {
            partida.getJogadorAtacante().getMonstroAtivo().setVida(120);
        }
    }

    public void sortearCartas(){
        ArrayList<Carta> cartas = inicializador.getCartas();
        Carta sorteada = cartas.get(random.nextInt(cartas.size()));

        int vidaAtacante = partida.getJogadorAtacante().getMonstroAtivo().getVida();
        int DanoAtacante = partida.getJogadorAtacante().getMonstroAtivo().getDanoBase();

        if (sorteada.getTipo().equals("aumenta")) {
            if (sorteada.getAtributoAtivo().equals("vida")) {
                partida.getJogadorAtacante().getMonstroAtivo().setVida(vidaAtacante + sorteada.getQuant());
            } else {
                partida.getJogadorAtacante().getMonstroAtivo().setDanoBase(DanoAtacante + sorteada.getQuant());
            }
        } else {
            if (sorteada.getAtributoAtivo().equals("vida")) {
                partida.getJogadorAtacante().getMonstroAtivo().setVida(vidaAtacante - sorteada.getQuant());
            } else {
                partida.getJogadorAtacante().getMonstroAtivo().setDanoBase(DanoAtacante - sorteada.getQuant());
                if (partida.getJogadorAtacante().getMonstroAtivo().getDanoBase() < 0){
                    partida.getJogadorAtacante().getMonstroAtivo().setDanoBase(0);
                }
            }
        }

        printsJogoView.sortCarta(sorteada);
    }

    public void iniciarPartida(){
        boolean controle = true;
        Jogador jogador1;
        Jogador jogador2;
        boolean partidaEmAndamento;

        do{
            printsJogoView.printPartida(0, TipoPrint.NOMEJOGADOR);
            String nomeJ1 = input.nextLine();


            monstroController.listarMonstros();

            printsJogoView.printPartida(0, TipoPrint.ESCOLHAMONSTRO);

            monstros = monstroController.getMonstros();

            int[] selecoesJogador = entradaValidada.validarRecorrenciaMonstro(1, 3, monstroController.getMonstros());
            jogador1 = new Jogador(nomeJ1, monstros.get(selecoesJogador[0]), monstros.get(selecoesJogador[1]), monstros.get(selecoesJogador[2]));

            int[] selecoesSistema = entradaValidada.validarRecorrenciaMonstro(2, 3, monstrosInimigo);
            jogador2 = new Jogador("Systerma", monstrosInimigo.get(selecoesSistema[0]), monstrosInimigo.get(selecoesSistema[1]), monstrosInimigo.get(selecoesSistema[2]));
            partida = new Partida(jogador1, jogador2);


            int escolha;
            do{
                menuView.menuConfirmaEscolha();

                escolha = entradaValidada.validarInt();

                if (escolha != 1 && escolha != 2) {
                    printsJogoView.printPartida(0, TipoPrint.ESCOLHA1OU2);
                }
                input.nextLine();
            }while(escolha != 1 && escolha != 2);

            if (escolha == 1) {
                controle = false;
            } else {
                jogador1.getMonstrosJogador().remove(monstros.get(selecoesJogador[0]));
                jogador1.getMonstrosJogador().remove(monstros.get(selecoesJogador[1]));
                jogador1.getMonstrosJogador().remove(monstros.get(selecoesJogador[2]));
            }
        }while(controle);

        int pocaoUsada = 0;

        partidaEmAndamento = true;
        playMusic.somInicioPartida();
        do{
            iniciarTurno();
            if (partida.getJogadorAtacante().getMonstroAtivo().getVida() <= 0) {

                printsJogoView.printTurno(partida.getJogadorAtacante().getMonstroAtivo().getNome(), TipoPrint.DERROTAMONSTRO);

                partida.getJogadorAtacante().getMonstrosJogador().remove(partida.getJogadorAtacante().getMonstroAtivo());
                if(!partida.getJogadorAtacante().getMonstrosJogador().isEmpty()){

                    printsJogoView.printTurno(null, TipoPrint.PROXDEFENSOR);
                    partida.getJogadorAtacante().setMonstroAtivo();
                    partida.setMonstroAtivoJ1(jogador1.getMonstroAtivo());
                    partida.setMonstroAtivoJ2(jogador2.getMonstroAtivo());
                }
            }
            if (partida.getJogadorDefensor().getMonstroAtivo().getVida() <= 0 && !partida.getJogadorDefensor().getMonstrosJogador().isEmpty()){

                printsJogoView.printTurno(partida.getJogadorAtacante().getMonstroAtivo().getNome(), TipoPrint.DERROTAMONSTRO);

                partida.getJogadorDefensor().getMonstrosJogador().remove(partida.getJogadorDefensor().getMonstroAtivo());
                if(!partida.getJogadorDefensor().getMonstrosJogador().isEmpty()){

                    printsJogoView.printTurno(null, TipoPrint.PROXDEFENSOR);
                    partida.getJogadorDefensor().setMonstroAtivo();
                    partida.setMonstroAtivoJ1(jogador1.getMonstroAtivo());
                    partida.setMonstroAtivoJ2(jogador2.getMonstroAtivo());
                }
            }

            Monstro mAJ1 = partida.getMonstroAtivoJ1();
            Monstro mAJ2 = partida.getMonstroAtivoJ2();

            printsJogoView.printStatusMAJ(mAJ1, mAJ2);

            menuView.menuPartida();
            controle = true;
            if(partida.getJogadorDefensor().getMonstrosJogador().isEmpty()) {
                controle = false;
                partidaEmAndamento = false;

                printsJogoView.printTurno(partida.getJogadorDefensor().getNome(), TipoPrint.DERROTA);
                playMusic.pararSom();
                input.nextLine();
            }
            if(partida.getJogadorAtacante().getMonstrosJogador().isEmpty()) {
                controle = false;
                partidaEmAndamento = false;

                printsJogoView.printTurno(partida.getJogadorAtacante().getNome(), TipoPrint.DERROTA);
                playMusic.pararSom();
                input.nextLine();
            }
            while(controle){
                int opcao = entradaValidada.validarInt();
                switch (opcao){
                    case 1:
                        atacar(partida.getJogadorAtacante().getMonstroAtivo(), partida.getJogadorDefensor().getMonstroAtivo());
                        controle = false;
                        break;
                    case 2:
                        atacar(partida.getJogadorAtacante().getMonstroAtivo(), partida.getJogadorDefensor().getMonstrosJogador());
                        controle = false;
                        break;
                    case 3:
                        regenerar();
                        controle = false;
                        break;
                    case 4:
                        pocaoUsada = usarPocao();
                        break;
                    case 5:
                        partidaEmAndamento = false;
                        controle = false;

                        printsJogoView.printMenuPartida(TipoPrint.VOLTARMENU);
                        playMusic.somFimPartida();
                        playMusic.pararSom();
                        break;
                    default:
                        printsJogoView.printMenuPartida(TipoPrint.OPCAOINEXISTENTE);
                        break;
                }
            }

            if (pocaoUsada == 3) {
                pocaoUsada = removerEfeitoPocao(pocaoUsada);
            } else if (partida.getJogadorAtacante() == jogador2) {
                pocaoUsada = removerEfeitoPocao(pocaoUsada);
                partida.setJogadorAtacante(jogador1);
                partida.setJogadorDefensor(jogador2);

            } else {
                pocaoUsada = removerEfeitoPocao(pocaoUsada);
                partida.setJogadorAtacante(jogador2);
                partida.setJogadorDefensor(jogador1);
            }

            if (partida.getJogadorAtacante().getMonstroAtivo().getVida() <= 0) {

                printsJogoView.printTurno(partida.getJogadorAtacante().getMonstroAtivo().getNome(), TipoPrint.DERROTAMONSTRO);

                partida.getJogadorAtacante().getMonstrosJogador().remove(partida.getJogadorAtacante().getMonstroAtivo());
                if(!partida.getJogadorAtacante().getMonstrosJogador().isEmpty()){
                    printsJogoView.printTurno(null, TipoPrint.PROXDEFENSOR);
                    partida.getJogadorAtacante().setMonstroAtivo();
                    partida.setMonstroAtivoJ1(jogador1.getMonstroAtivo());
                    partida.setMonstroAtivoJ2(jogador2.getMonstroAtivo());
                }
            }
            if (partida.getJogadorDefensor().getMonstroAtivo().getVida() <= 0 && !partida.getJogadorDefensor().getMonstrosJogador().isEmpty()){

                printsJogoView.printTurno(partida.getJogadorAtacante().getMonstroAtivo().getNome(), TipoPrint.DERROTAMONSTRO);

                partida.getJogadorDefensor().getMonstrosJogador().remove(partida.getJogadorDefensor().getMonstroAtivo());
                if(!partida.getJogadorDefensor().getMonstrosJogador().isEmpty()){
                    printsJogoView.printTurno(null, TipoPrint.PROXDEFENSOR);

                    partida.getJogadorDefensor().setMonstroAtivo();
                    partida.setMonstroAtivoJ1(jogador1.getMonstroAtivo());
                    partida.setMonstroAtivoJ2(jogador2.getMonstroAtivo());
                }
            }
            if(partida.getJogadorDefensor().getMonstrosJogador().isEmpty()) {
                partidaEmAndamento = false;

                printsJogoView.printTurno(partida.getJogadorDefensor().getNome(), TipoPrint.DERROTAMONSTRO);

                playMusic.pararSom();
                input.nextLine();
            }
            if(partida.getJogadorAtacante().getMonstrosJogador().isEmpty()) {
                partidaEmAndamento = false;

                printsJogoView.printTurno(partida.getJogadorAtacante().getNome(), TipoPrint.DERROTAMONSTRO);

                playMusic.pararSom();
                input.nextLine();
            }
        } while(partidaEmAndamento);
        monstroController.resetarMonstros();
    }

    public void iniciarTurno(){
        printsJogoView.printInicioTurno(partida.getJogadorAtacante().getNome());
        sortearCartas();
    }

    public int usarPocao() {
        menuView.menuPocao();
        int opcao;

        do {
            opcao = input.nextInt();
            if (!(1 <= opcao && opcao <= 3)) {
                printsJogoView.efeitoPorcao(TipoPrint.POCAOINEXISTENTE);
            }
        } while (!(1 <= opcao && opcao <= 3));
        playMusic.somUsarPocao();
        input.nextLine();

        Jogador jogadorPocao = partida.getJogadorAtacante();
        switch (opcao) {
            case 1: {
                if (jogadorPocao.pocoes.get(0) != null) {
                    PocaoDano pocaoEscolhida = new PocaoDano();
                    pocaoEscolhida.usarPocao(jogadorPocao);
                    jogadorPocao.pocoes.set(0, null);
                    return 1;
                } else {
                    printsJogoView.efeitoPorcao(TipoPrint.POCAOUTILIZADA);
                    break;
                }
            }
            case 2:
                if (jogadorPocao.pocoes.get(1) != null) {
                    PocaoCura pocaoEscolhida = new PocaoCura();
                    pocaoEscolhida.usarPocao(jogadorPocao);
                    jogadorPocao.pocoes.set(1, null);
                    return 2;
                } else {
                    printsJogoView.efeitoPorcao(TipoPrint.POCAOUTILIZADA);
                    break;
                }
            case 3:
                if (jogadorPocao.pocoes.get(2) != null) {
                    PocaoSono pocaoEscolhida = new PocaoSono();
                    pocaoEscolhida.usarPocao(jogadorPocao);
                    jogadorPocao.pocoes.set(2, null);
                    playMusic.somSono();
                return 3;
                } else {
                    printsJogoView.efeitoPorcao(TipoPrint.POCAOUTILIZADA);
                    break;
                }
        }
        return 0;
    }

    public int removerEfeitoPocao(int pocaoUsada) {
        if (pocaoUsada == 1) {
            int danoAtual = partida.getJogadorAtacante().getMonstroAtivo().getDanoBase();
            partida.getJogadorAtacante().getMonstroAtivo().setDanoBase(danoAtual - 10);
            printsJogoView.efeitoPorcao(TipoPrint.FIMPOCAODANO);
        }
        return 0;
    }
}
