package com.devraimundos.FlowAPI.business.services;

import com.devraimundos.FlowAPI.controller.dtos.TransacaoRequestDTO;
import com.devraimundos.FlowAPI.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {

        log.info("Gravando Transações");

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessableEntity("Data de hora invalido");
        }

        if (dto.valor() < 0) {
            log.error("Valor não pode ser negativo");
            throw new UnprocessableEntity("Valor não pode ser negativo");
        }

        listaTransacoes.add(dto);
    }

    public void limparTransacoes() {
        listaTransacoes.clear();
    }

    public List<TransacaoRequestDTO> buscaTransacoes(Integer intevaloBusca) {

        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intevaloBusca);

        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();
    }
}
