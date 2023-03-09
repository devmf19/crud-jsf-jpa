package com.consiti.dao;

import com.consiti.model.Email;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Local
public class EmailDaoImpl implements EmailDao {

    @PersistenceContext(unitName = "EmpleadosPU")
    EntityManager em;

    @Override
    public List<Email> findAllEmails() {
        return em.createNamedQuery("Email.findAll").getResultList();
    }

    @Override
    public Email findById(int id) {
        return em.find(Email.class, id);
    }

    @Override
    public void insert(Email email) {
        em.persist(email);
    }

    @Override
    public void update(Email email) {
        em.merge(email);
    }

    @Override
    public void delete(Email email) {
        em.remove(em.merge(email));
    }

    @Override
    public Email findByEmail(String email) {
        List<Email> emails = findAllEmails()
                .stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
        if(emails.isEmpty()){
            return null;
        }
        return emails.get(0);
    }
}
