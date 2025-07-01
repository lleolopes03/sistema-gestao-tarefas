package com.leandro.sistema_gestao_tarefas.controller;

import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioResponseDto;
import com.leandro.sistema_gestao_tarefas.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioResponseDto>create(@RequestBody @Valid UsuarioCreateDto createDto){
        UsuarioResponseDto responseDto=usuarioService.salvar(createDto);
        URI location = URI.create("/usuarios/" + responseDto.getId()); // 👈 precisa disso aqui!
        return ResponseEntity.created(location).body(responseDto);


    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>getById(@PathVariable Long id){
        UsuarioResponseDto responseDto=usuarioService.buscarPorId(id);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDto>>getAll(){
        List<UsuarioResponseDto>responseDtos=usuarioService.buscarTodos();
        return ResponseEntity.ok(responseDtos);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>editarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioCreateDto createDto){
        UsuarioResponseDto usuarioResponseDto=usuarioService.editarUsuario(id,createDto);
        return ResponseEntity.ok(usuarioResponseDto);
    }

}
