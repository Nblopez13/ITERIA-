package com.prueba.iteria.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor@NoArgsConstructor
@Table(name = "AFILIADOS")
@Entity
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AFI_ID")
    private Integer id;
    @Column(name = "AFI_NOMBRE",length = 20)
    private String Nombre;
    @Column(name = "AFI_APELLIDOS",length = 30)
    private String Apellido;
    @OneToOne
    private Tipo_Documento tipo_documento;
    @Column(name = "AFI_DOCUMENTO",length = 20)
    private String Documento;
    @Column(name = "AFI_DIRECCION",length = 30)
    private String Direccion;
    @Column(name = "AFI_TELEFONO",length = 20)
    private String Telefono;
    @Column(name = "AFI_MAIL",length = 30)
    private String Mail;
    @Column(name = "AFI_ESTADO",length = 1)
    private int Estado;


}
