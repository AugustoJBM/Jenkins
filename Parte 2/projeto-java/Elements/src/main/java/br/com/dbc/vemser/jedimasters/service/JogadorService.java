package br.com.dbc.vemser.jedimasters.service;

import br.com.dbc.vemser.jedimasters.controller.dto.JogadorDTO;
import br.com.dbc.vemser.jedimasters.model.entity.Carta;
import br.com.dbc.vemser.jedimasters.model.entity.Jogador;
import br.com.dbc.vemser.jedimasters.repository.JogadorRepository;
import br.com.dbc.vemser.jedimasters.utils.TipoEmail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogadorService {

    private final ObjectMapper objectMapper;
    private final JogadorRepository jogadorRepository;
    private final EmailService emailService;

    public List<JogadorDTO> listAll() {
        List<Jogador> jogadores = jogadorRepository.listarJogadores();
        List<JogadorDTO> jogadorDTOS = jogadores.stream()
                .map(jogador -> objectMapper.convertValue(jogador, JogadorDTO.class))
                .toList();
        return jogadorDTOS;
    }

    public JogadorDTO create(JogadorDTO jogador) {

        Jogador jogadorEntity = objectMapper.convertValue(jogador, Jogador.class);
        jogadorRepository.criarJogador(jogadorEntity);

        emailService.sendEmail(TipoEmail.NOVO_USUARIO, jogador.getNome(), "email@email.com", "Criação de conta", null, null);

        return objectMapper.convertValue(jogadorEntity, JogadorDTO.class);
    }

    public JogadorDTO update(Integer id, JogadorDTO jogadorAtualizar) {

        Jogador jogadorEntity = objectMapper.convertValue(jogadorAtualizar, Jogador.class);
        jogadorEntity = jogadorRepository.atualizarJogador(id, jogadorEntity);

        emailService.sendEmail(TipoEmail.INFO, jogadorAtualizar.getNome(), "email@email.com", "Atualização de conta", "Sua conta foi atualizada", "Sua conta foi atualizada com sucesso em nosso sistema.");

        return objectMapper.convertValue(jogadorEntity, JogadorDTO.class);
    }

    public void delete(Integer id) {
        jogadorRepository.deletarJogador(id);
    }
}
