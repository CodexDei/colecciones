package org.codexdei.ejemplos.list;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;
import org.codexdei.ejemplos.modelos.Alumno;
import org.codexdei.ejemplos.modelos.Persona;

import javax.swing.*;
import java.util.*;

public class EjemploListComparableComparator {

    public static void main(String[] args) {

        try{

            List<Alumno> sa = new ArrayList<>();

            //Pedro en el siguiente ejemplo no es igual porque son instancias diferentes
            sa.add(new Alumno("Pedro", "Apostol", 3.5));
            sa.add(new Alumno("Andres", "Apostol", 4.5));
            sa.add(new Alumno("Judas", "False", 1.5));
            sa.add(new Alumno("Juan","Amor", 4.5));
            sa.add(new Alumno("Tomas","Dudon", 2.0));
            sa.add(new Alumno("Pablo","Master", 4.9));
            sa.add(new Alumno("Pablo","Master", 4.8));
            sa.add(new Alumno(JOptionPane.showInputDialog("Ingrese el nombre del alumno"),
                    JOptionPane.showInputDialog("Ingrese el apellido del alumno"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno"))));

            System.out.println("Iterando usando un for clasico");

            for (int i = 0; i < sa.size(); i++){

                System.out.println(sa.get(i));
            }

            System.out.println("***************************************************");

            //Formas de iterar un Set
            System.out.println("Iterando con un forEach");
            for (Alumno a : sa){
                System.out.println(a);
            }

            System.out.println("************* USANDO UN STREAM FOREACH ******************");
            sa.forEach(System.out::println);

            System.out.println("**************** Iterar usando un Iterator ******************");

            Iterator<Alumno> it = sa.iterator();

            while (it.hasNext()){

                Alumno alumno = it.next();
                System.out.println(alumno.getNombre());
            }

            System.out.println("********** Mostrando solo los alumnos que aprobaron: *****************");

            Iterator<Alumno> itAprobado = sa.iterator();

            while (itAprobado.hasNext()){

                Alumno alumno = itAprobado.next();
                if (alumno.getNota() >= 3){
                    System.out.println("El alumno '" + alumno.getNombre() + "'" + " aprobo la materia");
                }
            }

            System.out.println("******************* Alumnos Reprobados *******************");

            Iterator<Alumno> itRepro = sa.iterator();

            while (itRepro.hasNext()){

                Alumno alumno = itRepro.next();

                if (alumno.getNota() < 3){
                    System.out.println("El alumno '" + alumno.getNombre() + " " + alumno.getApellido() +
                                        "' Reprobo la materia");
                }
            }

            System.out.println("**************** Ordenando un ArrayList con Expresion lampda y compareTo ***************");
            System.out.println("ordenando por Nota:");
            sa.sort( (a,b) -> b.getNota().compareTo(a.getNota()));
            System.out.println(sa);

            System.out.println("************ Ordenando usando Comparing");
            //ordenando usando Comparator. comparing
            //ordenando usando una referencia a metodo(::)
            //Es mas legible y modular que la ordenancion lampda anterior
            //thenComparing crea un segundo criterio de comparacion, es decir
            //ordenamos por apellido y si dos alumnos tienen el mismo apellido se ordenan por nombre
            //agregamos otro thenComparing para un tercer criterio: la nota, se pueden agregar los que se necesiten
            sa.sort(Comparator.comparing(Alumno::getApellido).thenComparing(Alumno::getNombre).thenComparing(Alumno::getNota));
            System.out.println(sa);




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
