package com.revendas.mobiauto.usuario.controller.test;

import com.revendas.mobiauto.controller.UsuarioController;
import com.revendas.mobiauto.model.Usuario;
import com.revendas.mobiauto.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    public UsuarioControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setSenha("password");

        when(usuarioService.save(usuario)).thenReturn(usuario);

        ResponseEntity<Usuario> response = usuarioController.criarUsuario(usuario);

        assertEquals("test@example.com", response.getBody().getEmail());
    }

    @Test
    void testListarUsuarios() {
        List<Usuario> usuarios = List.of(new Usuario(), new Usuario());

        when(usuarioService.listarTodos()).thenReturn(usuarios);

        ResponseEntity<List<Usuario>> response = usuarioController.listarUsuarios();

        assertEquals(2, response.getBody().size());
    }
}