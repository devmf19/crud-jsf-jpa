package com.consiti.service;

import com.consiti.dao.EmailDao;
import com.consiti.model.Email;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmailServiceImpl implements EmailService {

    @Inject
    private EmailDao emailDao;

    @Override
    public List<Email> listar() {
        return emailDao.findAllEmails();
    }

    @Override
    public Email encontrarPoId(int id) {
        return emailDao.findById(id);
    }

    @Override
    public void guardar(Email email) {
        emailDao.insert(email);
    }

    @Override
    public void actualizar(Email email) {
        emailDao.update(email);
    }

    @Override
    public void eliminar(Email email) {
        emailDao.delete(email);
    }

    @Override
    public Email encontrarPoEmail(String email) {
        return emailDao.findByEmail(email);
    }

}
