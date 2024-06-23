package com.revendas.mobiauto.service;

import com.revendas.mobiauto.model.Oportunidade;
import com.revendas.mobiauto.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    @Transactional
    public Oportunidade salvar(Oportunidade oportunidade) {
        return oportunidadeRepository.save(oportunidade);
    }

    public List<Oportunidade> listarTodas() {
        return oportunidadeRepository.findAll();
    }


}
