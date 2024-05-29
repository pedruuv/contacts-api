package com.contatos.gerenciadordecontatos.mapper;

import com.contatos.gerenciadordecontatos.dto.ContatoDto;
import com.contatos.gerenciadordecontatos.dto.EnderecoDto;
import com.contatos.gerenciadordecontatos.dto.GetContatoDto;
import com.contatos.gerenciadordecontatos.dto.UpdateContatoDto;
import com.contatos.gerenciadordecontatos.models.Contato;
import com.contatos.gerenciadordecontatos.models.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContatoMapper {
    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    Contato dtoToContato(UpdateContatoDto contatoDto);

    UpdateContatoDto contatoToDto(Contato contato);

    List<GetContatoDto> listContatoToListDto(List<Contato> contatoList);

    Contato dtoToSaveContato(ContatoDto contatoDto);

    Endereco dtoToEndereco(EnderecoDto enderecoDto);

    EnderecoDto enderecoToDto(Endereco endereco);
}
