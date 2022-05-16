package com.prueba.iteria.Repository.TDC;

import com.prueba.iteria.Models.Tipo_Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TDCRepositoryJpa extends JpaRepository<Tipo_Documento,Integer> {
}
