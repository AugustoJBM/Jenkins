package br.com.dbc.vemser.jedimasters.model.entity.monstro;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MonstroTerra extends Monstro {

    private TipoMonstro elemento = TipoMonstro.TERRA;

    public MonstroTerra(int vida, String nome, int danoBase) {
        super(vida, nome, danoBase);
    }

    @Override
    public Monstro clonar() {
        return new MonstroTerra(this.getVida(), this.getNome(), this.getDanoBase());
    }

    @Override
    public void Passiva(){}

    @Override
    public TipoMonstro getElemento() {
        return elemento;
    }
}