package com.revendas.mobiauto.controller;

import com.revendas.mobiauto.model.Oportunidade;
import com.revendas.mobiauto.service.OportunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @Autowired
    private OportunidadeService oportunidadeService;

    @PostMapping
    public ResponseEntity<Oportunidade> criarOportunidade(@RequestBody Oportunidade oportunidade) {
        return ResponseEntity.ok(oportunidadeService.salvar(oportunidade));
    }

    @GetMapping
    public ResponseEntity<List<Oportunidade>> listarOportunidades() {
        return ResponseEntity.ok(oportunidadeService.listarTodas());
    }

}
