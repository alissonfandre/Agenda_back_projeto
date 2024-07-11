package com.Agenda_back.Agendamentos;

import com.Agenda_back.Servico.Servico;
import com.Agenda_back.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long agendamento_id;

    @NotNull(message = "O campo DATA é requerido.")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate agendamento_data;

    @NotNull(message = "O campo HORA é requerido.")
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime agendamento_hora;

    private String agendamento_observacao;

    @Enumerated(EnumType.STRING)
    private AgendamentoStatus agendamento_status;

    private Usuario usuario;

    private Servico servico;

}