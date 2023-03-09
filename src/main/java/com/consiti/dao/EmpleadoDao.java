package com.consiti.dao;

import com.consiti.model.Empleado;
import java.util.List;

public interface EmpleadoDao {

    public List<Empleado> findAllEmpleados();

    public Empleado findById(int id);
    
    public List<Empleado> findByNombres(String nombres);

    public void insert(Empleado empleado);

    public void update(Empleado empleado);

    public void delete(Empleado empleado);
}
