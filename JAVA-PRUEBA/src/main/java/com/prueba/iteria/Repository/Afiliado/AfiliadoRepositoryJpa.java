package com.prueba.iteria.Repository.Afiliado;

import com.prueba.iteria.Models.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepositoryJpa extends JpaRepository<Afiliado,Integer> {
}
