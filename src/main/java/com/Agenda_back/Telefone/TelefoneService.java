package com.Agenda_back.Telefone;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository telefoneRepository;
    @Autowired
    TelefoneMapper telefoneMapper;

    public List<TelefoneDTO> findAll(){
        List<Telefone> telefone = telefoneRepository.findAll();
        return telefone.stream().map(telefoneMapper::toDTO).collect(Collectors.toList());
    }

    public TelefoneDTO findById(Long id){
        Telefone telefone = telefoneRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Telefone não encontrada"));
        return telefoneMapper.toDTO(telefone);
    }

    public TelefoneDTO create(TelefoneDTO telefoneDTO){
        Telefone telefone  = telefoneMapper.toEntity(telefoneDTO);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    public TelefoneDTO update(Long id, TelefoneDTO telefoneDTO){
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Telefone não encontrada"));
        Telefone telefoneUpdate = telefoneMapper.updateEntity(telefoneDTO, telefone);
        telefoneUpdate = telefoneRepository.save(telefoneUpdate);
        return telefoneMapper.toDTO(telefoneUpdate);
    }

    public void deleteById(Long id){
        telefoneRepository.deleteById(id);
    }
}
