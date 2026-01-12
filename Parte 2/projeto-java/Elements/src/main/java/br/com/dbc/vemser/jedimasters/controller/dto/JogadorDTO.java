package br.com.dbc.vemser.jedimasters.controller.dto;

import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.Pocao;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.PocaoCura;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.PocaoDano;
import br.com.dbc.vemser.jedimasters.model.entity.pocao.PocaoSono;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class JogadorDTO {

    @NotBlank(message="Nome não pode ser vazio ou nulo.")
    private String nome;

    private Monstro monstro1;
    private Monstro monstro2;
    private Monstro monstro3;
    private ArrayList<Monstro> monstrosJogador = new ArrayList<>();
    private Monstro monstroAtivo;
    public ArrayList<Pocao> pocoes = new ArrayList<>();

    public JogadorDTO(String nome) {
        this.nome = nome;
    }

    public JogadorDTO(String nome, Monstro monstro1, Monstro monstro2, Monstro monstro3) {
        this.nome = nome;
        this.monstro1 = monstro1;
        this.monstro2 = monstro2;
        this.monstro3 = monstro3;
        this.monstroAtivo = monstro1;
        monstrosJogador.add(monstro1);
        monstrosJogador.add(monstro2);
        monstrosJogador.add(monstro3);
        this.pocoes.add(new PocaoDano());
        this.pocoes.add(new PocaoCura());
        this.pocoes.add(new PocaoSono());
    }

    public void setMonstroAtivo() {
        monstroAtivo = monstrosJogador.get(0);
    }

}
