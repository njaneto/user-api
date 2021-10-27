package br.com.nilo.userapi.repository;

import br.com.nilo.userapi.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CadastroJpa extends JpaRepository<Cadastro, Long> {
}
