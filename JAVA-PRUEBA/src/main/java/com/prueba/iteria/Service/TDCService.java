package com.prueba.iteria.Service;

import com.prueba.iteria.Models.Tipo_Documento;
import com.prueba.iteria.Repository.TDC.TDCRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDCService {

    @Autowired
    private TDCRepositoryJpa tdcRepositoryJpa;


    public Tipo_Documento getTipoDocumentoId(Integer id){
        return tdcRepositoryJpa.findById(id).get();
    }
}
