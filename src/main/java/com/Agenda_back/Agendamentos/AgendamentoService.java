package com.Agenda_back.Agendamentos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    AgendamentoMapper agendamentoMapper;

    public List<AgendamentoDTO> findAll() {
        List<Agendamento

                > agendamento = agendamentoRepository.findAll();
        return agendamento.stream().map(agendamentoMapper::toDTO).collect(Collectors.toList());
    }

    public AgendamentoDTO findById(Long id) {
        Agendamento

                agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrada"));
        return agendamentoMapper.toDTO(agendamento);
    }

    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = agendamentoMapper.toEntity(agendamentoDTO);
        agendamento.setAgendamento_status(AgendamentoStatus.PENDENTE);
        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamento);
    }

    public AgendamentoDTO update(Long id, AgendamentoDTO agendamentoDTO) {
        Agendamento

                agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrada"));
        Agendamento

                agendamentoUpdate = agendamentoMapper.updateEntity(agendamentoDTO, agendamento);
        agendamentoUpdate = agendamentoRepository.save(agendamentoUpdate);
        return agendamentoMapper.toDTO(agendamentoUpdate);
    }

    public void deleteById(Long id) {
        agendamentoRepository.deleteById(id);
    }
}

