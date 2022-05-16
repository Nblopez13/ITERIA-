package com.prueba.iteria.Repository.TDC;

import com.prueba.iteria.Models.Tipo_Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TDCRepository extends CrudRepository<Tipo_Documento,Integer> {


    Collection<Tipo_Documento>findAll();
}
