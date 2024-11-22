package org.codexdei.ejemplos.map;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {

    public static void main(String[] args) {

        Map<String, String> persona = new HashMap<>();

        persona.put("nombre","Yorking");
        //si se repite la llave no arroja excepcion pero solo muestra el ultimo dato con esa llave
        persona.put("nombre","Antony");
        //si repito el elemento lo agrega sin problema
        persona.put("apellido","King");
        persona.put("apellidoPaterno","King");
        persona.put("edad","28");
        persona.put("email","yorkin@gmail.com");
        //se puede tener una llave null
        persona.put(null,"nulo");

        System.out.println(persona);
        //verificar elementos mediante las llaves o keys
        System.out.println("Nombre: " + persona.get("nombre"));
        System.out.println("Apellido: " + persona.get("apellido"));
        System.out.println("Apellido Paterno: " + persona.get("apellidoPaterno"));
        System.out.println("Edad: " + persona.get("edad"));
        System.out.println("Email: " + persona.get("email"));
        System.out.println("Dato nulo: " + persona.get(null));

        //Metodos mas importantes 
    }
}
