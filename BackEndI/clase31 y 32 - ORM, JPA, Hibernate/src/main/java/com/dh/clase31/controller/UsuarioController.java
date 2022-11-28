package com.dh.clase31.controller;

import com.dh.clase31.entity.Usuario;
import com.dh.clase31.service.MovimientoService;
import com.dh.clase31.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> listUsuarios(){
        return ResponseEntity.ok(usuarioService.listUsuarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuario(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioId(id));
    }
    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }
}
