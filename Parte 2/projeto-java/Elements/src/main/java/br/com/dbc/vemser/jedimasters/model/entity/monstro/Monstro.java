package br.com.dbc.vemser.jedimasters.model.entity.monstro;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Monstro {

    private int vida;
    private String nome;
    private int danoBase;
    private TipoMonstro elemento;

    public Monstro(int vida, String nome, int danoBase) {
        this.vida = vida;
        this.nome = nome;
        this.danoBase = danoBase;
    }

    public abstract Monstro clonar();

    public void Passiva(){}

    public abstract TipoMonstro getElemento();
}
