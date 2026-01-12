package br.com.dbc.vemser.jedimasters.utils;

import lombok.Data;

import java.util.Arrays;

public enum TipoEmail {
    NOVO_USUARIO(1),
    INFO(2);

    private Integer tipo;

    TipoEmail(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoEmail ofTipo(Integer tipo){
        return Arrays.stream(TipoEmail.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
