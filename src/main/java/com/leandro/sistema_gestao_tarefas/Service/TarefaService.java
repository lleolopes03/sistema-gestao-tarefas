package com.leandro.sistema_gestao_tarefas.Service;

import com.leandro.sistema_gestao_tarefas.Dtos.Mapper.TarefaMapper;
import com.leandro.sistema_gestao_tarefas.Dtos.TarefaCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.TarefaResponseDto;
import com.leandro.sistema_gestao_tarefas.exception.BusinessException;
import com.leandro.sistema_gestao_tarefas.model.Enums.StatusTarefa;
import com.leandro.sistema_gestao_tarefas.model.Tarefa;
import com.leandro.sistema_gestao_tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaResponseDto salvar(TarefaCreateDto createDto){
        Tarefa tarefa= TarefaMapper.toTarefa(createDto);
        tarefa.setDataCriacao(LocalDateTime.now());
        Tarefa tarefaSalvar=tarefaRepository.save(tarefa);
        return TarefaMapper.toDto(tarefaSalvar);

    }
    public TarefaResponseDto buscarPorId(Long id){
        Tarefa tarefa=tarefaRepository.findById(id).orElseThrow(()->new BusinessException(String.format("Tarefa com id: %s não encontrado.",id)));
        return TarefaMapper.toDto(tarefa);
    }
    public List<TarefaResponseDto>buscarTodos(){
        List<Tarefa>tarefas=tarefaRepository.findAll();
        return TarefaMapper.toListDto(tarefas);
    }
    public void deletar(Long id){
        if(!tarefaRepository.existsById(id)){
            throw new BusinessException("Tarefa com id " + id + " não encontrado");
        }
        tarefaRepository.deleteById(id);
    }
    public TarefaResponseDto editarTarefa(Long id, TarefaCreateDto createDto){
        Tarefa tarefa=tarefaRepository.findById(id).orElseThrow(()->new BusinessException(String.format("Tarefa com id: %s não encontrado.",id)));
        tarefa.setNome(createDto.getNome());
        tarefa.setDescricao(createDto.getDescricao());
        tarefa.setPrazo(createDto.getPrazo());
        tarefa.setStatus(createDto.getStatus());
        tarefa.setPrioridade(createDto.getPrioridade());
        tarefa.setCategoria(createDto.getCategoria());
        tarefa.setObservacoes(createDto.getObservacoes());
        tarefa.setDataConclusao(createDto.getDataConclusao());
        Tarefa Atualizado=tarefaRepository.save(tarefa);
        return TarefaMapper.toDto(Atualizado);


    }
    public TarefaResponseDto atualizarStatus(Long id, StatusTarefa novoStatus) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Tarefa com id " + id + " não encontrada"));

        if (tarefa.getStatus() == novoStatus) {
            throw new BusinessException("Tarefa já está com o status " + novoStatus);
        }

        tarefa.setStatus(novoStatus);

        if (novoStatus == StatusTarefa.CONCLUIDA) {
            tarefa.setDataConclusao(LocalDateTime.now());
        } else {
            tarefa.setDataConclusao(null);
        }

        Tarefa atualizada = tarefaRepository.save(tarefa);
        return TarefaMapper.toDto(atualizada);
    }
}
