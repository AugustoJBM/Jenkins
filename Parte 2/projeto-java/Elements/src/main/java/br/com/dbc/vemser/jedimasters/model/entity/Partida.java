package br.com.dbc.vemser.jedimasters.model.entity;

import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.Pocao;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Partida {

    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtacante;
    private Jogador jogadorDefensor;
    private Monstro monstroAtivoJ1;
    private Monstro monstroAtivoJ2;
    private ArrayList<Pocao> pocoesJ1 = new ArrayList<>();
    private ArrayList<Pocao> pocoesJ2 = new ArrayList<>();

    public Partida(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        monstroAtivoJ1 = jogador1.getMonstro1();
        monstroAtivoJ2 = jogador2.getMonstro1();
        jogadorAtacante = jogador1;
        jogadorDefensor = jogador2;
        pocoesJ1.addAll(jogador1.pocoes);
        pocoesJ2.addAll(jogador2.pocoes);
    }
}
