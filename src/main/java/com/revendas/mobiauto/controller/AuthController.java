package com.revendas.mobiauto.controller;

import com.revendas.mobiauto.model.Usuario;
import com.revendas.mobiauto.security.JwtTokenUtil;
import com.revendas.mobiauto.service.UsuarioService;
import com.revendas.mobiauto.dto.JwtRequest;
import com.revendas.mobiauto.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return new JwtResponse(jwt);
    }

    @PostMapping("/register")
    public Usuario registerUser(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
}
