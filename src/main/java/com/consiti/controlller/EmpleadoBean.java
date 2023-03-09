package com.consiti.controlller;

import com.consiti.dto.EmpleadoDto;
import com.consiti.model.Email;
import com.consiti.model.Empleado;
import com.consiti.service.EmailService;
import com.consiti.service.EmpleadoService;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named()
@ApplicationScoped
public class EmpleadoBean {

    @Inject
    EmpleadoService empleadoService;

    @Inject
    EmailService emailService;

    private String campoBuscar;

    public List<Empleado> listaEmpleados;

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String getCampoBuscar() {
        return campoBuscar;
    }

    public void setCampoBuscar(String campoBuscar) {
        this.campoBuscar = campoBuscar;
    }

    public List<Empleado> listar() {
        listaEmpleados = empleadoService.listar();
        return listaEmpleados;
    }

    public List<Empleado> buscar(String nombre) {
        listaEmpleados = empleadoService.encontrarPorNombre(nombre);
        return listaEmpleados;
    }

    public String nuevo() {
        EmpleadoDto e = new EmpleadoDto();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("empleado", e);
        return "/faces/create.xhtml";
    }

    public String guardar(EmpleadoDto empleado) {
        Empleado e = new Empleado();
        Email email = new Email();

        e.setNombres(empleado.getNombres());
        e.setApellidos(empleado.getApellidos());
        e.setTelefono(empleado.getTelefono());

        email.setEmail(empleado.getEmail());
        emailService.guardar(email);

        e.setEmail(email);
        empleadoService.guardar(e);
        return "/faces/index.xhtml";
    }

    public String editar(Empleado empleado) {
        Empleado response = empleadoService.encontrarPoId(empleado.getId());

        EmpleadoDto e = new EmpleadoDto();
        e.setId(response.getId());
        e.setNombres(response.getNombres());
        e.setApellidos(response.getApellidos());
        e.setTelefono(response.getTelefono());
        e.setEmail(response.getEmail().getEmail());

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("empleado", e);
        return "/faces/edit.xhtml";
    }

    public String edit(EmpleadoDto empleado) {
        Empleado e = empleadoService.encontrarPoId(empleado.getId());
        Email email = emailService.encontrarPoId(e.getEmail().getId());

        e.setNombres(empleado.getNombres());
        e.setApellidos(empleado.getApellidos());
        e.setTelefono(empleado.getTelefono());

        email.setEmail(empleado.getEmail());
        emailService.actualizar(email);

        empleadoService.actualizar(e);

        return "/faces/index.xhtml";
    }

    public String eliminar(Empleado empleado) {
        if (empleado != null) {
            emailService.eliminar(empleado.getEmail());
            empleadoService.eliminar(empleado);
        }
        return "/faces/index.xhtml";
    }
}
