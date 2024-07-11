package com.Agenda_back.Prestador;


import com.Agenda_back.endereco.Endereco;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDTO implements Serializable {
        private static final long serialVersionUID = 1L;
        private Long prestador_id;
        @NotNull(message = "O campo NOME é requerido")
        private String prestador_nome;

        @NotNull(message = "O campo CNPJ é requerido")
        private String prestador_cnpj;

        @NotNull(message = "O campo EMAIL é requerido")
        private String prestador_email;


        private Endereco prestador_endereco_id;

        @NotNull(message = "O campo RAZAO SOCIAL é requerido")
        private String prestador_razao_social;

        @NotNull(message = "O campo SENHA é requerido")
        private String prestador_senha;

        @CPF
        @NotNull(message = "O campo CPF é requerido")
        private String prestador_cpf;
}
