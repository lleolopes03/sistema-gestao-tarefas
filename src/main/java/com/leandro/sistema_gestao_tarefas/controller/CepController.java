package com.leandro.sistema_gestao_tarefas.controller;

import com.leandro.sistema_gestao_tarefas.model.Endereco;
import com.leandro.sistema_gestao_tarefas.Service.CepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "CEP Controller", description = "Consulta de endereços por CEP")
@RestController
public class CepController {
    @Autowired
    private CepService cepService;
    @Operation(
            summary = "Buscar endereço por CEP",
            description = "Consulta um endereço completo a partir do CEP informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço localizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "CEP não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar o CEP")
    })

    @GetMapping("/cep")
    public Endereco buscarEndereco(@RequestParam String cep) {
        return cepService.buscarEnderecoPorCep(cep);
    }
}
