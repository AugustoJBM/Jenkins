package br.com.dbc.vemser.jedimasters.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carta {
    private String tipo;
    private int quant;
    private String atributoAtivo;
}
