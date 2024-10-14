package org.codexdei.ejemplos.modelos;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;

import java.util.Objects;

abstract public class Persona {

    protected String nombre;
    protected String apellido;

    public Persona(){

    }

    public Persona(String nombre, String apellido) throws IngresoDatosException {

        if (nombre == null || nombre.trim().isEmpty()){

            throw new IngresoDatosException("El nombre no puede ser nulo o vacio");
        }
        if(apellido == null || apellido.trim().isEmpty()){

            throw new IngresoDatosException("El apellido no puede ser nulo o vacio");
        }

        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre(){

        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    public String toString(){

        return "Nombre: " + nombre + "  " +
               "Apellido: " + apellido + "  ";
    }
}
