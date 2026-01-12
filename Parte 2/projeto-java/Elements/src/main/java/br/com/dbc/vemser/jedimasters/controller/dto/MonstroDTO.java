package br.com.dbc.vemser.jedimasters.controller.dto;

import br.com.dbc.vemser.jedimasters.model.entity.monstro.TipoMonstro;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonstroDTO {

    @NotBlank(message="Vida não pode ser vazia ou nula.")
    @Size(min=1, max=100, message="Vida precisa ser entre 1 e 100.")
    private int vida;

    @NotBlank(message="Nome não pode ser vazio ou nulo.")
    private String nome;

    @NotBlank(message="Dano base não pode ser vazio ou nulo.")
    @Size(min=1, max=25, message="Dano base precis ser entre 1 e 25.")
    private int danoBase;

    @NotBlank(message="Elemento não pode ser vazio ou nulo.")
    private TipoMonstro elemento;
}
