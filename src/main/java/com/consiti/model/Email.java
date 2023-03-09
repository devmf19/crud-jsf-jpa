package com.consiti.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleados_emails")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findById", query = "SELECT e FROM Email e WHERE e.id = :id"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email")})
public class Email implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_email")
    private int id;
    
    @Column
    private String email;
    
    @OneToOne(mappedBy = "email", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("email")
    private Empleado empleado;
}
