package br.com.nilo.userapi.repository;

import br.com.nilo.userapi.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroJpa extends JpaRepository<Cadastro, Long> {

}
