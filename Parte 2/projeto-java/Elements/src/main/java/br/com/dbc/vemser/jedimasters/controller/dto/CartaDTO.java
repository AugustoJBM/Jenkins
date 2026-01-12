package br.com.dbc.vemser.jedimasters.controller.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartaDTO {

    @NotBlank(message="Tipo da carta não pode ser vazio ou nulo.")
    private String tipo;

    @NotBlank(message="Quantidade não pode ser vazia ou nula.")
    private int quant;

    @NotBlank(message="Atributo não pode ser vazio ou nulo.")
    private String atributoAtivo;
}
