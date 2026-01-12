package br.com.dbc.vemser.jedimasters.view;

import br.com.dbc.vemser.jedimasters.utils.aparencia.Cores;

public class MenuView {
    static final String linhasDuplas = "===================================";
    public void exibirRegras(){

        System.out.println();

        System.out.println("No incrível mundo de " + Cores.LIGHT_PURPLE +   "Elements" + Cores.RESET + ", você batalha arduamente contra inimigos ferozes para poder saborear a vitória!");
        System.out.println("Mas fique atento: a sorte pode estar ou não ao seu favor ao início de cada turno! Que os deuses estejam ao seu lado e te dê boas cartas!!!!");

        System.out.println(Cores.YELLOW + "\nO QUE CADA OPÇÃO NA TELA INICIAL QUER DIZER?" + Cores.RESET);
        System.out.println("\t1. Iniciar uma nova partida te leva direto para o " + Cores.RED + "campo de batalha." + Cores.RESET);
        System.out.println("\t2. Listar os " + Cores.PURPLE + "monstros" + Cores.RESET +" mostra a você todos os diferentes " + Cores.PURPLE + "monstros " + Cores.RESET +"que podem ser escolhidos para suas batalhas.");
        System.out.println("\t3. Criar "+ Cores.PURPLE + "monstros " + Cores.RESET + "torna reais os " + Cores.PURPLE + "monstros " + Cores.RESET + "mais incríveis que surgirem na sua imaginação.");
        System.out.println("\t4. Editar um " + Cores.PURPLE + "monstro " + Cores.RESET + "te permite ajustar seus " + Cores.PURPLE + "monstros " + Cores.RESET + "às suas expectativas.");

        System.out.println(Cores.GREEN + "\nO QUE FAZER NO CAMPO DE BATALHA?" + Cores.RESET);
        System.out.println("Iniciando uma nova partida, suas opções variam:");
        System.out.println("\t1. " + Cores.RED + "Atacar " + Cores.RESET + "causa dano no " + Cores.PURPLE + "monstros " + Cores.RESET + "atual do inimigo.");
        System.out.println("\t2. " + Cores.RED + "Atacar " + Cores.RESET + "de olhos fechados faz o seu " + Cores.PURPLE + "monstro " + Cores.RESET + "atacar aleatoriamente um dos" + Cores.PURPLE + "monstros " + Cores.RESET + "inimigos.");
        System.out.println("\t3. Precisa de vida? "+ Cores.GREEN + "Regenere-se " + Cores.RESET + "para ter aumentar suas chances de vitória!");
        System.out.println("\t4. Abra sua bolsa de poções sempre que precisar de uma ajudinha a mais no combate!");
        System.out.println("\t5. Correr da luta dá vitória imediata ao inimigo.");
    }

    public void menu(){
        System.out.println(linhasDuplas + "\n   \uD83D\uDC7EBoas-vindas ao " + Cores.LIGHT_PURPLE + "Elements\uD83D\uDC7E\n" + Cores.RESET + linhasDuplas);
        System.out.println(Cores.GREEN + "🔰 1. Iniciar nova partida" + Cores.RESET);
        System.out.println(Cores.PURPLE + "🗒️ 2. Tutorial" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "📝 3. Personalizar Monstro" + Cores.RESET);
        System.out.println(Cores.YELLOW + "🛠️ 4. Personalizar Jogador" + Cores.RESET);
        System.out.println(Cores.WHITE + "🃏 5. Personalizar Carta" + Cores.RESET);
        System.out.println(Cores.RED + "📤 6. Fechar Jogo" + Cores.RESET);
        System.out.println(linhasDuplas);
        System.out.print("Escolha uma opção: ");
    }

    public void menuMonstro(){
        System.out.println(Cores.PURPLE + "📝 1. Listar Monstros" + Cores.RESET);
        System.out.println(Cores.GREEN + "🛠️ 2. Criar Monstro" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "✏️ 3. Editar Monstro" + Cores.RESET);
        System.out.println(Cores.RED + "❌ 4. Remover Monstro" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "📤 5. Voltar ao Menu Principal" + Cores.RESET);
        System.out.print("Escolha uma opção: ");
    }

    public void menuCarta(){
        System.out.println(Cores.PURPLE + "📝 1. Listar Cartas" + Cores.RESET);
        System.out.println(Cores.GREEN + "🛠️ 2. Criar Carta" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "✏️ 3. Editar Carta" + Cores.RESET);
        System.out.println(Cores.RED + "❌ 4. Remover Carta" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "📤 5. Voltar ao Menu Principal" + Cores.RESET);
        System.out.print("Escolha uma opção: ");
    }

    public void menuJogador(){
        System.out.println(Cores.PURPLE + "📝 1. Listar Jogadores" + Cores.RESET);
        System.out.println(Cores.GREEN + "🛠️ 2. Criar Jogador" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "✏️ 3. Editar Jogador" + Cores.RESET);
        System.out.println(Cores.RED + "❌ 4. Remover Jogador" + Cores.RESET);
        System.out.println(Cores.LIGHT_BLUE + "📤 5. Voltar ao Menu Principal" + Cores.RESET);
        System.out.print("Escolha uma opção: ");
    }

    public void menuPartida(){
        System.out.println(Cores.RED + "\n1. Atacar!" + Cores.RESET);
        System.out.println(Cores.RED + "2. Atacar de olhos fechados!" + Cores.RESET);
        System.out.println(Cores.GREEN + "3. Regenerar(+)" + Cores.RESET);
        System.out.println(Cores.PURPLE + "4. Bolsa de poções" + Cores.RESET);
        System.out.println(Cores.YELLOW + "5. Correr da luta" + Cores.RESET);
        System.out.printf("Escolha uma ação: " + Cores.RESET);
    }

    public void menuConfirmaEscolha(){
        System.out.println(Cores.YELLOW + "Confirmar escolhas?" + Cores.RESET);
        System.out.println(Cores.GREEN + "1. Sim" + Cores.RESET);
        System.out.println(Cores.RED + "2. Não" + Cores.RESET);
        System.out.print("R = ");
    }

    public void menuPocao(){
        System.out.println("💔 1. Dano");
        System.out.println("❤️ 2. Cura");
        System.out.println("😴 3. Sono");
        System.out.print("ESCOLHA UMA POÇÃO: ");
    }
}
