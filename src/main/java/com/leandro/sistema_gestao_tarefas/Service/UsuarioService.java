package com.leandro.sistema_gestao_tarefas.Service;

import com.leandro.sistema_gestao_tarefas.Dtos.Mapper.UsuarioMapper;
import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioCreateDto;
import com.leandro.sistema_gestao_tarefas.Dtos.UsuarioResponseDto;
import com.leandro.sistema_gestao_tarefas.exception.BusinessException;
import com.leandro.sistema_gestao_tarefas.model.Usuario;
import com.leandro.sistema_gestao_tarefas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto salvar(UsuarioCreateDto createDto){
        Usuario usuario = UsuarioMapper.toUsuario(createDto);
        Usuario usuarioSalvo=usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(usuarioSalvo);
    }
    public UsuarioResponseDto buscarPorId(Long id){
        Usuario usuario=usuarioRepository.findById(id).orElseThrow(()->new BusinessException(String.format("Cliente com id: %s não encontrado",id)));
        return UsuarioMapper.toDto(usuario);
    }
    public List<UsuarioResponseDto>buscarTodos(){
        List<Usuario>usuarios=usuarioRepository.findAll();
        return UsuarioMapper.toListDto(usuarios);
    }
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new BusinessException("Usuário com id " + id + " não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
    public UsuarioResponseDto editarUsuario(Long id, UsuarioCreateDto createDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new BusinessException(String.format("Usuário com id %s não encontrado", id)));

        usuario.setNome(createDto.getNome());
        usuario.setEmail(createDto.getEmail());
        usuario.setTelefone(createDto.getTelefone());
        usuario.setEndereco(createDto.getEndereco());

        Usuario atualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(atualizado);
    }


}
