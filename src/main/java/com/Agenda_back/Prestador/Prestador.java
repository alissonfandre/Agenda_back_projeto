package com.Agenda_back.Prestador;

import com.Agenda_back.Servico.Servico;
import com.Agenda_back.Telefone.Telefone;
import com.Agenda_back.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;

@Data //getter setter tostring equals hashcode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestador")
public class Prestador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestador_id")
    private Long prestador_id;

    @Column(name="prestador_nome")
    private String prestador_nome;

    @Column(name="prestador_cnpj", unique = true)
    private String prestador_cnpj;

    @Column(name="prestador_email", unique = true)
    private String prestador_email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestador_endereco_id")
    private Endereco endereco;

    @Column(name="prestador_razao_social")
    private String prestador_razao_social;

    @Column(name="prestador_senha")
    private String prestador_senha;

    @CPF
    @Column(name="prestador_cpf")
    private String prestador_cpf;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Telefone> telefones;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Servico> servicos;

    @Override
    public String toString() {
        return "PrestadorEntity{" +
                "prestador_id=" + prestador_id +
                ", prestador_nome='" + prestador_nome + '\'' +
                ", prestador_cnpj='" + prestador_cnpj + '\'' +
                ", prestador_email='" + prestador_email + '\'' +
                ", prestador_endereco_id=" + endereco +
                ", prestador_razao_social='" + prestador_razao_social + '\'' +
                ", prestador_senha='" + prestador_senha + '\'' +
                ", prestador_cpf='" + prestador_cpf + '\'' +
                '}';
    }
}
