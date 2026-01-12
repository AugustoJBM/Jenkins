package br.com.dbc.vemser.jedimasters.service;

import br.com.dbc.vemser.jedimasters.controller.dto.MonstroDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.model.entity.monstro.Monstro;
import br.com.dbc.vemser.jedimasters.repository.MonstroRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonstroService {

    private final ObjectMapper objectMapper;
    private final MonstroRepository monstroRepository;

    public List<MonstroDTO> listAll() {
        List<Monstro> monstros = monstroRepository.listarMonstros();
        List<MonstroDTO> monstrosDTO = monstros.stream()
                .map(monstro -> objectMapper.convertValue(monstro, MonstroDTO.class))
                .toList();
        return monstrosDTO;
    }

    public MonstroDTO create(MonstroDTO monstro) {
        monstro = monstroRepository.criarMonstro(monstro);

        return objectMapper.convertValue(monstro, MonstroDTO.class);
    }

    public MonstroDTO update(Integer id, MonstroDTO monstroAtualizar) {
        monstroAtualizar = monstroRepository.atualizarMonstro(id, monstroAtualizar);

        return monstroAtualizar;
    }

    public void delete(Integer id) {
        monstroRepository.deletarMonstro(id);
    }
}
