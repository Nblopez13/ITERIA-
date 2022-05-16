package com.prueba.iteria.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@Table(name = "TIPO_DOCUMENTO")
@Entity
public class Tipo_Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "TDC_ID",length = 2)
    private String TipoDocumento;
    @Column(name = "TDC_NOMBRE",length = 20)
    private String Nombre;
    @Column(name = "TDC_ESTADO",length = 1)
    private int Estado;
}
