package br.com.nilo.userapi.controller.dto;

import br.com.nilo.userapi.entity.Cadastro;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CadastroDTO {

    public CadastroDTO(Cadastro cadastro) {
        this.id = cadastro.getId();
        this.nome = cadastro.getNome();
    }

    private long id;
    private String nome;

}
