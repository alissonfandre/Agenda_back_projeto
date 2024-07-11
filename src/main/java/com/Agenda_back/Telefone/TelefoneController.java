package com.Agenda_back.Telefone;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefone")
@CrossOrigin(origins = "http://localhost:5173")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> getAllTelefones(){
        List<TelefoneDTO> telefoneDTO = telefoneService.findAll();
        return ResponseEntity.ok(telefoneDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> getTelefoneById(@PathVariable Long id){
        TelefoneDTO telefoneDTO = telefoneService.findById(id);
        return ResponseEntity.ok(telefoneDTO);
    }

    @PostMapping
    public ResponseEntity<TelefoneDTO> createTelefone(@Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO createTelefoneDTO = telefoneService.create(telefoneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTelefoneDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> updateTelefone(@PathVariable Long id,
                                                      @Valid @RequestBody TelefoneDTO telefoneDto) {
        TelefoneDTO updateTelefoneDTO = telefoneService.update(id, telefoneDto);
        return ResponseEntity.ok(updateTelefoneDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefone(@PathVariable Long id){
        telefoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}