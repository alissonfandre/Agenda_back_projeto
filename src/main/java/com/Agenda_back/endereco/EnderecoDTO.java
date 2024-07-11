package com.Agenda_back.endereco;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long endereco_id;
    @NotNull(message = "O campo RUA é requerido")
    private String endereco_rua;
    @NotNull(message = "O campo CEP é requerido")
    private String endereco_cep;
    @NotNull(message = "O campo NUMERO é requerido")
    private int endereco_numero;
    @NotNull(message = "O campo COMPLEMENTO é requerido")
    private String endereco_complemento;
    @NotNull(message = "O campo CIDADE é requerido")
    private String endereco_cidade;
    @NotNull(message = "O campo ESTADO é requerido")
    private String endereco_estado;
    @NotNull(message = "O campo BAIRRO é requerido")
    private String endereco_bairro;

    //private List<UsuarioDTO> usuarios;
    //private List<PrestadorDTO> prestadores;
}