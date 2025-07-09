package com.leandro.sistema_gestao_tarefas.repositories;

import com.leandro.sistema_gestao_tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
