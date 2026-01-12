package br.com.dbc.vemser.jedimasters.controller;

import br.com.dbc.vemser.jedimasters.controller.doc.JogadorControllerDoc;
import br.com.dbc.vemser.jedimasters.controller.dto.JogadorDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;
import br.com.dbc.vemser.jedimasters.service.JogadorService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/jogador")
@RequiredArgsConstructor
public class JogadorController implements JogadorControllerDoc {

    private final JogadorService jogadorService;

    @GetMapping // GET localhost:8080/jogador
    public ResponseEntity<List<JogadorDTO>> listAll() {
        return new ResponseEntity<>(jogadorService.listAll(), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/jogador
    public ResponseEntity<JogadorDTO> create(@Valid @RequestBody JogadorDTO jogador) {
        return new ResponseEntity<>(jogadorService.create(jogador), HttpStatus.CREATED);
    }

    @PutMapping("/{idJogador}") // PUT localhost:8080/jogador/1
    public ResponseEntity<JogadorDTO> update(@PathVariable("idJogador") @NotNull Integer id,
                                          @Valid @RequestBody JogadorDTO jogadorAtualizar) {
        return new ResponseEntity<>(jogadorService.update(id, jogadorAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idJogador}") // DELETE localhost:8080/jogador/1
    public ResponseEntity<Void> delete(@PathVariable("idJogador") @NotNull Integer id) {
        jogadorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
