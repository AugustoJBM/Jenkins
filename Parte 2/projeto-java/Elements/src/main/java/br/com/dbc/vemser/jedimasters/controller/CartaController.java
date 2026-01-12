package br.com.dbc.vemser.jedimasters.controller;

import br.com.dbc.vemser.jedimasters.controller.doc.CartaControllerDoc;
import br.com.dbc.vemser.jedimasters.controller.dto.CartaDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.service.CartaService;
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
@RequestMapping("/carta")
@RequiredArgsConstructor
public class CartaController implements CartaControllerDoc {

    private final CartaService cartaService;

    @GetMapping // GET localhost:8080/carta
    public ResponseEntity<List<CartaDTO>> listAll() {
        return new ResponseEntity<>(cartaService.listAll(), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/carta
    public ResponseEntity<CartaDTO> create(@Valid @RequestBody CartaDTO carta) {
        return new ResponseEntity<>(cartaService.create(carta), HttpStatus.CREATED);
    }

    @PutMapping("/{idCarta}") // PUT localhost:8080/carta/1
    public ResponseEntity<CartaDTO> update(@PathVariable("idCarta") @NotNull Integer id,
            @Valid @RequestBody CartaDTO cartaAtualizar) {
        return new ResponseEntity<>(cartaService.update(id, cartaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idCarta}") // DELETE localhost:8080/carta/1
    public ResponseEntity<Void> delete(@PathVariable("idCarta") @NotNull Integer id) {
        cartaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
