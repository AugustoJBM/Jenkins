package br.com.dbc.vemser.jedimasters.controller.doc;

import br.com.dbc.vemser.jedimasters.controller.dto.JogadorDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JogadorControllerDoc {
    @Operation(summary = "Lista de Jogadores", description = "Lista todos os jogadores registrados no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de jogadores"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<List<JogadorDTO>> listAll();

    @Operation(summary = "Cria um Jogador", description = "Cria um novo jogador no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cria um novo jogador"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<JogadorDTO> create(@Valid @RequestBody JogadorDTO jogador);

    @Operation(summary = "Atualiza um Jogador", description = "Atualiza dados de um jogador existente no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza um jogador existente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<JogadorDTO> update(@PathVariable("idJogador") @NotNull Integer id,
            @Valid @RequestBody JogadorDTO jogadorAtualizar);

    @Operation(summary = "Deleta um Jogador", description = "Deleta um jogador existente no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um jogador existente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<Void> delete(@PathVariable("idJogador") @NotNull Integer id);
}
