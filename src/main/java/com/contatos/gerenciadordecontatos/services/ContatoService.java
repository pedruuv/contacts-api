package com.contatos.gerenciadordecontatos.services;

import java.util.List;
import java.util.Optional;

import com.contatos.gerenciadordecontatos.dto.GetContatoDto;
import com.contatos.gerenciadordecontatos.mapper.ContatoMapper;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contatos.gerenciadordecontatos.dto.ContatoDto;
import com.contatos.gerenciadordecontatos.dto.UpdateContatoDto;
import com.contatos.gerenciadordecontatos.models.Contato;
import com.contatos.gerenciadordecontatos.repositories.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<GetContatoDto> getAllContacts(){
        List<Contato> contatos = repository.findAll();

        List<GetContatoDto> contatosDto = ContatoMapper.INSTANCE.listContatoToListDto(contatos);
        return contatosDto;
    }

    public Object getContactById(Long id){
        if (id == null){
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        var contato = repository.findById(id).orElseThrow(() -> new RuntimeException("Não achei"));

        var dto = ContatoMapper.INSTANCE.contatoToDto(contato);
        return dto;
    }

    public Contato createContato(ContatoDto contatoDto){
        var contato = ContatoMapper.INSTANCE.dtoToSaveContato(contatoDto);

        repository.save(contato);
        return contato;
    }

    public Object updateContato(Long id, UpdateContatoDto dto){
        Contato contatoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Não achei"));

        var contatoAtualizado = ContatoMapper.INSTANCE.dtoToContato(dto);
        contatoAtualizado.setId(contatoExistente.getId());

        return repository.save(contatoAtualizado);
    }

    public String deleteContato(Long id){
        var contato = repository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        repository.delete(contato);
        return "Contato Excluido";
    }

}
