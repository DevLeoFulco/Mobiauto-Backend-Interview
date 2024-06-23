package com.revendas.mobiauto.service;

import com.revendas.mobiauto.model.Usuario;
import com.revendas.mobiauto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Não foram encontrados usuários com o nome de: " + username));
        return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
