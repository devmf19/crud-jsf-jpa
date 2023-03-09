package com.consiti.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleados_datos")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres LIKE :nombre"),
    @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email")})
public class Empleado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    int id;
    
    @Column(name = "nombres")
    String nombres;
    
    @Column(name = "apellidos")
    String apellidos;
    
    @Column(name = "telefono")
    String telefono;
    
    @JoinColumn(name = "email")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("email")
    private Email email;
    
}
