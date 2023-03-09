package com.consiti.service;

import com.consiti.dao.EmpleadoDao;
import com.consiti.model.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoService{
    
    @Inject
    private EmpleadoDao empleadoDao;

    @Override
    public List<Empleado> listar() {
        return empleadoDao.findAllEmpleados();
    }

    @Override
    public Empleado encontrarPoId(int id) {
        return empleadoDao.findById(id);
    }

    @Override
    public void guardar(Empleado empleado) {
        empleadoDao.insert(empleado);
    }

    @Override
    public void actualizar(Empleado empleado) {
        empleadoDao.update(empleado);
    }

    @Override
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    public List<Empleado> encontrarPorNombre(String nombres) {
        return empleadoDao.findByNombres(nombres);
    }
    
}
