package com.Agenda_back.Usuario;

import com.Agenda_back.Agendamentos.Agendamento;
import com.Agenda_back.Telefone.Telefone;
import com.Agenda_back.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private Long usuario_id;
    @Column(name="usuario_nome")
    private String usuario_nome;
    @Column(name="usuario_cpf", unique = true)
    private String usuario_cpf;
    @Column(name="usuario_email",unique = true)
    private String usuario_email;
    @Column(name = "usuario_data_nascimento")
    private LocalDate usuario_data_nascimento;
    @Column(name = "usuario_senha")
    private String usuario_senha;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_endereco_id")
    private Endereco usuario_endereco_id;

    @OneToMany(mappedBy = "telefone_usuario_id", fetch = FetchType.EAGER)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "usuario_id=" + usuario_id +
                ", usuario_nome='" + usuario_nome + '\'' +
                ", usuario_cpf='" + usuario_cpf + '\'' +
                ", usuario_email='" + usuario_email + '\'' +
                ", usuario_data_nascimento=" + usuario_data_nascimento +
                ", usuario_senha='" + usuario_senha + '\'' +
                ", usuario_endereco_id=" + usuario_endereco_id +
                '}';
    }
}
