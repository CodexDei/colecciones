package org.codexdei.ejemplos.set;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeset {

    public static void main(String[] args) {

        //Treset ordena los elementos sin usar sort, ordena segun el codigo ASCII
        //como todo Set no acepta repetidos

        //compareTo para invertir el ordenamiento
        Set<String> ts = new TreeSet<>((a,b) -> b.compareTo(a));

        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");

        System.out.println(ts);

        //Implementamos la clase Collections para llamar el metodo reverseOrder
        Set<Integer> ts2 = new TreeSet<>(Collections.reverseOrder());

        ts2.add(4);
        ts2.add(3);
        ts2.add(5);
        ts2.add(1);
        ts2.add(2);

        System.out.println(ts2);

        //otra forma de invertir el orden, usando Comparator.reverderOrden
        Set<Character> ts3 = new TreeSet<>(Comparator.reverseOrder());

        ts3.add('A');
        ts3.add('M');
        ts3.add('O');
        ts3.add('R');

        System.out.println(ts3);
    }
}
