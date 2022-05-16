package com.prueba.iteria.Service;

import com.prueba.iteria.Models.Afiliado;
import com.prueba.iteria.Repository.Afiliado.AfiliadoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepositoryJpa afiliadoRepositoryJpa;

    public Afiliado getAfiliado(Integer id){
        return afiliadoRepositoryJpa.findById(id).get();
    }

}
