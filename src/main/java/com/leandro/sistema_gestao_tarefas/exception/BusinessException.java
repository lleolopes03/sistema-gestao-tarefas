package com.leandro.sistema_gestao_tarefas.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
