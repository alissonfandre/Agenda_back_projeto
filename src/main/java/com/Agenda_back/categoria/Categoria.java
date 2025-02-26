package com.Agenda_back.categoria;


import com.Agenda_back.Servico.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data //-Getters -Setters Hash Equals toString
@AllArgsConstructor //usar com cuidado em tabelas com chave estrangeira
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long categoria_id;
    @Column(name = "categoria_nome")
    private String categoria_nome;
    @Column(name = "categoria_descricao")
    private String categoria_descricao;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Servico> servicos;

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "categoria_id=" + categoria_id +
                ", categoria_nome='" + categoria_nome + '\'' +
                ", categoria_descricao='" + categoria_descricao + '\'' +
                '}';
    }
}