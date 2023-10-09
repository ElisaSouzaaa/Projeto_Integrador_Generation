package com.agreenfood.agreenfood.controller;


import com.agreenfood.agreenfood.model.Usuario;
import com.agreenfood.agreenfood.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return usuarioRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nomeCompleto}")
    public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nomeCompleto) {
        return ResponseEntity.ok(usuarioRepository.findByNomeCompletoContainingIgnoreCase(nomeCompleto));
    }

    @PostMapping
    public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario>put(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.findById(usuario.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        usuarioRepository.deleteById(id);
    }


}










