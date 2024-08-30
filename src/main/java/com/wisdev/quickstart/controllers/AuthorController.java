package com.wisdev.quickstart.controllers;

import com.wisdev.quickstart.domain.dto.AuthorDto;
import com.wisdev.quickstart.domain.entities.AuthorEntity;
import com.wisdev.quickstart.mapper.Mapper;
import com.wisdev.quickstart.repositories.AuthorRepository;
import com.wisdev.quickstart.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @RequestMapping(path = "/authors", method = RequestMethod.POST)
    public AuthorDto createAuthor(
      @RequestBody AuthorDto author
    ){
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);
        return authorMapper.mapTo(savedAuthorEntity);
    }

    @RequestMapping(path = "/authors", method = RequestMethod.GET)
    public List<AuthorDto> listAuthor(){
        List<AuthorEntity> authors = authorService.findAll();
        return authors.stream()
                .map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/authors/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorDto> getAuthor(
            @PathVariable("id") Long id
    ){
        Optional<AuthorEntity> foundAuthor = authorService.findOne(id);

        return foundAuthor.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<String> index(){
        String msg = "Hello v3";
        return ResponseEntity.ok(msg);
    }
}
