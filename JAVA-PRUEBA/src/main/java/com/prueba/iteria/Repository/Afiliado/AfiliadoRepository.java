package com.prueba.iteria.Repository.Afiliado;

import com.prueba.iteria.Models.Afiliado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Repository
public interface AfiliadoRepository extends CrudRepository<Afiliado,Integer> {

    Collection<Afiliado>findAll();
}
