package com.Agenda_back.Prestador;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/prestador")
@CrossOrigin(origins = "http://localhost:5173")
public class PrestadorController {
    @Autowired
    private PrestadorService prestadorService;

    @GetMapping
    public ResponseEntity<List<PrestadorDTO>> getAllPrestador(){
        List<PrestadorDTO> prestadorsDTO = prestadorService.findAll();
        return ResponseEntity.ok(prestadorsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorDTO> getPrestadorById(@PathVariable Long id){
        PrestadorDTO prestadorDTO = prestadorService.findById(id);
        return ResponseEntity.ok(prestadorDTO);
    }


    @PostMapping
    public ResponseEntity<PrestadorDTO> createPrestador( @RequestBody PrestadorDTO prestadorDTO){
        System.out.println("prestadorDTO:"+ prestadorDTO);
        PrestadorDTO createPrestadorDTO = prestadorService.create(prestadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPrestadorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorDTO> updatePrestador(@PathVariable Long id,
                                                        @Valid @RequestBody PrestadorDTO prestadorDto) {
        PrestadorDTO updatePrestadorDTO = prestadorService.update(id, prestadorDto);
        return ResponseEntity.ok(updatePrestadorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable Long id){
        prestadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PrestadorDTO>> getPrestadoresByServicoNome(@RequestParam String servicoNome) {
        System.out.println("servico_nome:"+servicoNome);
        if (servicoNome == null || servicoNome.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        try {
            List<PrestadorDTO> prestadores = prestadorService.findByServicoNome(servicoNome);
            return ResponseEntity.ok(prestadores);
        } catch (Exception e) {
            // Log the exception (e.g., using SLF4J or another logging framework)
            // logger.error("Error while fetching prestadores by servicoNome: {}", servicoNome, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}
