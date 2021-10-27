package br.com.nilo.userapi.controller;

import br.com.nilo.userapi.controller.dto.CadastroDTO;
import br.com.nilo.userapi.entity.Cadastro;
import br.com.nilo.userapi.repository.CadastroJpa;
import br.com.nilo.userapi.service.UserService;
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
    UserService userService;

    //select all
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET, produces = "application/json")
    public List<Cadastro> Get() {

        return userService.findAll();

    }

    //select id
    @RequestMapping(value = "/cadastro/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CadastroDTO> GetById(@PathVariable(value = "id") long id) {

        return userService.findById(id)
                .map(CadastroDTO::new)
                .map(dto -> new ResponseEntity<CadastroDTO>(dto,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

    //insert
    @RequestMapping(value = "/cadastro", method = RequestMethod.POST, produces="application/json", consumes="application/json" )
    public Cadastro Post(@Valid @RequestBody Cadastro cadastro) {

        return userService.save(cadastro);

    }

    //update
    @RequestMapping(value = "/cadastro/{id}", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<CadastroDTO> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cadastro newCadastro){

        Cadastro cadastro  = userService.put(id, newCadastro);
        CadastroDTO dto = new CadastroDTO(cadastro);

        if( dto != null ){
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //delete
    @RequestMapping(value = "/cadastro/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id){

        if( userService.delete( id ) ){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
