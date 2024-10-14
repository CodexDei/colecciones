package org.codexdei.ejemplos.modelos;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;
import java.util.Objects;

public class Alumno extends Persona {

    private Double nota;

    public Alumno(String nombre, String apellido, Double nota) throws IngresoDatosException {
        super(nombre, apellido);

        if (nota < 0) {
            throw new IngresoDatosException("La nota no puede ser menos a cero");
        }

        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;  // Usa equals de Persona para nombre y apellido
        Alumno alumno = (Alumno) o;
        return Objects.equals(nota, alumno.nota);  // Compara la nota también
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nota);  // Usa hashCode de Persona y añade nota
    }

    @Override
    public String toString() {
        return super.toString() + "Nota: " + nota + "\n";
    }
}
