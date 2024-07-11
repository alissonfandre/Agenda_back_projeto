package com.Agenda_back.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/" )
@RestController //habilita o REST
@RequestMapping("/usuario") //localhost:8080/usuario
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping //retorna uma lista de usuario
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){
        List<UsuarioDTO> usuarioDTO = usuarioService.findAll();
        return ResponseEntity.ok(usuarioDTO);
    }
    @GetMapping("/{id}") //localhost:8080/usuario/1    pegar por id
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id){
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }
    @PostMapping //salvar uma categoria no banco de dados
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        System.out.println(usuarioDTO);
        UsuarioDTO createUsuarioDTO = usuarioService.create(usuarioDTO);
        return
                ResponseEntity.status(HttpStatus.CREATED).body(createUsuarioDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id,
                                                    @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO updateUsuarioDTO = usuarioService.update(id,usuarioDTO);
        return ResponseEntity.ok(updateUsuarioDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}