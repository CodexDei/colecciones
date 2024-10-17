package org.codexdei.ejemplos.set;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;
import org.codexdei.ejemplos.modelos.Alumno;
import org.codexdei.ejemplos.modelos.Persona;

import javax.swing.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreesetComparable{

    public static void main(String[] args) {

        try{

            //Si detecta un valor repetido lo elimina como ocurre con todo Set, lo hace
            //mediante comparTo
            //Hay que implementar Comparable en la clase para poder comparar los objetos
            //En el constructor podemos modificar el tipo de dato a comparar y
            //Establecer por orden ascendente o descendente
            //El valor que determinamos en el comparTo es el que usara para determinar los repetidos
            //por lo que si elegimos 'nota' como valor a comparar si hay alguna nota repetida
            //elimina todo registro que tenga la misma nota
            //ver el siguiente ejemplo para comprobarlo

            System.out.println("************** Ordenando con expresion Lampda *****************+");

            Set<Alumno> sa = new TreeSet<>((a,b) -> a.getNota().compareTo(b.getNota()));

            sa.add(new Alumno("Pedro", "Apostol", 3.5));
            sa.add(new Alumno("Judas", "False", 3.5));
            sa.add(new Alumno("Juan","Amor", 4.5));
            sa.add(new Alumno("Tomas","Dudon", 3.0));
            sa.add(new Alumno("Pablo","Master", 4.9));
            sa.add(new Alumno(JOptionPane.showInputDialog("Ingrese el nombre del alumno"),
                    JOptionPane.showInputDialog("Ingrese el apellido del alumno"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno"))));

            System.out.println(sa);

            System.out.println("************* Ordenando con Comparator - comparing()");
            Set<Alumno> alumnosExtranjeros = new TreeSet<>(Comparator.comparing(
                                Alumno::getApellido).thenComparing(Alumno::getNombre).thenComparing(Alumno::getNota));

            alumnosExtranjeros.add(new Alumno("Jeysson", "Oyola",3.7));
            alumnosExtranjeros.add(new Alumno("Robinson","Lopez",4.0));
            alumnosExtranjeros.add(new Alumno("Melvin","Cayama",4.8));
            alumnosExtranjeros.add(new Alumno("Miguel","Cayama",4.8));
            alumnosExtranjeros.add(new Alumno("Miguel","Cayama",2.0));
            alumnosExtranjeros.add(new Alumno("Miguel","Cayama",4.7));

            System.out.println(alumnosExtranjeros);

        }catch (IngresoDatosException e){

            System.out.println("El dato no puede ser nulo: " + e.getMessage());
            e.printStackTrace();
            main(args);

        } catch (NullPointerException e){

            System.err.println("El dato no puede ser nulo: " + e.getMessage());
            e.printStackTrace();
            main(args);

        } catch (NumberFormatException e){

            System.err.println("El formato numerico es invalido: " + e.getMessage());
            e.printStackTrace();
            main(args);
        }
    }
}
