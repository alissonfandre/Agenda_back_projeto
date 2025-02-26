package com.Agenda_back.Agendamentos;



import com.Agenda_back.Servico.Servico;
import com.Agenda_back.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Long agendamento_id;

    @Column(name = "agendamento_data")
    @Temporal(TemporalType.DATE)
    private LocalDate agendamento_data;

    @Column(name = "agendamento_hora")
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime agendamento_hora;

    @Column(name = "agendamento_observacao")
    private String agendamento_observacao;

    @Column(name = "agendamento_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private AgendamentoStatus agendamento_status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agendamento_usuario_id",nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agendamento_servico_id",nullable = false)
    private Servico servico;

    @Override
    public String toString() {
        return "AgendamentoEntity{" +
                "agendamento_id=" + agendamento_id +
                ", agendamento_data=" + agendamento_data +
                ", agendamento_hora=" + agendamento_hora +
                ", agendamento_observacao='" + agendamento_observacao + '\'' +
                ", agendamento_status=" + agendamento_status +
                ", agendamento_usuario_id=" + usuario +
                ", agendamento_servico_id=" + servico +
                '}';
    }
}