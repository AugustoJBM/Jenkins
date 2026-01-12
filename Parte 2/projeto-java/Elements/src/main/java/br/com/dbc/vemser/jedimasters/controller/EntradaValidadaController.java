package br.com.dbc.vemser.jedimasters.controller;

import br.com.dbc.vemser.jedimasters.controller.exception.ValidaException;
import br.com.dbc.vemser.jedimasters.model.entity.TipoPrint;
import br.com.dbc.vemser.jedimasters.repository.dao.MonstroDAO;
import br.com.dbc.vemser.jedimasters.utils.aparencia.Cores;
import br.com.dbc.vemser.jedimasters.controller.exception.MonstroJaEscolhidoException;
import br.com.dbc.vemser.jedimasters.controller.exception.ValorForaDoLimiteException;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.*;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.TipoMonstro;
import br.com.dbc.vemser.jedimasters.view.PrintsJogoView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class EntradaValidadaController {
    static final String linhasDuplas = "===================================";
    Scanner input = new Scanner(System.in);
    MonstroDAO bancoMonstro = new MonstroDAO();
    public EntradaValidadaController(Scanner inputUser){
        this.input = inputUser;
    }

    public int validarInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Valor inválido! Digite um número inteiro.");
                System.out.print("Tente novamente: ");
            }
        }
    }

    public int validarExistencia(int sizeArray){
        while (true){
            int opcao = validarInt();
            try {
                if(opcao >= 1 && opcao <= sizeArray){
                    return opcao;
                } else {
                    throw new ValorForaDoLimiteException("Opção inválida! Escolha um número entre 1 e " + sizeArray);
                }
            } catch (ValorForaDoLimiteException e) {
                System.out.println(Cores.YELLOW + "⚠️ " + e.getMessage() + Cores.RESET);
                System.out.print("Tente novamente: ");
            }
        }
    }

    public int[] validarRecorrenciaMonstro(int jogador, int maxSelecoes, ArrayList<Monstro> monstros) {
        int counter = 1;
        int[] selecoes = new int[maxSelecoes];
        int[] jaEscolhidos = new int[monstros.size()];
        PrintsJogoView printsJogoView = new PrintsJogoView();
        Random random = new Random();
        int monstro;

        do {
            try {
                if (jogador == 1) {
                    printsJogoView.printPartida(counter, TipoPrint.MONSTRONUM);
                    monstro = validarExistencia(monstros.size()) - 1;
                }
                else {
                    monstro = random.nextInt(monstros.size());
                }

                if (jaEscolhidos[monstro] != 0) {
                    if (jogador == 1) {
                        throw new MonstroJaEscolhidoException("Monstro já escolhido! Selecione outra opção.");
                    }
                }

                selecoes[counter - 1] = monstro;
                jaEscolhidos[monstro] = 1;
                counter++;

            } catch (MonstroJaEscolhidoException e) {
                System.out.println(Cores.YELLOW + e.getMessage() + Cores.RESET);
            }

        } while (counter <= maxSelecoes);

        return selecoes;
    }

    public int validaVida() {
        int vida = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Vida do Monstro: ");

                vida = validarInt();
                input.nextLine();

                if (vida > 100) {
                    throw new ValidaException("A vida não pode ser acima de 100!");
                }
                if (vida < 1) {
                    throw new ValidaException("A vida não pode ser abaixo de 1!");
                }
                entradaValida = true;

            } catch (ValidaException e) {
                System.out.println(Cores.RED + "❌ " + e.getMessage() + Cores.RESET);
            }
        }
        return vida;
    }

    public int validaDano(){
        int dano = 0;
        boolean entradaValida = false;
        while (!entradaValida){
            try {
                System.out.print("Dano do Monstro: ");
                dano = validarInt();
                input.nextLine();

                if(dano > 25) {
                    throw new ValorForaDoLimiteException("O dano não pode ser acima de 25!");
                } else if(dano < 1){
                    throw new ValorForaDoLimiteException("O dano não pode ser abaixo de 1!");
                }else {
                    entradaValida = true;
                }
            } catch (ValorForaDoLimiteException e){
                System.out.println(Cores.RED + e.getMessage() + Cores.RESET);
            }
        }
        return dano;
    }

    public Monstro validaElemento(ArrayList<Monstro> monstros, String nomeMonstro, int vida, int danoBase){
        boolean entradaValida = false;

        System.out.println("Escolha um Elemento");
        for(TipoMonstro tipo : TipoMonstro.values()){
            System.out.print(" | " + tipo);
        }
        System.out.println(" | ");

        TipoMonstro elementoEscolhido = null;
        Monstro novoMonstro = null;
        while (!entradaValida) {
            System.out.print("Elemento: ");
            String escolhaUsuario = input.nextLine().toUpperCase();
            try {
                elementoEscolhido = TipoMonstro.valueOf(escolhaUsuario);
                switch (elementoEscolhido){
                    case AGUA:
                        novoMonstro = new MonstroAgua(vida, nomeMonstro, danoBase);
                        entradaValida = true;
                        break;
                    case AR:
                        novoMonstro = new MonstroAr(vida, nomeMonstro, danoBase);
                        entradaValida = true;
                        break;
                    case FOGO:
                        novoMonstro = new MonstroFogo(vida, nomeMonstro, danoBase);
                        entradaValida = true;
                        break;
                    case TERRA:
                        novoMonstro = new MonstroTerra(vida, nomeMonstro, danoBase);
                        entradaValida = true;
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.printf(Cores.RED + "Erro: elemento '%s' inválido. Digite um dos elementos listados acima\n" + Cores.RESET, escolhaUsuario );
            }
        }

        System.out.println("\n");
        System.out.println(Cores.GREEN + "\n✅ Monstro " + novoMonstro.getNome() + " (" + novoMonstro.getElemento() + ") criado e adicionado ao seu time!" + Cores.RESET);

        return novoMonstro;
    }

    public ArrayList<Monstro> naoVazio(ArrayList<Monstro> monstros, String tipoMetodo){
        Monstro novoMonstro = null;
        if(!monstros.isEmpty()){
            if(tipoMetodo.equalsIgnoreCase("atualizar")){
                System.out.print("Digite o número do monstro a ser atualizado: ");
                int indexMonstro = validarExistencia(monstros.size()) - 1;

                input.nextLine();
                System.out.print("Digite o nome: ");
                String nomeMonstro = input.nextLine();

                int vida = validaVida();
                int danoBase = validaDano();

                monstros.get(indexMonstro).setNome(nomeMonstro);
                monstros.get(indexMonstro).setVida(vida);
                monstros.get(indexMonstro).setDanoBase(danoBase);

                bancoMonstro.atualizarMonstro(indexMonstro + 1, nomeMonstro, vida, danoBase);

                System.out.println(Cores.GREEN + "Monstro editado com sucesso!" + Cores.RESET);
            }

            if(tipoMetodo.equalsIgnoreCase("deletar")){
                System.out.print("Digite o número do monstro que deseja deletar: ");

                int indexMonstro = validarExistencia(monstros.size()) - 1;

                System.out.println(indexMonstro);

                Monstro monstro = new MonstroTerra(0, "null", 0);
                monstros.set(indexMonstro, monstro);

                bancoMonstro.atualizarMonstro(indexMonstro + 1,  monstro.getNome(), monstro.getVida(), monstro.getDanoBase());

                System.out.println(Cores.GREEN + "Monstro deletado com sucesso!" + Cores.RESET);
            }
        }else{
            System.out.printf(Cores.YELLOW + "\nNão há nenhum monstro cadastrado!\n" + Cores.RESET);
        }
        return monstros;
    }
}