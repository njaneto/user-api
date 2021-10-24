package br.com.nilo.userapi.controller;

import br.com.nilo.userapi.entity.Cadastro;
import br.com.nilo.userapi.repository.CadastroJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private CadastroJpa cadastroJpa;

    //select all
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET, produces = "application/json")
    public List<Cadastro> Get() {
        return cadastroJpa.findAll();
    }

    //select id
    @RequestMapping(value = "/cadastro/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Cadastro> GetById(@PathVariable(value = "id") long id) {

        Optional<Cadastro> cadastro = cadastroJpa.findById(id);

        if( cadastro.isPresent() ) {
            return new ResponseEntity<Cadastro>(cadastro.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(cadastro.get(), HttpStatus.NOT_FOUND);
    }

    //insert
    @RequestMapping(value = "/cadastro", method = RequestMethod.POST, produces="application/json", consumes="application/json" )
    public Cadastro Post(@Valid @RequestBody Cadastro cadastro) {

        Optional<Cadastro> exist = cadastroJpa.findById(cadastro.getId());

        if( exist.isPresent() ) {
            return cadastroJpa.getOne(cadastro.getId());
        }

        return cadastroJpa.save(cadastro);
    }

    //update
    @RequestMapping(value = "/cadastro/{id}", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Cadastro> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cadastro newCadastro){

        Optional<Cadastro> old = cadastroJpa.findById(id);
        if ( old.isPresent() ){
            Cadastro cadastro = old.get();
            cadastro.setNome(newCadastro.getNome());
            cadastroJpa.save(cadastro);
            return new ResponseEntity<Cadastro>(cadastro, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //delete
    @RequestMapping(value = "/cadastro/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id){

        Optional<Cadastro> cadastro = cadastroJpa.findById(id);

        if( cadastro.isPresent() ) {
            cadastroJpa.delete(cadastro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
