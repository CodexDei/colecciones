package org.codexdei.ejemplos.map;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class EjemploHashMap {

    public static void main(String[] args) {

        Map<String, String> person = new HashMap<>();

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
        //se puede tener una llave null
        person.put(null,"null");

        System.out.println(person);
        //verificar elementos mediante las llaves o keys
        System.out.println("Name: " + person.get("name"));
        System.out.println("LastName: " + person.get("lastName"));
        System.out.println("LastName pattern: " + person.get("patternSurname"));
        System.out.println("Age: " + person.get("age"));
        System.out.println("Email: " + person.get("email"));
        System.out.println(" NullValue: " + person.get(null));

        //Metodos mas importantes
        //Eliminando con los datos de la llave y valor
        boolean deletionStatus = person.remove("patternSurname","King");
        System.out.println("was the key delete?: " + deletionStatus);
        //Eliminando con la llave o key
        String  deletionEmail = person.remove("email");
        System.out.println("Verifying the deletion of: " + deletionEmail);
        System.out.println(person);
        //Si contiene una llave o key
        boolean containsKey  = person.containsKey("patternSurname");
        System.out.println("The person map contains patternSurname?:" + containsKey);
        //si contiene un item o elemento
        boolean containsItem = person.containsValue("Yorking");
        //Es falso porque si bien se agrego en un inicio,
        //AL repetir la llave con un nuevo valor fue sustituido
        System.out.println("The map person contains 'Yorking'?: " + containsItem);
        //values retorna una coleccion
        Collection<String> values = person.values();
        System.out.println("Printing values:");
        for (String v : values){
            System.out.println("V: " + v);
        }
        System.out.println("Printing keys:");
        //Se puede usar un Set pero se imprimiran desordenadas
        //tambien podemos usar un Collection y seran ordenadas
        Set<String> keys = person.keySet();
        for (String k : keys){
            System.out.println("K: " + k);
        }
        //Imprimiendo llaves y valores
        System.out.println("********++ Imprimiendo llaves y valores *********");
        for (Map.Entry<String,String> par : person.entrySet()){
            System.out.println("Keys:" + par.getKey() +" ==> " + "values: " + par.getValue());
        }
        System.out.println("********++ Otra forma Imprimiendo llaves y valores *********");
        for (String k : person.keySet()){
            String v = person.get(k);
            System.out.println("Key: " + k + " ==> " + "value: " + v);
        }
        //Otra forma imprimir llaves y valores con una expresion Lampda
        System.out.println("********++ Imprimiendo llaves y valores con expresion lampda *********");
        person.forEach((k,v) ->
            System.out.println("Key: " + k + " ==> " + "value: " + v)
        );
        //Cuantos elementos tiene el map
        System.out.println("El map 'person' tiene:" + person.size() + " elementos");
        //verificar si contiene elementos
        System.out.println("Contains items?: " + !person.isEmpty());
        //Reemplazar elementos
        //Usa la llave para reemplazar
        System.out.println("********* Reemplazando valores **********");
        person.replace("name","Jorge");
        System.out.println(person);
        //Reemplazando usando el antiguo valor
        //Se usa uno que no existe para mostrar su retorno bolean en consola
        boolean replaceValue = person.replace("name","Jhon","Luis");
        System.out.println("value replace?: " + replaceValue);
    }
}
