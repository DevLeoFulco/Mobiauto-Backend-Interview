package com.revendas.mobiauto.controller;

import com.revendas.mobiauto.model.Revenda;
import com.revendas.mobiauto.service.RevendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revendas")
public class RevendaController {

    @Autowired
    private RevendaService revendaService;

    @PostMapping
    public ResponseEntity<Revenda> criarRevenda(@RequestBody Revenda revenda) {
        return ResponseEntity.ok(revendaService.salvar(revenda));
    }

    @GetMapping
    public ResponseEntity<List<Revenda>> listarRevendas() {
        return ResponseEntity.ok(revendaService.listarTodas());
    }


}
