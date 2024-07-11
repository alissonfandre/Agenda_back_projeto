package com.Agenda_back.endereco;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita o REST
@RequestMapping("/endereco") //localhost:8080/endereco
@CrossOrigin(origins = "http://localhost:5173")

public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAllEnderecos(){
        List<EnderecoDTO> enderecoDTO = enderecoService.findAll();
        return ResponseEntity.ok(enderecoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Long id){
        EnderecoDTO enderecoDTO = enderecoService.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> createEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO createEnderecoDTO = enderecoService.create(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEnderecoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Long id,
                                                      @RequestBody EnderecoDTO enderecoDto) {
        EnderecoDTO updateEnderecoDTO = enderecoService.update(id, enderecoDto);
        return ResponseEntity.ok(updateEnderecoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
