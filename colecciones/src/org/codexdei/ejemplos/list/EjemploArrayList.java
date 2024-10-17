package org.codexdei.ejemplos.list;

import org.codexdei.ejemplos.excepciones.IngresoDatosException;
import org.codexdei.ejemplos.modelos.Alumno;
import org.codexdei.ejemplos.modelos.Persona;

import javax.swing.*;
import java.util.*;

public class EjemploArrayList {

    public static void main(String[] args) {

        try{

            List<Alumno> la = new ArrayList<>();

            Alumno alumnoX = new Alumno(JOptionPane.showInputDialog("Ingrese el nombre del alumno"),
                    JOptionPane.showInputDialog("Ingrese el apellido del alumno"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno")));

            //Metodos mas importantes
            //Metodo size para mostrar la cantidad de elementos de la lista
            System.out.println("Cantidad de elementos de la lista al crearla: " + la.size());
            //verificar si la lista esta vacia
            boolean estaVacia = la.isEmpty();
            System.out.println("La lista esta vacia?:" + estaVacia);

            la.add(new Alumno("Pedro", "Apostol", 3.5));
            //Se coloca casi igual, solo cambia la nota para demostrar como funciona 'thenComparing' abajo
            la.add(new Alumno("Pedro", "Apostol", 2.1));
            la.add(new Alumno("Andres", "Apostol", 4.5));
            la.add(new Alumno("Judas", "False", 1.5));
            la.add(new Alumno("Juan","Amor", 4.5));
            la.add(new Alumno("Tomas","Dudon", 2.0));
            //el numero indica la posicion(index) en la que queremos colocarlo
            //NO reemplaza al elemento sino que ocupa su puesto y lo desplaza al siguiente index
            la.add(0,new Alumno("Pablo","Master", 4.9));
            //set reemplaza el dato que este en el index que se indique, en este caso cero
            la.set(0, new Alumno("Pablo","Master", 4.8));
            la.add(alumnoX);

            //lo repetimos para mostrar cuantos elementos hay despues de agregar
            System.out.println("Cantidad de elementos de la lista despues de agregar: " + la.size());
            //comprobamos si esta vacia, deberia ser true
            estaVacia = la.isEmpty();
            System.out.println("La lista esta vacia?:" + estaVacia);
            //Eliminando un elemento de la lista
            la.remove(new Alumno("Judas","False",1.5));
            //Eliminando por index
            la.remove(4);
            //cuantos elementos hay ahora
            System.out.println("Ahora la cantidad de elementos es: " + la.size());
            //imprimiento la lista
            la.forEach(System.out::println);
            //contains para indicar si la lista contiene determinado elemento
            boolean b = la.contains(new Alumno("Judas","False",1.5));
            System.out.println("La lista contiene a 'Judas'?: " + b);
            b = la.contains(new Alumno("Pablo", "Master",4.8));
            System.out.println("La lista contiene a 'Pablo'?: " + b);
            //Transformar la lista en un arreglo
            System.out.println("*************** De lista a Arreglo **********************");
            System.out.println("Enumerando la lista");

            Object arreglo[] = la.toArray();

            for (int i = 0; i < arreglo.length; i++){
                System.out.println( (i+1) + ". " + arreglo[i]);
            }

            System.out.println("***** Obteniendo un elemento de la lista *******");
            //get para obtener un elemento
            System.out.println("El elemento 3 de la lista es: " + la.get(2));

            System.out.println("********* Ordenando el Array *********");
            //metodo mas eficiente de ordenamiento
            la.sort(Comparator.comparing(Alumno::getApellido).thenComparing(Alumno::getNombre).thenComparing(Alumno::getNota));
            System.out.println(la);

            List<Alumno> alExt = new ArrayList<>();

            alExt.add(new Alumno("Jorge", "Castillo",4.0));
            alExt.add(new Alumno("Marye", "Mora",4.0));
            alExt.add(new Alumno("Samy", "Acosta",5.0));
            //las listas se comparan con el metodo 'equals'
            boolean sonIguales = la.equals(alExt);
            System.out.println("Lista Alumnos nacionales:\n" + la + "\nLista alumnos internacionales:\n" + alExt);
            System.out.println("la lista Alumnos nacionales es igual a la lista alumnos internacionales?: " + sonIguales);
            //copiar un array,se declara el array y en el constructor se coloca el array a copiar
            List<Alumno> alAprobados = new ArrayList<>(la);
            System.out.println("**** Mostrando el ArrayList copiado **************");
            alAprobados.forEach(System.out::println);
            sonIguales = la.equals(alAprobados);
            System.out.println("Los alumnos de la lista 1 y 3 son iguales?:" + sonIguales);
            //obtener el indice de la primer aparicion de un elemento buscando desde el primero al ultimo
            //Sino lo encuentra devuelve un -1, porque no esta en la lista
            int indiceBusqueda = alExt.indexOf(new Alumno(JOptionPane.showInputDialog(null,"Ingrese el nombre del alumno"
                    ,"Ingrese el alumno a buscar en la lista" , JOptionPane.INFORMATION_MESSAGE),
                    JOptionPane.showInputDialog("Ingrese el apellido del alumno"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno"))));

            if (indiceBusqueda >= 0){
                System.out.println("El alumno '" + alumnoX.getNombre() + "' esta en el index: " + indiceBusqueda);

            }else {
                System.out.println("El alumno '" + alumnoX.getNombre() + "' NO esta en la lista");
            }

            //obtener el indice de la primer aparicion de un elemento buscando desde el ultimo al primero
            indiceBusqueda = alExt.lastIndexOf(new Alumno("Samy", "Acosta",5.0));
            System.out.println("El/la alumno 'Samy Acosta' esta en el index: " + indiceBusqueda);

            //metodo para obtener una porcion del arraylist
            System.out.println("Porcion de la lista 1: " + la.subList( 0, la.size() - 2 ));

            //Eliminar todos los elementos de una lista
            alAprobados.clear();
            System.out.println("La lista de aprobados esta vacia?: " + alAprobados.isEmpty());

            //usar Iterator para recorrer el array
            Iterator<Alumno> itAl = la.iterator();

            while (itAl.hasNext()){

                Alumno alumno = itAl.next();

                if (alumno.getNota() >= 3){

                    alAprobados.add(alumno);
                }
            }
            System.out.println("los alumnos aprobados son:\n");

            ListIterator itList = alAprobados.listIterator();
            System.out.println("**** Recorriendo primero la lista hacia atras *********");
            //Si hacemos esto no mostrara nada o mostrara un error sino se usa hasPrevios

                if(itList.hasPrevious()){

                    while (itList.hasPrevious()){

                        System.out.println(itList.previous());
                    }

                }else {
                    System.out.println("no hay elementos previos");
                }


            System.out.println("******** Reocorriendo la lista de adelante hacia atras *****");
            while(itList.hasNext()){

                System.out.println(itList.next());
            }

            System.out.println("******** Reocorriendo la lista de atras hacia adelante *****");

            //Recorriendo la lista hacia atras

            while (itList.hasPrevious()){

                System.out.println(itList.previous());
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
