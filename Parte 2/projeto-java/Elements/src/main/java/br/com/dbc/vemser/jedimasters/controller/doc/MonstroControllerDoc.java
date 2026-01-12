package br.com.dbc.vemser.jedimasters.controller.doc;

import br.com.dbc.vemser.jedimasters.controller.dto.MonstroDTO;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MonstroControllerDoc {
    @Operation(summary = "Lista de Monstros", description = "Lista todos os monstros do jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de monstros"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<List<MonstroDTO>> listAll();

    @Operation(summary = "Cria um Monstro", description = "Cria uma novo monstro no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cria um novo monstro"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<MonstroDTO> create(@Valid @RequestBody MonstroDTO monstro);

    @Operation(summary = "Atualiza um Monstro", description = "Atualiza dados de um monstro existente no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza um monstro existente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<MonstroDTO> update(@PathVariable("idMonstro") @NotNull Integer id,
            @Valid @RequestBody MonstroDTO monstroAtualizar);

    @Operation(summary = "Deleta um Monstro", description = "Deleta um monstro existente no jogo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um monstro existente"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<Void> delete(@PathVariable("idMonstro") @NotNull Integer id);
}
