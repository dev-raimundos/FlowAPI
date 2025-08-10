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

    log.info("Gravando Transações");

    public void adicionarTransacoes(TransacaoRequestDTO dto) {
        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableEntity("Data de hora invalido");
        }
    }

}
