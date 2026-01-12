package br.com.dbc.vemser.jedimasters.controller;

import br.com.dbc.vemser.jedimasters.controller.doc.MonstroControllerDoc;
import br.com.dbc.vemser.jedimasters.controller.dto.MonstroDTO;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import br.com.dbc.vemser.jedimasters.service.MonstroService;
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
@RequestMapping("/monstro")
@RequiredArgsConstructor
public class MonstroController implements MonstroControllerDoc {
    
    private final MonstroService monstroService;

    @GetMapping // GET localhost:8080/monstro
    public ResponseEntity<List<MonstroDTO>> listAll() {
        return new ResponseEntity<>(monstroService.listAll(), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/monstro
    public ResponseEntity<MonstroDTO> create(@Valid @RequestBody MonstroDTO monstro) {
        return new ResponseEntity<>(monstroService.create(monstro), HttpStatus.CREATED);
    }

    @PutMapping("/{idMonstro}") // PUT localhost:8080/monstro/1
    public ResponseEntity<MonstroDTO> update(@PathVariable("idMonstro") @NotNull Integer id,
            @Valid @RequestBody MonstroDTO monstroAtualizar) {
        return new ResponseEntity<>(monstroService.update(id, monstroAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idMonstro}") // DELETE localhost:8080/monstro/1
    public ResponseEntity<Void> delete(@PathVariable("idMonstro") @NotNull Integer id) {
        monstroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
