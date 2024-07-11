package com.Agenda_back.Prestador;
import com.Agenda_back.Servico.Servico;
import com.Agenda_back.Servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestadorService {
    @Autowired
    PrestadorRepository prestadorRepository;
    @Autowired
    PrestadorMapper prestadorMapper;
    @Autowired
    ServicoRepository servicoRepository;


    public List<PrestadorDTO> findAll(){
        List<Prestador

> prestador = prestadorRepository.findAll();
        return prestador.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }

    public PrestadorDTO findById(Long id){
        Prestador

 prestador = prestadorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Prestador não encontrada"));
        return prestadorMapper.toDTO(prestador);
    }

    public PrestadorDTO create(PrestadorDTO prestadorDTO){
        Prestador

 prestador  = prestadorMapper.toEntity(prestadorDTO);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    public PrestadorDTO update(Long id, PrestadorDTO prestadorDTO){
        Prestador

 prestador = prestadorRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Prestador não encontrada"));
        Prestador

 prestadorUpdate = prestadorMapper.updateEntity(prestadorDTO, prestador);
        prestadorUpdate = prestadorRepository.save(prestadorUpdate);
        return prestadorMapper.toDTO(prestadorUpdate);
    }

    public void deleteById(Long id){
        prestadorRepository.deleteById(id);
    }

    public List<PrestadorDTO> findByServicoNome(String servicoNome) {
        List<Servico> servicos = servicoRepository.findByServicoNome(servicoNome);
        List<Prestador> prestadores = servicos.stream()
                .map(Servico::getPrestador)
                .collect(Collectors.toList());
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }
}

