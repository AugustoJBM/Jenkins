package br.com.dbc.vemser.jedimasters.model.entity.pocao;

import br.com.dbc.vemser.jedimasters.utils.aparencia.Cores;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;

public class PocaoSono implements Pocao {
    @Override
    public void usarPocao(Jogador jogador) {
        int lengthMaiorString = Integer.max(jogador.getNome().length() + 17, 37);
        for (int i = 0; i < lengthMaiorString; i++)
            System.out.print(Cores.LIGHT_PURPLE + "*" + Cores.RESET);

        System.out.println("\n" + jogador.getNome() + " tomou uma poção!");
        System.out.println(Cores.YELLOW + "😴 O INIMIGO DORMIU! JOGADA EXTRA! 😴" + Cores.RESET);

        for (int i = 0; i < lengthMaiorString; i++)
            System.out.print(Cores.LIGHT_PURPLE + "*" + Cores.RESET);

        System.out.print("\nEscolha uma ação: ");
    }
}
