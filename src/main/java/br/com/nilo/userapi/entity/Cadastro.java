package br.com.nilo.userapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;

@Data
@Entity
public class Cadastro {

    @ApiModelProperty(value = " Codigo unico da pessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = " Nome pessoa")
    @Column(nullable = false, name = "nome")
    private String nome;

}
