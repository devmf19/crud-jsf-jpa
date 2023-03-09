package com.consiti.service;

import com.consiti.model.Empleado;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmpleadoService {

    public List<Empleado> listar();

    public Empleado encontrarPoId(int id);

    public List<Empleado> encontrarPorNombre(String nombres);

    public void guardar(Empleado empleado);

    public void actualizar(Empleado empleado);

    public void eliminar(Empleado empleado);
}
