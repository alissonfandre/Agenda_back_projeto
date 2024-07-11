package com.Agenda_back.Agendamentos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> getAllAgendamentos() {
        List<AgendamentoDTO> agendamentoDTO = agendamentoService.findAll();
        return ResponseEntity.ok(agendamentoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> getAgendamentoById(@PathVariable Long id) {
        AgendamentoDTO agendamentoDTO = agendamentoService.findById(id);
        return ResponseEntity.ok(agendamentoDTO);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> createAgendamento(@RequestBody AgendamentoDTO agendamentoDTO)  {
        System.out.println("entrei no post");
        AgendamentoDTO createAgendamentoDTO = agendamentoService.create(agendamentoDTO);
        System.out.println("sai no post");
        return ResponseEntity.status(HttpStatus.CREATED).body(createAgendamentoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> updateAgendamento(@PathVariable Long id,
                                                            @RequestBody AgendamentoDTO agendamentoDto) {
        AgendamentoDTO updateAgendamentoDTO = agendamentoService.update(id, agendamentoDto);
        return ResponseEntity.ok(updateAgendamentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id) {
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
