package com.Agenda_back.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> findAll(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return usuario.stream().map(usuarioMapper::toDTO).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Usuario não encontrada"));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO create(UsuarioDTO usuarioDTO){
        Usuario usuario  = usuarioMapper.toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Usuario não encontrada"));
        Usuario usuarioUpdate = usuarioMapper.updateEntity(usuarioDTO, usuario);
        usuarioUpdate = usuarioRepository.save(usuarioUpdate);
        return usuarioMapper.toDTO(usuarioUpdate);
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}


