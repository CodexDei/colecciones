package org.codexdei.ejemplos.set;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;
import org.codexdei.ejemplos.modelos.Alumno;

import javax.swing.*;
import java.util.*;

public class EjemploHashSetUnicidad {

    public static void main(String[] args) {

        try{

            //Un HashSet compara es por el hashCode(codigo hash) y luego usa equals para comparar dichos
            //Codigos, asi determina los repetidos
            //Un HashSet no asegura orden, los datos no se muestran en el orden que se agregaron
            //Importante, aunque creemos 2 objetos con los mismos datos no tienen el mismo hashCode porque
            //tienen referencias diferentes, se explica en el siguiente ejemplo
            Set<Alumno> sa = new HashSet<>();

            //Pedro en el siguiente ejemplo no es igual porque son instancias diferentes
            sa.add(new Alumno("Pedro", "Apostol", 3.5));
            sa.add(new Alumno("Pedro", "Apostol", 4.5));
            sa.add(new Alumno("Judas", "False", 1.5));
            sa.add(new Alumno("Juan","Amor", 4.5));
            sa.add(new Alumno("Tomas","Dudon", 2.0));
            sa.add(new Alumno("Pablo","Master", 4.9));
            sa.add(new Alumno(JOptionPane.showInputDialog("Ingrese el nombre del alumno"),
                    JOptionPane.showInputDialog("Ingrese el apellido del alumno"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno"))));

            //EL siguiente ejemplo muestra cuando si serian iguales porque es el mismo objeto
            //Al imprimirlo solo aparecera un objeto paco
            Alumno paco = new Alumno("Paco", "Mendez", 4.3);
            sa.add(paco);
            sa.add(paco);

            System.out.println(sa);

            System.out.println("Iterando usando un for clasico(No funcina para un set, solo para List)");

            //Por ello tranformamos el set a List
            List<Alumno> listaAlumno = sa.stream().toList();

            for (int i = 0; i < listaAlumno.size(); i++){

                System.out.println(listaAlumno.get(i));
            }

            System.out.println("***************************************************");

            //Formas de iterar un Set
            System.out.println("Iterando con un forEach");
            for (Alumno a : sa){
                System.out.println(a);
            }

            System.out.println("************* USANDO UN STREAM FOREACH ******************");
            sa.forEach(System.out::println);

            System.out.println("Iterar usando un Iterator");

            Iterator<Alumno> it = sa.iterator();

            while (it.hasNext()){

                Alumno alumno = it.next();
                System.out.println(alumno.getNombre());
            }

            System.out.println("Mostrando solo los alumnos que aprobaron:");

            Iterator<Alumno> itAprobado = sa.iterator();

            while (itAprobado.hasNext()){

                Alumno alumno = itAprobado.next();
                if (alumno.getNota() >= 3){
                    System.out.println("El alumno '" + alumno.getNombre() + "'" + " aprobo la materia");
                }
            }




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
