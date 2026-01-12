package br.com.dbc.vemser.jedimasters.model.entity.pocao;

import br.com.dbc.vemser.jedimasters.utils.aparencia.Cores;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;

public class PocaoCura implements Pocao {
    @Override
    public void usarPocao(Jogador jogador) {
        int length_maior_string = Integer.max(jogador.getNome().length() + 17, 31);
        for (int i = 0; i < length_maior_string; i++)
            System.out.print(Cores.LIGHT_PURPLE + "*" + Cores.RESET);

        System.out.println("\n" + jogador.getNome() + " tomou uma poção!");
        System.out.println(Cores.GREEN + "❤️ VIDA TOTALMENTE REGENERADA! ♥" + Cores.RESET);
        jogador.getMonstroAtivo().setVida(100);

        for (int i = 0; i < length_maior_string ; i++)
            System.out.print(Cores.LIGHT_PURPLE + "*" + Cores.RESET);

        System.out.print("\nEscolha uma ação: ");
    }
}