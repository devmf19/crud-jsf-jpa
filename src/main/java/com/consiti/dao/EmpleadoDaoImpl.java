package com.consiti.dao;

import com.consiti.model.Email;
import com.consiti.model.Empleado;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Local
public class EmpleadoDaoImpl implements EmpleadoDao {

    @PersistenceContext(unitName = "EmpleadosPU")
    EntityManager em;

    @Override
    public List<Empleado> findAllEmpleados() {
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    @Override
    public Empleado findById(int id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public void insert(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public void update(Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void delete(Empleado empleado) {
        em.remove(em.merge(empleado));
    }

    @Override
    public List<Empleado> findByNombres(String nombres) {
        Query query =  em.createNamedQuery("Empleado.findByNombres", Empleado.class);
        query.setParameter("nombre", "%" + nombres + "%");
        return query.getResultList(); 
    }

}
