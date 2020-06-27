package modelo;

import com.fasterxml.jackson.annotation.JsonTypeId;
import persistencia.EntidadProyecto;

import java.text.ParseException;
import java.util.Date;

public abstract class Proyecto {

    protected long id;
    protected String nombre;
    protected RegistroDeDatos registroDeDatos;
    protected String tipoDeProyecto;
    public Proyecto(long id, String nombre) {
        this.id = id;
        this.registroDeDatos = new RegistroDeDatos(nombre);
    }
    public void modificar(Proyecto proyecto){
        this.nombre = proyecto.getNombre();
        this.tipoDeProyecto = proyecto.getTipoDeProyecto();
    }
    public long getId() {
        return id;
    }

    public String getTipoDeProyecto() { return tipoDeProyecto; }

    public String getNombre() {
        return registroDeDatos.getNombre();
    }
    public String getDescripcion() { return this.registroDeDatos.getDescripcion();}
    public Date getFechaDeInicio() { return this.registroDeDatos.getFechaDeInicio();}
    public Date getFechaDeFinalizacion() { return this.registroDeDatos.getFechaDeFinalizacion();}

    public void setNombre(String nombre) { this.registroDeDatos.setNombre(nombre);}
    public void setDescripcion(String descripcion) { this.registroDeDatos.setDescripcion(descripcion); }
    public void setFechaDeInicio(String fechaDeInicio) throws ParseException {
        this.registroDeDatos.setFechaDeInicio(fechaDeInicio);
    }
    public void setFechaDeFinalizacion(String fechaDeFinalizacion) throws ParseException {
        this.registroDeDatos.setFechaDeFinalizacion(fechaDeFinalizacion);
    }

    public String getTipoDeProyecto() { return tipoDeProyecto; }


    public EntidadProyecto obtenerEntidad() {
        return new EntidadProyecto(id, nombre, tipoDeProyecto);
    }
}
