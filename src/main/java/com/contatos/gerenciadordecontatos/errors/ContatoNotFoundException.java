package com.contatos.gerenciadordecontatos.errors;

public class ContatoNotFoundException extends RuntimeException{

    public ContatoNotFoundException(Long idContato){
        super("Contato não foi encontrado com ID: " + idContato);
    }
}
