package br.com.dbc.vemser.jedimasters.service;

import br.com.dbc.vemser.jedimasters.controller.dto.CartaDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.repository.CartaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaService {

    private final ObjectMapper objectMapper;
    private final CartaRepository cartaRepository;

    public List<CartaDTO> listAll() {
        List<Carta> cartas = cartaRepository.listarCartas();
        List<CartaDTO> cartasDTO = cartas.stream()
                .map(carta -> objectMapper.convertValue(carta, CartaDTO.class))
                .toList();
        return cartasDTO;
    }

    public CartaDTO create(CartaDTO carta) {

        Carta cartaEntity = objectMapper.convertValue(carta, Carta.class);
        cartaRepository.criarCarta(cartaEntity);

        return objectMapper.convertValue(cartaEntity, CartaDTO.class);
    }

    public CartaDTO update(Integer id, CartaDTO cartaAtualizar) {
        Carta cartaEntity = objectMapper.convertValue(cartaAtualizar, Carta.class);
        cartaEntity = cartaRepository.atualizarCarta(id, cartaEntity);

        return objectMapper.convertValue(cartaEntity, CartaDTO.class);
    }

    public void delete(Integer id) {
        cartaRepository.deletarCarta(id);
    }
}
