package org.codexdei.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {

    public static void main(String[] args) {

        //Map<String, Object> person = new TreeMap<>();
        //Ordenar de forma descendente
        //(Map<String, Object> person = new TreeMap<>(Comparator.reverseOrder());
        //Map<String, Object> person = new TreeMap<>(Collections.reverseOrder());
        //Map<String, Object> person = new TreeMap<>(( (a,b) -> b.compareTo(a)));

        //ordenar por tamaño del string, menor a mayor
        //Map<String, Object> person = new TreeMap<>(Comparator.comparing(String::length));
        //ordenar por tamaño del string, mayor a menor
        Map<String, Object> person = new TreeMap<>(Comparator.comparing(String::length).reversed());


        //verificar si esta vacio
        System.out.println("Contains items?: " + !person.isEmpty());

        person.put("name","Yorking");
        //si se repite la llave no arroja excepcion pero solo muestra el ultimo dato con esa llave
        person.put("name","Antony");
        //si repito el elemento lo agrega sin problema
        person.put("lastName","King");
        person.put("patternSurname","King");
        person.put("age","28");
        person.put("email","yorkin@gmail.com");

        Map<String,String> address = new TreeMap<>();

        address.put("country","USA");
        address.put("state","California");
        address.put("city","Santa Barbara");
        address.put("street", "One Stree");
        address.put("number","120");
        //Anidacion de TreeMap
        person.put("address",address);

        System.out.println(person);

    }
}
