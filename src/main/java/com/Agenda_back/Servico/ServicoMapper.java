package com.Agenda_back.Servico;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    @Mapping(source = "servico_id", target = "servico_id")
    ServicoDTO toDTO(Servico servico);

    @Mapping(source = "servicoDTO.servico_id", target="servico_id")
    Servico toEntity(ServicoDTO servicoDTO);

    List<ServicoDTO> toDTO(List<Servico> servicos);
    @Mappings({
            @Mapping(source = "servicoDTO.servico_id", target = "servico_id"),
            @Mapping(source = "servicoDTO.servico_nome", target = "servico_nome"),
            @Mapping(source = "servicoDTO.servico_informacoes_extra", target = "servico_informacoes_extra"),
            @Mapping(source = "servicoDTO.servico_descricao", target = "servico_descricao"),
            @Mapping(source = "servicoDTO.servico_preco", target = "servico_preco"),
            @Mapping(source = "servicoDTO.categoria", target = "categoria"),
            @Mapping(source = "servicoDTO.prestador", target = "prestador"),
    })
    Servico updateEntity(ServicoDTO servicoDTO, Servico servico);
}
