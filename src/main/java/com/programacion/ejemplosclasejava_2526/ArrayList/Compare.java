/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author josem
 */
public class Compare {

    /* Se definen los arrays estáticos, que son las estructuras utilizadas
    hasta ahora para agrupar datos iguales */

    static int arrayEnteros [] = new int [5];
    static String arrayCadenas [] = new String [10];
    boolean [] arrayBooleano = new boolean [30];
    Persona [] arrayPersonas = new Persona [28];

    /* Ahora se define una nueva estructura de datos (Arrays dinámicos) como
    Listas (ArrayList) */

    static ArrayList<Integer> listaEnteros = new ArrayList<Integer>();
    static ArrayList<String> listaCadenas = new ArrayList<String>();
    ArrayList<Boolean> listaBooleanos = new ArrayList<Boolean>();
    static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    
    public static void main(String[] args) {
     
        /*Inicializamos un ejemplo de arrayEnteros*/
        /*Hemos visto en la pizarra de clase una nueva forma para implementar 
        el bucle for que es equivalente a la que ya se conocía*/
        
        // Forma conocida hasta ahora
        for (int i =0; i<arrayEnteros.length;i++)
        {
            arrayEnteros[i]=i;
        }
        
        // Nueva forma para leer los datos introducidos. El formato sería:
        // for (tipoDato nombreAuxiliar : Array/Lista){}
        for(int entero : arrayEnteros)
        {
            System.out.println(entero);
        }
        
        // Añadimos información a las listas para trabajar con ellas posteriormente
        listaCadenas.add("Hola");
        listaCadenas.add("Adios");
        listaCadenas.add("Bienvenido");
        listaCadenas.add("Chao");
        listaCadenas.add("Hasta luego");
        
        listaEnteros.add(10);
        listaEnteros.add(100);
        listaEnteros.add(5);
        listaEnteros.add(1);
        listaEnteros.add(7);
        
        
        /*Se inicializa una listaPersonas */
        listaPersonas.add(new Persona("Diego", "Lopez", "1111111A"));
        listaPersonas.add(new Persona("Francisco", "Guerrero", "22222222B"));
        listaPersonas.add(new Persona("Francisco", "Mulero", "333333333C"));
        listaPersonas.add(new Persona("Nerea", "Sanchez", "444444444D"));
        listaPersonas.add(new Persona("Eduardo", "Reverte", "55555555E"));
        listaPersonas.add(new Persona("Miguel", "Re", "666666666F"));
        listaPersonas.add(new Persona("Antonio David", "Mulero", "777777777G"));
        listaPersonas.add(new Persona("Adrian", "Rosel", "88888888H"));
        listaPersonas.add(new Persona("Josue", "Mollo", "999999999I"));
        listaPersonas.add(new Persona("Javier", "Padilla", "000000000J"));
        
        //Para saber la longitud de la lista, hacemos uso de lista.size() -- equivalente a array.length
        System.out.println("La longitud de la lista listaCadenas es: " + listaCadenas.size());
        
        //Para saber el último índice de la lista, hacemos uso de lista.lastIndexOf() 
        String bienvenido = "Bienvenido";
        System.out.println("El ultimo indice de la lista es: " + listaCadenas.lastIndexOf(bienvenido));
        
        // Modificar una posición concreta de la lista lista.set(index, valor)
        listaCadenas.set(4,"Nos vemos pronto");
        
        // Utilizamos el lista.get(index) para obtener la posición de la lista index 
        System.out.println(listaCadenas.get(4));
        
        // Se pueden eliminar elementos de la lista en una posición determinada
        listaCadenas.remove(0); // Elimina "Hola", ya que está definida en la primera posición
        
        // Como se ha eliminado la primera posición en la sentencia anterior, el primer valor
        // de la lista pasa a ser "Adios". Esta posición ("Adios" pasa a ser eliminada con el método
        // removeFirst()
        listaCadenas.removeFirst();
        
        System.out.println("Primer valor es: " + listaCadenas.get(0));
        
        // En una lista dinámica podemos añadir elementos en las diferentes posiciones, 
        // desplazando el resto de elementos
        listaCadenas.addFirst("Zapatillas");
        System.out.println("Primer valor es: " + listaCadenas.get(0));
        imprimirLista(listaCadenas);
        
        // Añadimos un dato a la lista en la posición indicada (en este caso 2)
        // Implica directamente cambio en la dimensión de la lista
        listaCadenas.add(2, "Primero");
        System.out.println("El tamaño total de la lista es: " + listaCadenas.size());
        imprimirLista(listaCadenas);
        
        listaCadenas.add(5, "Ultimo"); // Si aquí ponemos un 6 (en lugar de un 5)
        // daría un error porque el 6 está más allá de la última posición (que es 5)
        imprimirLista(listaCadenas);
        
        // Esto permite apuntar a la primera posición de listaCadenas desde listaCopiada
        ArrayList<String> listaCopiada = listaCadenas;
        System.out.println("Lista Copiada");
        imprimirLista(listaCopiada);
        
        // El isEmpty() nos dará true si la lista está vacía y false si la lista tiene algún dato
        System.out.println("listaCadenas está vacía?: " + listaCadenas.isEmpty());

        // En este caso son copias de datos completas, que se almacenan en posiciones
        // de memoria diferentes. Los cambios aplicados ahora en listaEnteros no afectan
        // a copiaEnteros
        ArrayList<Integer> copiaEnteros = new ArrayList<Integer>(listaEnteros);
        
        // REVISAR clone
        ArrayList<Integer> listaEnterosClonada = (ArrayList<Integer>) listaEnteros.clone();
        // Para poder hacer uso del método clone() se necesita hacer un casting explicito
        // Sería lo mismo que hacer listaEnterosClonada = listaEnteros; // ya que apunta a
        // las mismas posiciones de memoria en listaEnterosClonada que listaEnteros
        
        // REVISAR sort()
        System.out.println("****** Funcionamiento sort() - listaEnteros ordenada a continuación ******");
        System.out.println("listaEnteros desordenada a continuación ******");
        imprimirLista(listaEnteros);
        
        System.out.println("listaEnteros ordenada ASC a continuación ******");
        // A continuación se muestran tres métodos para ordenar de forma ascendente
        //listaEnteros.sort(Integer::compareTo); // ordena por orden ascendente la lista
        //Collection.sort(listaEnteros);
        listaEnteros.sort(null);
        imprimirLista(listaEnteros);
        
        
        System.out.println("listaEnteros ordenada DESC a continuación ******");
        listaEnteros.sort(Comparator.reverseOrder()); // ordena por orden ascendente la lista
        //Collections.sort(listaEnteros, Collection.reverseOrder());
        imprimirLista(listaEnteros);
        
        System.out.println("****** Funcionamiento sort() - listaPersonas original ******");
        imprimirLista(listaPersonas);
        
        System.out.println("****** Funcionamiento sort() - listaPersonas ordenada por Apellido ASC ******");
        listaPersonas.sort(Comparator.comparing(Persona::getApellido));
        imprimirLista(listaPersonas);
        
        System.out.println("****** Funcionamiento sort() - listaPersonas ordenada por Apellido DESC ******");
        listaPersonas.sort(Comparator.comparing(Persona::getApellido).reversed());
        imprimirLista(listaPersonas);
        
        System.out.println("****** Funcionamiento sort() - listaPersonas ordenada por Nombre ******");
        listaPersonas.sort(Comparator.comparing(Persona::getNombre));
        imprimirLista(listaPersonas);
        
        System.out.println("****** Funcionamiento sort() - listaPersonas ordenada por Apellido y después Nombre ******");
        listaPersonas.sort(Comparator.comparing(Persona::getApellido).thenComparing(Persona::getNombre));
        imprimirLista(listaPersonas);
        
        
        // REVISAR arrayCadenas = listaCadenas.toArray();
        arrayCadenas = listaCadenas.toArray(new String[0]);
        // No tiene mucho sentido ya que a nivel práctico es mejor trabajar con ArrayList
        
        
        // REVISAR ArrayList<String> listaInvertida = listaCadenas.reversed();
        // Esto ha sido solventado con el método .sort() aplicando el método .reversed()
        
        System.out.println("toString: " + listaEnteros.toString());
        
        // Eliminar todos los elementos de una lista
        listaCadenas.clear();
        System.out.println("");
        imprimirLista(listaCadenas);
        
        System.out.println("");
        System.out.println("Recorrer listas sin necesidad de bucles (forEach)");
        listaPersonas.forEach(p -> System.out.println(p.toString()));
        System.out.println("");
        System.out.println("Imprimir solo los objetos que cumplen con un criterio (apellido=Mulero)");
        listaPersonas.stream() // El método stream() permite recorrer dinámicamente la lista sin bucles
                     .filter(p->p.getApellido().equals("Mulero"))
                     .forEach(System.out::println);
        System.out.println("Imprimir solo los apellidos de las Personas");
        listaPersonas.stream()
                     .map(Persona::getApellido) // De cada elemento (en este caso Persona), mapea sólo el apellido
                     .forEach(System.out::println); // De cada elemento obtenido, imprime lo que se obtiene
        System.out.println("Pasar a una lista a parte los apellidos de las personas");
        List<String> apellidos = listaPersonas.stream()
                                              .map(Persona::getApellido)
                                              .toList();
        //Una List puede convertirse en ArrayList del siguiente modo
        ArrayList<String> apellidosList = new ArrayList<String>(apellidos);
        
        imprimirLista(apellidos);
        System.out.println("");
        
        
    } 
    
    public static void imprimirLista (ArrayList lista)
    {
        for(int i = 0; i<lista.size(); i++)
        {
            System.out.println("["+i+"]: "+lista.get(i));
        }
    }
    public static void imprimirLista (List lista)
    {
        for(int i = 0; i<lista.size(); i++)
        {
            System.out.println("["+i+"]: "+lista.get(i));
        }
    }
        
    
}
