package br.com.dbc.vemser.jedimasters.model.entity.pocao;

import br.com.dbc.vemser.jedimasters.utils.aparencia.Cores;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;

public class PocaoDano implements Pocao {
    @Override
    public void usarPocao(Jogador jogador) {
        int dano = jogador.getMonstroAtivo().getDanoBase();
        jogador.getMonstroAtivo().setDanoBase(dano + 10);

        int lengthMaiorString = Integer.max(jogador.getNome().length() + 17, 43);
        for (int i = 0; i < lengthMaiorString; i++)
            System.out.print(Cores.LIGHT_PURPLE + "*" + Cores.RESET);

        System.out.println("\n" + jogador.getNome() + " tomou uma poção!");
        System.out.println(Cores.RED + "⚔️ + 10 PONTOS DE DANO NO PRÓXIMO ATAQUE! ⚔️" + Cores.RESET);
        jogador.getMonstroAtivo().setDanoBase(dano + 10);

        for (int i = 0; i < lengthMaiorString; i++)
            System.out.print(Cores.LIGHT_PURPLE + "*" + Cores.RESET);

        System.out.print("\nEscolha uma ação: ");
    }
}
