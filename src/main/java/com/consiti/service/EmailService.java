package com.consiti.service;

import com.consiti.model.Email;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmailService {

    public List<Email> listar();

    public Email encontrarPoId(int id);
    
    public Email encontrarPoEmail(String email);

    public void guardar(Email email);

    public void actualizar(Email email);

    public void eliminar(Email email);
}
