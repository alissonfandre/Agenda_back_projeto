package com.Agenda_back.Telefone;

import com.Agenda_back.Prestador.Prestador;
import com.Agenda_back.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="telefone_id")
    private Long telefone_id;

    @Column(name="telefone_numero", nullable = false, length = 45)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXX-XXXX")
    private String telefone_numero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "telefone_usuario_id")
    private Usuario telefone_usuario_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "telefone_prestador_id")
    private Prestador telefone_prestador_id;

    @Override
    public String toString() {
        return "TelefoneEntity{" +
                "telefone_id=" + telefone_id +
                ", telefone_numero='" + telefone_numero + '\'' +
                ", telefone_usuario_id=" + telefone_usuario_id +
                ", telefone_prestador_id=" + telefone_prestador_id +
                '}';
    }
}
