package com.revendas.mobiauto.repository;

import com.revendas.mobiauto.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}
