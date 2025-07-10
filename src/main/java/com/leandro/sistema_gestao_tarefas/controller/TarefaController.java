package com.leandro.sistema_gestao_tarefas.controller;

import com.leandro.sistema_gestao_tarefas.Dtos.TarefaCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.TarefaResponseDto;
import com.leandro.sistema_gestao_tarefas.Service.TarefaService;
import com.leandro.sistema_gestao_tarefas.model.Enums.StatusTarefa;
import com.leandro.sistema_gestao_tarefas.model.Tarefa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaResponseDto>criarTarefa(@RequestBody @Valid TarefaCreateDto createDto){
        TarefaResponseDto responseDto=tarefaService.salvar(createDto);
        URI location = URI.create("api/v1/tarefas/" + responseDto.getId());
        return ResponseEntity.created(location).body(responseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto>buscarPorId(@PathVariable Long id){
        TarefaResponseDto responseDto=tarefaService.buscarPorId(id);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>>buscarTodos(){
        List<TarefaResponseDto>responseDtos=tarefaService.buscarTodos();
        return ResponseEntity.ok(responseDtos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDto>editarTarefas(@PathVariable Long id,@RequestBody @Valid TarefaCreateDto createDto){
        TarefaResponseDto responseDto=tarefaService.editarTarefa(id,createDto);
        return ResponseEntity.ok(responseDto);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<TarefaResponseDto> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusTarefa status
    ) {
        TarefaResponseDto response = tarefaService.atualizarStatus(id, status);
        return ResponseEntity.ok(response);
    }
}
