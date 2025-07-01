package com.leandro.sistema_gestao_tarefas.infra;

import com.leandro.sistema_gestao_tarefas.exception.BusinessException;
import com.leandro.sistema_gestao_tarefas.exception.CepNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(CepNaoEncontradoException.class)
    public ResponseEntity<String> handleCepNaoEncontrado(CepNaoEncontradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());

    }
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handlerBusinessException(BusinessException exception){
        return new ApiError(exception.getMessage());
    }
}
