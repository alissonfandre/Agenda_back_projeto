package com.Agenda_back.Agendamentos;

public enum AgendamentoStatus {
    PENDENTE("Pendente"),
    CONCLUIDO("Concluido"),
    CANCELADO("Cancelado"),
    EM_ANDAMENTO("Em Andamento");
    private final String descricao;
    AgendamentoStatus(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }
}
