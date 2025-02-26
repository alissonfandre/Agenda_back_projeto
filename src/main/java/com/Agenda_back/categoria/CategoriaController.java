package com.Agenda_back.categoria;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita o REST
@RequestMapping("/categoria") //localhost:8080/categoria
@CrossOrigin(origins = "http://localhost:5173")

public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias(){
        List<CategoriaDTO> categoriaDTO = categoriaService.findAll();
        return ResponseEntity.ok(categoriaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id){
        CategoriaDTO categoriaDTO = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaDTO);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO createCategoriaDTO = categoriaService.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategoriaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id,
                                                        @Valid @RequestBody CategoriaDTO categoriaDto) {
        CategoriaDTO updateCategoriaDTO = categoriaService.update(id, categoriaDto);
        return ResponseEntity.ok(updateCategoriaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
