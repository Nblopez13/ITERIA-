package com.prueba.iteria.Controller.TDC;

import com.prueba.iteria.Models.Tipo_Documento;
import com.prueba.iteria.Repository.TDC.TDCRepository;
import com.prueba.iteria.Service.TDCService;
import com.prueba.iteria.Util.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/TDC")
public class TDCController {

    @Autowired
    private TDCRepository tdcRepository;

    @Autowired
    private TDCService tdcService;



    @RequestMapping(value = "List",method = RequestMethod.GET)
    public ResponseEntity<Collection<Tipo_Documento>> getList(){
        return new ResponseEntity<>(tdcRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "TDC/{id}",method = RequestMethod.GET)
    public ResponseEntity<Tipo_Documento>getTDCId(@PathVariable Integer id){
        Tipo_Documento tipo_documento=tdcRepository.findById(id).orElseThrow();
        if (tipo_documento != null){
            return ResponseEntity.ok(tipo_documento);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?>UpdateTDC(@PathVariable Integer id,@RequestBody Tipo_Documento tipo_documento){
        Map<String,Object> response=new HashMap<>();
        try {
            Tipo_Documento updateTDC=tdcService.getTipoDocumentoId(id);
            tdcRepository.save(tipo_documento);
            response.put("Mensaje","El TDC Ha Sido Actualizado ".concat(id.toString()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
        }catch (DataAccessException exception){
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SaveTDC(@RequestBody Tipo_Documento tipo_documento)throws ResourceNotFound {
        Map<String,Object>response=new HashMap<>();
        this.tdcRepository.save(tipo_documento);
        response.put("Mensaje","TDC Registrado En El Sistema");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteTDC(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            tdcRepository.deleteById(id);
            response.put("Mensaje","El TDC Ha sido Eliminado Del Sistema ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","No se pudo Eliminar El TDC del Sistema ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
