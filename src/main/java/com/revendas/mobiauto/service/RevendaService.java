package com.revendas.mobiauto.service;

import com.revendas.mobiauto.model.Revenda;
import com.revendas.mobiauto.repository.RevendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RevendaService {

    @Autowired
    private RevendaRepository revendaRepository;

    @Transactional
    public Revenda salvar(Revenda revenda) {
        if (revendaRepository.existsByCnpj(revenda.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já existe");
        }
        return revendaRepository.save(revenda);
    }

    public List<Revenda> listarTodas() {
        return revendaRepository.findAll();
    }


}
