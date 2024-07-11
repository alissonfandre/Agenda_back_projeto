package com.Agenda_back.Usuario;


import com.Agenda_back.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long usuario_id;

    @NotNull(message = "O campo NOME é requerido.")
    private String usuario_nome;

    @CPF
    @NotNull(message = "O campo CPF é requerido.")
    private String usuario_cpf;

    @NotNull(message = "O campo EMAIL é requerido.")
    private String usuario_email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo DATA DE NASCIMENTO é requerido.")
    private LocalDate usuario_data_nascimento;

    @NotNull(message = "O campo SENHA é requerido.")
    private String usuario_senha;

    private Endereco usuario_endereco_id;
}

