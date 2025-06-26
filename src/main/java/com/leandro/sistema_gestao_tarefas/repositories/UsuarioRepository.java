package com.leandro.sistema_gestao_tarefas.repositories;

import com.leandro.sistema_gestao_tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {

}
