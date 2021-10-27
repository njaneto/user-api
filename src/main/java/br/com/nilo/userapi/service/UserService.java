package br.com.nilo.userapi.service;

import br.com.nilo.userapi.entity.Cadastro;
import br.com.nilo.userapi.repository.CadastroJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private CadastroJpa cadastroJpa;

    public Optional<Cadastro> findById(long id ){

        return cadastroJpa.findById( id );

    }

    public List<Cadastro> findAll() {

        return cadastroJpa.findAll();

    }

    public Cadastro save(Cadastro cadastro ) {

        return cadastroJpa.save( cadastro );

    }

    public Cadastro put(long id, Cadastro newCadastro) {

        if( findById(id).isPresent() ) {
            Cadastro cadastro = findById(id).get();
            cadastro.setNome(newCadastro.getNome());
            save(cadastro);
            return cadastro;
        }

        return null;

    }

    public boolean delete(long id) {

        if( findById(id).isPresent() ) {
            cadastroJpa.delete(findById(id).get());
            return true;
        }
        return false;

    }
}
