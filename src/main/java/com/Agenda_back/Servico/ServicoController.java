package com.Agenda_back.Servico;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "http://localhost:5173")

public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> getAllServicos(){
        List<ServicoDTO> servicoDTO = servicoService.findAll();
        System.out.println("envio ok DTO:"+servicoDTO);
        return ResponseEntity.ok(servicoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getServicoById(@PathVariable Long id){
        ServicoDTO servicoDTO = servicoService.findById(id);
        return ResponseEntity.ok(servicoDTO);
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> createServico( @RequestBody ServicoDTO servicoDTO){
        ServicoDTO createServicoDTO = servicoService.create(servicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createServicoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> updateServico(@PathVariable Long id,
                                                     @RequestBody ServicoDTO servicoDto) {
        ServicoDTO updateServicoDTO = servicoService.update(id, servicoDto);
        return ResponseEntity.ok(updateServicoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id){
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

