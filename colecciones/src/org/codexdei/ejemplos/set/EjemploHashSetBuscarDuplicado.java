package org.codexdei.ejemplos.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado {

    public static void main(String[] args) {

        String[] peces = {"nicuro", "bagre", "robalo", "cachama", "bagre"};

        //forma rapida de transformar un array a un set
        //Set<String> hs = new HashSet<>(List.of(peces));
        System.out.print("Peces:");
        for (String pez: peces){
            System.out.print(pez + " ");
        }
        System.out.println();

        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();
        //aplicando add con un for
        for(String pez : peces){

            //Detecta cuando hay un elemento repetido, puesto que un add arroja un boolean
            //como ingresamos al if si la expresion es falsa es decir entra cuando hay un repetido
            //porque un set no acepta repetidos
            if (!unicos.add(pez)){
                System.out.println("Elemento repetido: " + pez);
                duplicados.add(pez);
            }
        }
        //Quitar todos los repetidos en una sola linea de codigo sin for
        unicos.removeAll(duplicados);

        System.out.println("Cantidad de elementos unicos: " + unicos.size() + unicos);
        System.out.println("Cantidad de elementos duplicados: " + duplicados.size() + duplicados);


    }

}
