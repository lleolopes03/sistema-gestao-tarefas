package com.leandro.sistema_gestao_tarefas.Dtos.Mapper;


import com.leandro.sistema_gestao_tarefas.Dtos.TarefaCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.TarefaResponseDto;
import com.leandro.sistema_gestao_tarefas.model.Tarefa;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;

public class TarefaMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static Tarefa toTarefa(TarefaCreateDto createDto) {
        return mapper.map(createDto, Tarefa.class);
    }

    public static TarefaResponseDto toDto(Tarefa tarefa) {
        return mapper.map(tarefa, TarefaResponseDto.class);
    }

    public static List<TarefaResponseDto> toListDto(List<Tarefa> tarefas) {
        return tarefas.stream()
                .map(TarefaMapper::toDto)
                .collect(Collectors.toList());
    }




}
