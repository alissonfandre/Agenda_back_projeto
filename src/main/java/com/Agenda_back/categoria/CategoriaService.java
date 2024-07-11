package com.Agenda_back.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> findAll(){
        List<Categoria

> categoria = categoriaRepository.findAll();
        return categoria.stream().map(categoriaMapper::toDTO).collect(Collectors.toList());
    }

    public CategoriaDTO findById(Long id){
        Categoria

 categoria = categoriaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Categoria não encontrada"));
        return categoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO create(CategoriaDTO categoriaDTO){
        Categoria

 categoria  = categoriaMapper.toEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO){
        Categoria

 categoria = categoriaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Categoria não encontrada"));
        Categoria

 categoriaUpdate = categoriaMapper.updateEntity(categoriaDTO, categoria);
        categoriaUpdate = categoriaRepository.save(categoriaUpdate);
        return categoriaMapper.toDTO(categoriaUpdate);
    }

    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }
}
