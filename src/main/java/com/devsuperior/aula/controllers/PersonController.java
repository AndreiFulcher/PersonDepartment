package com.devsuperior.aula.controllers;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

    @Autowired
    private PersonService service;

   // @PostMapping // Serve para mapear requisições HTTP POST para este método
    public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO dto) { // Serve para indicar que o corpo da requisição será convertido em um objeto ProductDTO
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto); // Retorna uma resposta HTTP 201 Created com o URI do novo recurso no cabeçalho Location
    }

    @PostMapping // Serve para mapear requisições HTTP POST para este método
    public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO dto) { // Serve para indicar que o corpo da requisição será convertido em um objeto ProductDTO
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto); // Retorna uma resposta HTTP 201 Created com o URI do novo recurso no cabeçalho Location
    }
}
