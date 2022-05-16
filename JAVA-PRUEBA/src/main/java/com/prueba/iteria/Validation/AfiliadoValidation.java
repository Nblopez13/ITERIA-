package com.prueba.iteria.Validation;

import com.prueba.iteria.Models.Afiliado;
import com.prueba.iteria.Util.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface AfiliadoValidation {

    public void Validation(Afiliado afiliado)throws ResourceNotFound;
}
