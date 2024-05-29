package com.contatos.gerenciadordecontatos.models;

import com.contatos.gerenciadordecontatos.dto.ContatoDto;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "contato")
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;

    public Contato(Long id, String name, String email, String telefone, Endereco endereco) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Contato() {
    }

    public Contato(ContatoDto contato){
        this.name = contato.name();
        this.email = contato.email();
        this.telefone = contato.telefone();
        //this.endereco = new Endereco(contato.endereco());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
