package com.Agenda_back.Prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestadorMapper {
        @Mapping(source = "prestador_id", target = "prestador_id")
        PrestadorDTO toDTO(Prestador prestador);

        @Mapping(source = "prestadorDTO.prestador_id", target="prestador_id")
        Prestador toEntity(PrestadorDTO prestadorDTO);

        List<PrestadorDTO> toDTO(List<Prestador> prestadors);
        @Mappings({
                @Mapping(source = "prestadorDTO.prestador_id", target = "prestador_id"),
                @Mapping(source = "prestadorDTO.prestador_nome", target = "prestador_nome"),
                @Mapping(source = "prestadorDTO.prestador_email", target = "prestador_email"),
                @Mapping(source = "prestadorDTO.prestador_cnpj", target = "prestador_cnpj"),
                @Mapping(source = "prestadorDTO.prestador_endereco_id", target = "endereco"),
                @Mapping(source = "prestadorDTO.prestador_razao_social", target = "prestador_razao_social"),
                @Mapping(source = "prestadorDTO.prestador_senha", target = "prestador_senha"),
                @Mapping(source = "prestadorDTO.prestador_cpf", target = "prestador_cpf"),
        })
        Prestador updateEntity(PrestadorDTO prestadorDTO, Prestador prestador);
}
