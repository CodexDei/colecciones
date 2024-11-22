package org.codexdei.ejemplos.list;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;
import org.codexdei.ejemplos.modelos.Alumno;

import javax.swing.*;
import java.util.*;

public class EjemploLinkedList {

    public static void main(String[] args) {

        try{

            LinkedList<Alumno> enlazada = new LinkedList<>();

            Alumno alumnoX = new Alumno(JOptionPane.showInputDialog("Ingrese el nombre del alumno"),
                    JOptionPane.showInputDialog("Ingrese el apellido del alumno"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno")));

            //Metodos mas importantes
            //Metodo size para mostrar la cantidad de elementos de la lista
            System.out.println("Cantidad de elementos de la lista al crearla: " + enlazada.size());
            //verificar si la lista esta vacia
            boolean estaVacia = enlazada.isEmpty();
            System.out.println("La lista esta vacia?:" + estaVacia);
            System.out.println("Indice 0: " + enlazada.peek());//obtiene el primer elemento de la lista pero no lanza excepcion sino existe

            enlazada.add(new Alumno("Pedro", "Apostol", 3.5));
            //Se coloca casi igual, solo cambia la nota para demostrar como funciona 'thenComparing' abajo
            enlazada.add(new Alumno("Pedro", "Apostol", 2.1));
            enlazada.add(new Alumno("Andres", "Apostol", 4.5));
            enlazada.add(new Alumno("Judas", "False", 1.5));
            enlazada.add(new Alumno("Juan","Amor", 4.5));
            enlazada.add(new Alumno("Tomas","Dudon", 2.0));
            enlazada.addFirst(new Alumno("Simon","Celote",3.7));
            enlazada.addLast(new Alumno("Maria","Purisima",4.2));
            enlazada.add(new Alumno("Jorge","Peregrino",4.9));
            enlazada.add(alumnoX);

            System.out.println("Size: " + enlazada.size());
            enlazada.forEach(System.out::println);
            System.out.println("Indice: " + enlazada.peekFirst());//hace lo mismo que peek(explicado al inicio)
           // System.out.println("Indice 100: " + enlazada.get(100));//sino existe el indice lanza excepcion

            //removeLast=Elimina pero antes retorna el elemento y arroja excepcion sino existe
            Alumno x = enlazada.removeLast();
            //Eliminar por indice
            enlazada.remove(4);
            System.out.println("****************** Imprimiendo la lista *******************");
            enlazada.forEach(System.out::println);
            System.out.println("Elemento extraido y eliminado: " + x);
            //Elimina pero antes retorna el elemento y arroja null sino existe
            Alumno y = enlazada.pollFirst();
            System.out.println("Elemento extraido y eliminado: " + y);
            System.out.println("****************** Imprimiendo la lista *******************");
            enlazada.forEach(System.out::println);
            //similar a remove en su comportamiento, lanza excepcion
            Alumno z = enlazada.pop();
            System.out.println("Elemento extraido y eliminado: " + z);
            System.out.println("****************** Imprimiendo la lista *******************");
            enlazada.forEach(System.out::println);
            //Se puede eliminar tambien proporcionando los datos del elemento
            enlazada.remove(new Alumno("Maria","Purisima",4.2));
            System.out.println("****************** Imprimiendo la lista *******************");
            enlazada.forEach(System.out::println);

            //Para verificar el indice de un elemento de la lista
            Alumno alumnoIndice = new Alumno("Jorge","Peregrino",4.9);
            System.out.println("Indice del elemento Jorge: " + enlazada.indexOf(alumnoIndice));

            //Modificar elementos, se indica indice y nueva info
            enlazada.set(3, new Alumno("Marye","BeatifulGirl",4.9));
            System.out.println("****************** Imprimiendo la lista *******************");
            enlazada.forEach(System.out::println);

            //List Iterator
            ListIterator<Alumno> iteratorAlumnos = enlazada.listIterator();
            System.out.println("********** Iterando hacia adelante **************");
            while (iteratorAlumnos.hasNext()){

                Alumno a = iteratorAlumnos.next();
                System.out.println(a);
            }
            System.out.println("********** Iterando hacia atras **************");
            while (iteratorAlumnos.hasPrevious()){
                Alumno a = iteratorAlumnos.previous();
                System.out.println(a);
            }
            System.out.println("************** Modificando mientras se Itera...");
            //Reiniciamos el iterator
            iteratorAlumnos = enlazada.listIterator();

            while (iteratorAlumnos.hasNext()){

                Alumno a = iteratorAlumnos.next();

                if (a.equals(new Alumno("Andres", "Apostol",4.5))){
                    iteratorAlumnos.set(new Alumno("Pablo","Apostolon",5.0));
                }
                if(a.equals(new Alumno("Pedro","Apostol",2.1))){
                    iteratorAlumnos.remove();
                }
                System.out.println(a);
            }
            System.out.println("****************** Imprimiendo la lista *******************");
            enlazada.forEach(System.out::println);



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
