package com.prueba.iteria.Validation;

import com.prueba.iteria.Models.Afiliado;
import com.prueba.iteria.Util.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class AfiliadoValidate implements AfiliadoValidation{

    private void Message(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }


    @Override
    public void Validation(Afiliado afiliado) throws ResourceNotFound {
        if (afiliado.getNombre()==null){
            this.Message("Es Obligatorio El Campo Nombre, Intente Nuevamente");
        }
        if (afiliado.getApellido()==null){
            this.Message("Es Obligatorio El Campo Apellido, Intente Nuevamente");
        }
        if (afiliado.getDireccion()==null){
            this.Message("Es Obligatorio El Campo Direccion, Intente Nuevamente");
        }
        if (afiliado.getDocumento()==null){
            this.Message("Es Obligatorio El Campo Documento, Intente Nuevamente");
        }
        if (afiliado.getEstado()<0){
            this.Message("Valor Incorrecto, Intente Nuevamente");
        }
        if (afiliado.getTelefono()==null){
            this.Message("Es Obligatorio El Campo Telefono, Intente Nuevamente");
        }
        if (afiliado.getMail()==null){
            this.Message("Es Obligatorio El Campo Mail, Intente Nuevamente");
        }
    }
}
