package com.dh.clase31.service;

import com.dh.clase31.entity.Usuario;
import com.dh.clase31.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> listUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public Optional<Usuario> buscarUsuarioId(Integer id){
        return usuarioRepository.findById(id);
    }
}
