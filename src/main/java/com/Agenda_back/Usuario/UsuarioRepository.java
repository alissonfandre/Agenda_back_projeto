package com.Agenda_back.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
