/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260311;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class StreamingTest {
    private static ArrayList<Contenido> catalogo = new ArrayList<Contenido>();
    
    public static void main(String[] args) {
        Pelicula etf = new Pelicula (1,"El truco final",130,true);
        Pelicula ma = new Pelicula (3, "Mar adentro", 125, false);
        
        ArrayList<Episodio> listaEpisodios1 = new ArrayList<Episodio>();
        listaEpisodios1.add(new Episodio ("Winter Is Coming", 62, true));
        listaEpisodios1.add(new Episodio ("The Kingsroad", 56, true));
        listaEpisodios1.add(new Episodio ("Lord Snow", 58, true));
        listaEpisodios1.add(new Episodio ("Broken Things", 56, false));
        listaEpisodios1.add(new Episodio ("The Wolf & Lion", 55, true));

        Serie jdt = new  Serie(2, "Juego de Tronos", listaEpisodios1);
        
        ArrayList<Episodio> listaEpisodios2 = new ArrayList<Episodio>();
        listaEpisodios2.add(new Episodio ("Pilot", 44, true));
        listaEpisodios2.add(new Episodio ("Allen", 45, false));
        listaEpisodios2.add(new Episodio ("Cell Test", 43, true));
        listaEpisodios2.add(new Episodio ("Cute Poison", 44, false));
        listaEpisodios2.add(new Episodio ("Fitz or Percy", 49, true));

        Serie pb = new  Serie(4, "Prision Break", listaEpisodios2);
        
        catalogo.add(etf);
        catalogo.add(jdt);
        catalogo.add(ma);
        catalogo.add(pb);
        
        int opcion = 0;
        Scanner scan = new Scanner (System.in);
        
        do {
            // Añadir contenido al esquema
            try
            {
                mostrarMenu();
                System.out.print("Seleccione una opcion: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        // Añadir contenido al esquema
                        imprimeContenidos();
                        break;
                    case 2:
                        // Añadir contenido al esquema
                        valoraContenidos();
                        break;
                    case 3:
                        // Añadir contenido al esquema
                        reproduceContenidos();
                        break;
                    case 4:
                        // Añadir contenido al esquema
                        descargaContenidos();
                        break;
                    case 5:
                        System.out.println("Saliendo de la aplicación...");
                        // Añadir contenido al esquema
                        break;
                    default:
                        // Añadir contenido al esquema
                        throw new IllegalArgumentException("Valor fuera de rango");
                }

                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (opcion != 5);

    }
    
    public static void mostrarMenu() {
        System.out.println("====================================================");
        System.out.println("        PLATAFORMA DE CONTENIDOS MULTIMEDIA   ");
        System.out.println("====================================================");
        System.out.println("1. Consultar los contenidos multimedia del sistema");
        System.out.println("2. Valorar contenidos multimedia");
        System.out.println("3. Reproducir contenido multimedia");
        System.out.println("4. Descargar contenido multimedia");
        System.out.println("5. Salir de la aplicación");
        System.out.println("====================================================");
        System.out.println();
    }

    private static void imprimeContenidos() {
        System.out.println("-- CONTENIDOS MULTIMEDIA DISPONIBLES --");
        for(Contenido c: catalogo)
        {
            System.out.println(c.toString());
        }
    }

    private static void valoraContenidos() {
        Scanner scan = new Scanner (System.in);
        contenidosResumidos();
        System.out.print("Seleccione el contenido multimedia a valorar: ");
        int aux = scan.nextInt();
        if (aux > catalogo.size()) throw new ArrayIndexOutOfBoundsException("No se puede alcanzar el indice indicado del array");
        aux--;
                
        if (catalogo.get(aux) instanceof Serie)
        {
            try
            {
                System.out.print("    Introduzca la puntuacion (1-5): ");
                int puntos = scan.nextInt();
                Serie s = (Serie) catalogo.get(aux);
                s.valorar(puntos);
                catalogo.set(aux, s);
            } catch (ValoracionFueraDeRangoException e) {
                System.out.println("Error: " + e);
            } catch (Exception e)
            {
                System.out.println("Error: " + e);
            } finally {
                System.out.println("Final del proceso de valoración");
            }
        }   
        if (catalogo.get(aux) instanceof Pelicula)
        {
            try
            {
                System.out.print("    Introduzca la puntuacion (1-10): ");
                int puntos = scan.nextInt();
                Pelicula p = (Pelicula) catalogo.get(aux);
                p.valorar(puntos);
                catalogo.set(aux, p);
            } catch (ValoracionFueraDeRangoException e) {
                System.out.println("Error: " + e);
            } catch (Exception e)
            {
                System.out.println("Error: " + e);
            } finally {
                System.out.println("Final del proceso de valoración");
            }
        }
        
    }

    private static void reproduceContenidos() {
        Scanner scan = new Scanner (System.in);
        System.out.println("-- REPRODUCIR CONTENIDO MULTIMEDIA --");
        contenidosResumidos();
        System.out.print("Seleccione el contenido multimedia a valorar: ");
        int aux = scan.nextInt();
        if (aux > catalogo.size()) throw new ArrayIndexOutOfBoundsException("No se puede alcanzar el indice indicado del array");
        aux--;
        
        try {
            catalogo.get(aux).reproducir();
        } catch(ContenidoNoDisponibleException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Final del proceso de reproducción");
        }
    }

    private static void descargaContenidos() {
        Scanner scan = new Scanner (System.in);
        System.out.println("-- DESCARGAR CONTENIDO MULTIMEDIA --");
        for(Contenido c: catalogo)
        {
            if (c instanceof Pelicula)
            {
                System.out.println("("+c.getId()+") " + c.getTitulo());
            }
        }
        System.out.print("Seleccione el contenido multimedia a valorar: ");
        int aux = scan.nextInt();
        aux--;
        try {
            if (!(catalogo.get(aux) instanceof Pelicula)) throw new IllegalArgumentException("El contenido seleccionado no es una Película");
            Pelicula p = (Pelicula) catalogo.get(aux);
            p.descargar();
            catalogo.set(aux, p);
        } catch (LimiteDescargasException e) {
            System.out.println("Error: " + e);
        } catch (ContenidoNoDisponibleException e) {
            System.out.println("Error: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Final del proceso de descarga");
        }
        
    }

    private static void contenidosResumidos() {
        for(Contenido c: catalogo)
        {
            System.out.println("("+c.getId()+") " + c.getTitulo());
        }
    }

}
