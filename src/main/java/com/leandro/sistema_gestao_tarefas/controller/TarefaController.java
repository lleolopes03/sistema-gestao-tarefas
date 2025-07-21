package com.leandro.sistema_gestao_tarefas.controller;

import com.leandro.sistema_gestao_tarefas.Dtos.TarefaCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.TarefaResponseDto;
import com.leandro.sistema_gestao_tarefas.Service.TarefaService;
import com.leandro.sistema_gestao_tarefas.model.Enums.StatusTarefa;
import com.leandro.sistema_gestao_tarefas.model.Tarefa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@Tag(name = "Tarefa Controller", description = "Gerenciamento de tarefas")
@RestController
@RequestMapping("api/v1/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @Operation(
            summary = "Criar tarefa ",
            description = "Criar tarefa "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Tarefa cadastrada com sucesso"),

    })
    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<TarefaResponseDto>criarTarefa(@RequestBody @Valid TarefaCreateDto createDto){
        TarefaResponseDto responseDto=tarefaService.salvar(createDto);
        URI location = URI.create("api/v1/tarefas/" + responseDto.getId());
        return ResponseEntity.created(location).body(responseDto);
    }
    @Operation(
            summary = "Buscar  tarefa por Id ",
            description = "Buscar tarefa por Id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Tarefa localizada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Tarefa não encontrado"),

    })
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @tarefaService.isDonoDaTarefa(#id)")
    public ResponseEntity<TarefaResponseDto>buscarPorId(@PathVariable Long id){
        TarefaResponseDto responseDto=tarefaService.buscarPorId(id);
        return ResponseEntity.ok(responseDto);
    }
    @Operation(
            summary = "Lista de tarefas ",
            description = "Buscar lista de  tarefas "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista de tarefas encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Lista de tarefas não encontrado"),

    })
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public ResponseEntity<List<TarefaResponseDto>>buscarTodos(){
        List<TarefaResponseDto>responseDtos=tarefaService.buscarTodos();
        return ResponseEntity.ok(responseDtos);
    }
    @Operation(
            summary = "Deletar tarefa ",
            description = "Deletar tarefa "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Tarefa não deletada"),

    })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @tarefaService.isDonoDaTarefa(#id)")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(
            summary = "Editar tarefa",
            description = "Editar tarefa "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Tarefa editada com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao editar tarefa "),

    })
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('USUARIO') and @tarefaService.isDonoDaTarefa(#id))")
    public ResponseEntity<TarefaResponseDto>editarTarefas(@PathVariable Long id,@RequestBody @Valid TarefaCreateDto createDto){
        TarefaResponseDto responseDto=tarefaService.editarTarefa(id,createDto);
        return ResponseEntity.ok(responseDto);
    }
    @Operation(
            summary = "Editar status da tarefa ",
            description = "Editar etatus da tarefa "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "status da tarefa editado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro ao editar status da tarefa "),

    })
    @PutMapping("/{id}/status")
    public ResponseEntity<TarefaResponseDto> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusTarefa status
    ) {
        TarefaResponseDto response = tarefaService.atualizarStatus(id, status);
        return ResponseEntity.ok(response);
    }
}
