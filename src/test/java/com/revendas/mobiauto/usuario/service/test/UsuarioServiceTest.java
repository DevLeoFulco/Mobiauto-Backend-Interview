package com.revendas.mobiauto.usuario.service.test;

import com.revendas.mobiauto.model.Usuario;
import com.revendas.mobiauto.repository.UsuarioRepository;
import com.revendas.mobiauto.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setSenha("password");

        when(usuarioRepository.findByEmail("test@example.com")).thenReturn(Optional.of(usuario));

        UserDetails userDetails = usuarioService.loadUserByUsername("test@example.com");

        assertEquals("test@example.com", userDetails.getUsername());
    }

    @Test
    void testLoadUserByUsernameNotFound() {
        when(usuarioRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            usuarioService.loadUserByUsername("test@example.com");
        });
    }

    @Test
    void testSave() {
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setSenha("password");

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario savedUsuario = usuarioService.save(usuario);

        assertEquals("test@example.com", savedUsuario.getEmail());
    }

    @Test
    void testListarTodos() {
        List<Usuario> usuarios = List.of(new Usuario(), new Usuario());

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioService.listarTodos();

        assertEquals(2, result.size());
    }
}
