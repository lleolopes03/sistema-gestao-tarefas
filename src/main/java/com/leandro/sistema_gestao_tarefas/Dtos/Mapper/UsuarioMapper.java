package com.leandro.sistema_gestao_tarefas.Dtos.Mapper;

import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioResponseDto;
import com.leandro.sistema_gestao_tarefas.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    private static final ModelMapper mapper = new ModelMapper();

    static {
        PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setIdade(source.getIdade());
                map().setDataNascimento(source.getDataNascimento());
            }
        };

        mapper.addMappings(props);
    }

    public static Usuario toUsuario(UsuarioCreateDto createDto) {
        return mapper.map(createDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario) {
        return mapper.map(usuario, UsuarioResponseDto.class);
    }

    public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}
