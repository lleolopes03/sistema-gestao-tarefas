package com.leandro.sistema_gestao_tarefas.Service;

import com.leandro.sistema_gestao_tarefas.exception.CepNaoEncontradoException;
import com.leandro.sistema_gestao_tarefas.model.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    public Endereco buscarEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new CepNaoEncontradoException("CEP não encontrado: " + cep);
        }
    }
}
