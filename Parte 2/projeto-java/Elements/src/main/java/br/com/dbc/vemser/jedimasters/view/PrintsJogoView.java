package br.com.dbc.vemser.jedimasters.view;

import br.com.dbc.vemser.jedimasters.utils.aparencia.Cores;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.model.entity.TipoPrint;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import br.com.dbc.vemser.jedimasters.repository.dao.MonstroDAO;


public class PrintsJogoView {
    static final String linhasDuplas = "===================================";
    MonstroDAO bancoMonstro = new MonstroDAO();
    public void printMenuPartida(TipoPrint tipoPrint){
        if(tipoPrint == TipoPrint.VOLTARMENU){
            System.out.println("\nVoltando Menu Principal...");
        }
        if(tipoPrint == TipoPrint.OPCAOINEXISTENTE){
            System.out.print("Escolha uma ação válida: ");
        }
    }

    public void printPartida(int numMonstro, TipoPrint tipoPrint){
       if(tipoPrint == TipoPrint.NOMEJOGADOR){
           System.out.println(linhasDuplas);
           System.out.print("Digite seu nome: ");
       }

       if(tipoPrint == TipoPrint.TIPOCARTA){
            System.out.println(linhasDuplas);
            System.out.print("Digite o tipo da carta: ");
        }
        if(tipoPrint == TipoPrint.QUANTCARTA){
            System.out.println(linhasDuplas);
            System.out.print("Digite a quantidade da carta: ");
        }

        if(tipoPrint == TipoPrint.ATRIBUTOATIVOCARTA){
            System.out.println(linhasDuplas);
            System.out.print("Digite o atributo ativo da carta: ");
        }

        if(tipoPrint == TipoPrint.ESCOLHAMONSTRO){
            System.out.println(linhasDuplas);
            System.out.println("Escolha três dos monstros ao digitar o número correspondente: ");
        }

        if(tipoPrint == TipoPrint.MONSTRONUM){
            System.out.printf("Escolha %d: ", numMonstro);
        }

        if(tipoPrint == TipoPrint.ESCOLHA1OU2){
            System.out.println( Cores.YELLOW + "Opção inválida. Por favor, digite 1 ou 2."  + Cores.RESET);
        }
    }

    public void sortCarta(Carta cartaSorteada){
        if(cartaSorteada.getAtributoAtivo().equalsIgnoreCase("dano")){
            System.out.println("A sua carta sorteada " + cartaSorteada.getTipo() + " em " + cartaSorteada.getQuant() + " seu " + cartaSorteada.getAtributoAtivo());
        }else{
            System.out.println("A sua carta sorteada " + cartaSorteada.getTipo() + " em " + cartaSorteada.getQuant() + " sua " + cartaSorteada.getAtributoAtivo());
        }
    }

    public void printInicioTurno(String nome){

        if(nome.equalsIgnoreCase("Systerma")){
            System.out.println(Cores.LIGHT_BLUE + "\n++++++++++++++++++++ Inicio do turno de " + nome + "! ++++++++++++++++++++" + Cores.RESET);
        }else{
            System.out.println(Cores.GREEN + "\n++++++++++++++++++++ Inicio do turno de " + nome + "! ++++++++++++++++++++" + Cores.RESET);
        }
    }

    public void printTurno(String nome, TipoPrint  tipoPrint){
        if(tipoPrint == TipoPrint.DERROTAMONSTRO){
            System.out.println(Cores.RED + "\n" + nome + " foi derrotado!" + Cores.RESET);
        }

        if(tipoPrint == TipoPrint.DERROTA){
            System.out.println("\nTodos os monstros de " + nome + " foram derrotados! FIM DA PARTIDA");
        }

        if(tipoPrint == TipoPrint.PROXDEFENSOR){
            System.out.println(Cores.YELLOW + "Alterando para o próximo selecionado!" + Cores.RESET);
        }
    }

    public void printAtaque(Monstro atacante, Monstro defensor, TipoPrint tipoPrint){
        if(tipoPrint == TipoPrint.ATAQUE){
            System.out.println(atacante.getNome() + " ataca ferozmente " + defensor.getNome() + " e causa " + atacante.getDanoBase() + " de dano!!");
            System.out.printf("Defensor: %s - Vida Atual: %d\n", defensor.getNome(), defensor.getVida());
        }else{
            System.out.println(atacante.getNome() + " ataca " + defensor.getNome() + " de olhos fechados e causa " + atacante.getDanoBase() + " de dano!\n");
            System.out.printf("Defensor: %s - Vida Atual: %d", defensor.getNome(), defensor.getVida());
        }
    }


    public void printStatusMAJ(Monstro mAJ1, Monstro mAJ2){
        System.out.println(mAJ1.getNome() + ": " + mAJ1.getVida() + " de vida.           " + mAJ2.getNome() + " inimigo: " + mAJ2.getVida() + " de vida.");
        System.out.println(mAJ1.getDanoBase() + " de dano base.                  " +mAJ2.getDanoBase() + " de dano base.");
    }


    public void efeitoPorcao(TipoPrint tipoPrint){
        if(tipoPrint == TipoPrint.POCAOUTILIZADA){
            System.out.println(Cores.YELLOW + "Poção já utilizada!" + Cores.RESET);
        }

        if(tipoPrint == TipoPrint.POCAOINEXISTENTE){
            System.out.print(Cores.RED + "Poção Inexistente! Tente novamente!: " + Cores.RESET);
        }

        if(tipoPrint == TipoPrint.FIMPOCAODANO){
            System.out.println(Cores.RED + "*******************************" + Cores.RESET);
            System.out.println(Cores.RED + "FIM DO EFEITO DA POÇÃO DE DANO!" + Cores.RESET);
            System.out.println(Cores.RESET + "*******************************" + Cores.RESET);
        }
    }

    public void arquivoNaoEncontrado(){
        System.out.println("Arquivo não encontrado");
    }

    public void printMonstroController(int i, Monstro monstro ,TipoPrint tipoPrint){
        if(tipoPrint == TipoPrint.CRIARMONSTRO){
            System.out.println(Cores.LIGHT_BLUE + "===== Criação de Monstro =====" + Cores.RESET);
            System.out.print("Nome do Monstro: ");
        }

        if(tipoPrint == TipoPrint.LISTARMONSTROS){
            if(!monstro.getNome().equalsIgnoreCase("null")){
                System.out.println("===== Monstro " + (i) + " =====");
                System.out.println("Nome: " + monstro.getNome());
                System.out.println("Vida: " + monstro.getVida());
                System.out.println("Dano base: " + monstro.getDanoBase());
            }
        }

        if(tipoPrint == TipoPrint.NENHUMMONSTRO){
            System.out.printf(Cores.YELLOW + "\nNão há nenhum monstro cadastrado!\n" + Cores.RESET);
        }
    }

    public void printCartaController(int i, Carta carta ,TipoPrint tipoPrint){
        if(tipoPrint == TipoPrint.CRIARCARTA){
            System.out.println(Cores.LIGHT_BLUE + "===== Criação de Carta =====" + Cores.RESET);
        }

        if(tipoPrint == TipoPrint.LISTARCARTAS){
            if(!carta.getTipo().equalsIgnoreCase("null")){
                System.out.println("===== Carta " + (i) + " =====");
                System.out.println("Tipo: " + carta.getTipo());
                System.out.println("Quantidade: " + carta.getQuant());
                System.out.println("Atributo Ativo: " + carta.getAtributoAtivo());
            }
        }

        if(tipoPrint == TipoPrint.NENHUMACARTA){
            System.out.printf(Cores.YELLOW + "\nNão há nenhuma carta cadastrada!\n" + Cores.RESET);
        }
    }

    public void printPlayMusic(Exception e){
        System.out.println("Erro ao carregar música: " + e);
    }

}
