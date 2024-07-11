package com.Agenda_back.Servico;

import com.Agenda_back.Agendamentos.Agendamento;
import com.Agenda_back.Prestador.Prestador;
import com.Agenda_back.categoria.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "servico")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="servico_id")
    private Long servico_id;

    @Column(name="servico_nome")
    private String servico_nome;

    @Column(name = "servico_informacoes_extra")
    private String servico_informacoes_extra;

    @Column(name = "servico_descricao")
    private String servico_descricao;

    @Column(name="servico_preco")
    private double servico_preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_prestador_id", nullable = false)
    private Prestador prestador;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;

    @Override
    public String toString() {
        return "ServicoEntity{" +
                "servico_id=" + servico_id +
                ", servico_nome='" + servico_nome + '\'' +
                ", servico_informacoes_extra='" + servico_informacoes_extra + '\'' +
                ", servico_descricao='" + servico_descricao + '\'' +
                ", servico_preco=" + servico_preco +
                  '}';
    }


}
