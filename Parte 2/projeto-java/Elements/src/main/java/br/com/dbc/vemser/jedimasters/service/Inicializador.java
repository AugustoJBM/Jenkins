package br.com.dbc.vemser.jedimasters.service;

import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Data
public class Inicializador {
    @Getter
    public static ArrayList<Monstro> monstros = new ArrayList<>();
    public static ArrayList<Jogador> jogadores = new ArrayList<>();
    public static ArrayList<Carta> cartas = new ArrayList<>();
    public  Inicializador(){
    }

    public static void criarMonstros(Monstro monstro){
        monstros.add(monstro);
    }

    public static void limparMonstros() {
        monstros.clear();
    }

    public static void criarJogadores(Jogador jogador){
        jogadores.add(jogador);
    }

    public static void criarCartas(Carta carta){
        cartas.add(carta);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}
