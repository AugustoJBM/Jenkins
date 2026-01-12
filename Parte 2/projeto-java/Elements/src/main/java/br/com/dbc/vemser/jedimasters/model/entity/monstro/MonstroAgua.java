package br.com.dbc.vemser.jedimasters.model.entity.monstro;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MonstroAgua extends Monstro {

    private TipoMonstro elemento = TipoMonstro.AGUA;

    public MonstroAgua(int vida, String nome, int danoBase) {
        super(vida, nome, danoBase);
    }

    @Override
    public Monstro clonar() {
        return new MonstroAgua(this.getVida(), this.getNome(), this.getDanoBase());
    }

    @Override
    public void Passiva(){}

    @Override
    public TipoMonstro getElemento() {
        return elemento;
    }
}