package com.prueba.iteria.Controller.Afiliado;

import com.prueba.iteria.Models.Afiliado;
import com.prueba.iteria.Repository.Afiliado.AfiliadoRepository;
import com.prueba.iteria.Service.AfiliadoService;
import com.prueba.iteria.Util.ResourceNotFound;
import com.prueba.iteria.Validation.AfiliadoValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/afiliado")
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private AfiliadoService afiliadoService;

    @Autowired
    private AfiliadoValidate afiliadoValidate;


    @RequestMapping(value = "List",method = RequestMethod.GET)
    public ResponseEntity<Collection<Afiliado>> getList(){
        return new ResponseEntity<>(afiliadoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "turista/{id}",method = RequestMethod.GET)
    public ResponseEntity<Afiliado>getAfiliadoId(@PathVariable Integer id){
        Afiliado turista=afiliadoRepository.findById(id).orElseThrow();
        if (turista != null){
            return ResponseEntity.ok(turista);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?>UpdateAfiliado(@PathVariable Integer id,@RequestBody Afiliado afiliado){
        Map<String,Object> response=new HashMap<>();
        try {
            Afiliado updateAfiliado=afiliadoService.getAfiliado(id);
            afiliadoRepository.save(afiliado);
            response.put("Mensaje","El Afiliado Ha Sido Actualizado ".concat(id.toString()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
        }catch (DataAccessException exception){
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SaveAfiliado(@RequestBody Afiliado afiliado)throws ResourceNotFound {
        Map<String,Object>response=new HashMap<>();
        this.afiliadoValidate.Validation(afiliado);
        this.afiliadoRepository.save(afiliado);
        response.put("Mensaje","Afiliado Registrado En El Sistema");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteAfiliado(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            afiliadoRepository.deleteById(id);
            response.put("Mensaje","El Afiliado Ha sido Eliminado Del Sistema ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","No se pudo Eliminar El Afiliado del Sistema ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
