package com.revendas.mobiauto.usuario.integration;

import com.revendas.mobiauto.model.Usuario;
import com.revendas.mobiauto.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setSenha(passwordEncoder.encode("password"));
        usuarioRepository.save(usuario);
    }

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"test@example.com\", \"password\": \"password\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testRegister() throws Exception {
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"newuser@example.com\", \"senha\": \"password\"}"))
                .andExpect(status().isOk());
    }
}
