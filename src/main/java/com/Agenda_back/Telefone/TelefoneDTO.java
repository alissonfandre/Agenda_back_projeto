package com.Agenda_back.Telefone;



import com.Agenda_back.Prestador.Prestador;
import com.Agenda_back.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long telefone_id;
    @NotNull(message = "O campo NUMERO é requerido")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXX-XXXX")
    private String telefone_numero;

    private Usuario telefone_usuario_id;

    private Prestador telefone_prestador_id;
}
