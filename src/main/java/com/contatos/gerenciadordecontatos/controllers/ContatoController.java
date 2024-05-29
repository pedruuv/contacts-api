package com.contatos.gerenciadordecontatos.controllers;

import java.util.List;

import com.contatos.gerenciadordecontatos.dto.GetContatoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.contatos.gerenciadordecontatos.dto.ContatoDto;
import com.contatos.gerenciadordecontatos.dto.UpdateContatoDto;
import com.contatos.gerenciadordecontatos.models.Contato;
import com.contatos.gerenciadordecontatos.services.ContatoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<GetContatoDto>> getAll(){
        List<GetContatoDto> contatos = contatoService.getAllContacts();

        return ResponseEntity.status(HttpStatus.OK).body(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneContact(@PathVariable Long id){
        var contato = contatoService.getContactById(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(contato);
    }

    @PostMapping
    public ResponseEntity<Contato> createContact(@RequestBody @Valid ContatoDto contatoDto){
        var contato = contatoService.createContato(contatoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContact(@PathVariable Long id, @RequestBody @Valid UpdateContatoDto contatoDto){
        var contato = contatoService.updateContato(id, contatoDto);
        return ResponseEntity.status(HttpStatus.OK).body(contato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable Long id){
        var contato = contatoService.deleteContato(id);
        return ResponseEntity.status(HttpStatus.OK).body("Contact deleted succesfully");
    }
}
