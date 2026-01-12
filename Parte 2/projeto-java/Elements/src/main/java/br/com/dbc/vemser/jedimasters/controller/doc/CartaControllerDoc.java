package br.com.dbc.vemser.jedimasters.controller.doc;

import br.com.dbc.vemser.jedimasters.controller.dto.CartaDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartaControllerDoc {
    @Operation(summary = "Lista de Cartas", description = "Lista todas as cartas do jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de cartas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<List<CartaDTO>> listAll();

    @Operation(summary = "Cria uma Carta", description = "Cria uma nova cartas no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cria uma nova carta"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<CartaDTO> create(@Valid @RequestBody CartaDTO carta);

    @Operation(summary = "Atualiza uma Carta", description = "Atualiza uma carta existente no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza uma carta existente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<CartaDTO> update(@PathVariable("idCarta") @NotNull Integer id,
            @Valid @RequestBody CartaDTO cartaAtualizar);

    @Operation(summary = "Deleta uma Carta", description = "Deleta uma carta existente do jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta uma carta existente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<Void> delete(@PathVariable("idCarta") @NotNull Integer id);
}
