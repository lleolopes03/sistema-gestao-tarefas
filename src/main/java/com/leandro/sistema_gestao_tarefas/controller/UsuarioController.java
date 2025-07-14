package com.leandro.sistema_gestao_tarefas.controller;

import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioResponseDto;
import com.leandro.sistema_gestao_tarefas.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@Tag(name = "Usuario Controller", description = "Criação,busca,edição e deleção de usuario")
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Operation(
            summary = "Criar usuario ",
            description = "Criar usuário "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Usuario cadastrado com sucesso"),

    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDto>create(@RequestBody @Valid UsuarioCreateDto createDto){
        UsuarioResponseDto responseDto=usuarioService.salvar(createDto);
        URI location = URI.create("/usuarios/" + responseDto.getId());
        return ResponseEntity.created(location).body(responseDto);


    }
    @Operation(
            summary = "Buscar  usuario por Id ",
            description = "Buscar usuário por Id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuario localizado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Usuario não encontrado"),

    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>getById(@PathVariable Long id){
        UsuarioResponseDto responseDto=usuarioService.buscarPorId(id);
        return ResponseEntity.ok(responseDto);
    }
    @Operation(
            summary = "Lista de usuarios ",
            description = "Buscar lista de  usuários "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista de usuarios encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Lista de usuario não encontrado"),

    })
    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDto>>getAll(){
        List<UsuarioResponseDto>responseDtos=usuarioService.buscarTodos();
        return ResponseEntity.ok(responseDtos);

    }
    @Operation(
            summary = "Deletar usuario ",
            description = "Deletar usuario "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "Usuario deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Usuario não deletado"),

    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Editar usuario ",
            description = "Editar usuario "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuario editado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao editar usuario "),

    })

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>editarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioCreateDto createDto){
        UsuarioResponseDto usuarioResponseDto=usuarioService.editarUsuario(id,createDto);
        return ResponseEntity.ok(usuarioResponseDto);
    }

}
