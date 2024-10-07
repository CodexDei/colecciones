package org.codexdei.ejemplos.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class EjemploHashSet {

    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();

        //el metodo "add" devuelve un boolean por ello la impresion
        //muestra un true
        System.out.println(hs.add("Uno"));
        System.out.println(hs.add("Dos"));
        System.out.println(hs.add("Tres"));
        System.out.println(hs.add("Cuatro"));
        System.out.println(hs.add("Cinco"));
        System.out.println("***********************");
        //Para ordenar un set tendriamos que crear una lista y convertirlo
        List lista = new ArrayList<>(hs);
        //el sort de Collections nos permite ordenar
        Collections.sort(lista);
        System.out.println("Lista Ordenada:");
        System.out.println(hs);
        System.out.println("********************");
        //impresion de la coleccion hs para mostrar que
        //los set no tienen un orden
        System.out.println(hs);
        //los set no permiten agregar repetidos
        //lo siguiente imprimira false
        System.out.println("Un set agrega un elemento duplicado?: " + hs.add("Tres"));
        //Al imprimir nuevamente vemos la misma cantidad de elementos
        System.out.println(hs);

    }
}
