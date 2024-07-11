package com.Agenda_back.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    ServicoMapper servicoMapper;

    public List<ServicoDTO> findAll(){
        List<Servico> servico = servicoRepository.findAll();
        System.out.println("lista de serviços:"+servico);
        List<ServicoDTO> servicospronto = servico.stream().map(servicoMapper::toDTO).collect(Collectors.toList());
        System.out.println("lista de serviços:"+servicospronto);
        return servicospronto;
    }

    public ServicoDTO findById(Long id){
        Servico

 servico = servicoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Servico não encontrada"));
        return servicoMapper.toDTO(servico);
    }

    public ServicoDTO create(ServicoDTO servicoDTO){
        Servico

 servico  = servicoMapper.toEntity(servicoDTO);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }

    public ServicoDTO update(Long id, ServicoDTO servicoDTO){
        Servico

 servico = servicoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Servico não encontrada"));
        Servico

 servicoUpdate = servicoMapper.updateEntity(servicoDTO, servico);
        servicoUpdate = servicoRepository.save(servicoUpdate);
        return servicoMapper.toDTO(servicoUpdate);
    }

    public void deleteById(Long id){
        servicoRepository.deleteById(id);
    }
}