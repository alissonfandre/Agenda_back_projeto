package com.Agenda_back.Servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico,Long> {
    @Query("SELECT s FROM Servico s WHERE s.servico_nome = :servicoNome")
    List<Servico> findByServicoNome(@Param("servicoNome") String servicoNome);
}
