package com.Agenda_back.endereco;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    EnderecoMapper enderecoMapper;

    public List<EnderecoDTO> findAll(){
        List<Endereco

> endereco = enderecoRepository.findAll();
        return endereco.stream().map(enderecoMapper::toDTO).collect(Collectors.toList());
    }

    public EnderecoDTO findById(Long id){
        Endereco

 endereco = enderecoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Endereco não encontrada"));
        return enderecoMapper.toDTO(endereco);
    }

    public EnderecoDTO create(EnderecoDTO enderecoDTO){
        Endereco

 endereco  = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    public EnderecoDTO update(Long id, EnderecoDTO enderecoDTO){
        Endereco

 endereco = enderecoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Endereco não encontrada"));
        Endereco

 enderecoUpdate = enderecoMapper.updateEntity(enderecoDTO, endereco);
        enderecoUpdate = enderecoRepository.save(enderecoUpdate);
        return enderecoMapper.toDTO(enderecoUpdate);
    }

    public void deleteById(Long id){
        enderecoRepository.deleteById(id);
    }
}
