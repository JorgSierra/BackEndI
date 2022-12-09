package com.dh.TFI.security;

import com.dh.TFI.entity.Usuario;
import com.dh.TFI.entity.UsuarioRole;
import com.dh.TFI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargarDatosIniciales implements ApplicationRunner {
    // Simplemente para cargar un usuario
    private UsuarioRepository usuarioRepository;
    @Autowired
    public CargarDatosIniciales(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Cargar un usuario para probar
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passCifrada = encoder.encode("digital");
        Usuario usuario = new Usuario("Jorge", "jorgsierra", "jorge@correo.com", passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
        usuario = new Usuario("Rodolfo", "baspi", "baspi@correo.com", passCifrada, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario);
    }
}
