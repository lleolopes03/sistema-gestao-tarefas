package com.leandro.sistema_gestao_tarefas.Dtos.Mapper;

import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioResponseDto;
import com.leandro.sistema_gestao_tarefas.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto, Usuario.class);
    }
    public static UsuarioResponseDto toDto(Usuario usuario){
        PropertyMap<Usuario,UsuarioResponseDto>props=new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {

            }
        };
        ModelMapper mapper=new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }
    public static List<UsuarioResponseDto>toListDto(List<Usuario>usuarios){
        return usuarios.stream().map(usu->toDto(usu)).collect(Collectors.toList());
    }
}
