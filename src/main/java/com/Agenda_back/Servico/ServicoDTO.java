package com.Agenda_back.Servico;

import com.Agenda_back.Prestador.Prestador;
import com.Agenda_back.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long servico_id;

    @NotNull(message = "O campo NOME é requerido.")
    private String servico_nome;

    @NotNull(message = "O campo INFORMACOES EXTRA é requerido.")
    private String servico_informacoes_extra;

    @NotNull(message = "O campo DESCRICAO é requerido.")
    private String servico_descricao;

    @NotNull(message = "O campo PRECO é requerido.")
    private double servico_preco;
    @JsonIgnore
    @NotNull(message = "O campo CATEGORIA é requerido.")
    private Categoria categoria;
    @JsonIgnore
    @NotNull(message = "O campo. PRESTADOR é requerido.")
    private Prestador prestador;
}
