package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final;

import java.util.*;

import com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final.Cine;
import com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final.Pelicula;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        int contadorSalas = 0;
        // Crear instancia de Cine con 5 salas
        Cine cine = new Cine("Almenara"); // Suponiendo que tenemos 5 salas
        
//        // Crear algunas películas y agregarlas a la lista de películas compradas
        Pelicula pelicula1 = new Pelicula("Tiburón", 1975, "Steven Spielberg", "Accion");
        Pelicula pelicula2 = new Pelicula("Avatar", 2009, "James Cameron", "Accion");
        Pelicula pelicula3 = new Pelicula("El Rey León", 1994, "Roger Allers", "Infantil");
        Pelicula pelicula4 = new Pelicula("El Libro de la Selva", 1967, "Wolfgang Reitherman", "Infantil");
        Pelicula pelicula5 = new Pelicula("Lo que el viento se llevó", 1939, "Victor Fleming", "Romance");
        cine.comprarPelicula(pelicula1);
        cine.comprarPelicula(pelicula2);
        cine.comprarPelicula(pelicula3);
        cine.comprarPelicula(pelicula4);
        cine.comprarPelicula(pelicula5);

        // Menú interactivo
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            // Mostrar información de las 5 salas
            System.out.println("===================== " + cine.getNombre() + " ===================== ");
            cine.imprimirCartelera();
            System.out.println("==================================================== ");

            System.out.println("");
            // Mostrar menú de opciones
            System.out.println("Menu de operaciones:");
            System.out.println("1. Listar todas las peliculas");
            System.out.println("2. Asignar pelicula a sala");
            System.out.println("3. Reservar asiento en sala");
            System.out.println("4. Liberar asiento en sala");
            System.out.println("5. Mostrar las butacas de cada sala");
            System.out.println("6. Generar una nueva sala");
            System.out.println("7. Salir");
            System.out.print("Elige una opcion (1-7): ");
            
            // Obtener la opción elegida
            opcion = scanner.nextInt();
            int salaReserva;
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Listar todas las películas compradas ordenadas por año/titulo ascendente
                    cine.listarPeliculasCompradas();
                    break;
                case 2:
                    // Asignar película a sala
                    System.out.print("Introduce el id de la película a asignar: ");
                    int idPelicula = scanner.nextInt();
                    System.out.print("Introduce el número de la sala: ");
                    int numSala = scanner.nextInt();
                    cine.asignarPeliculaASala(idPelicula, numSala);
                    break;
                case 3:
                    // Reservar asiento en sala
                    if (cine.getNumSalas()==0)
                    {
                        System.out.println();
                        System.out.println("El cine Almenara no presenta ninguna sala definida.");
                        System.out.println("Pulse Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.print("Introduce el número de la sala: ");
                    salaReserva = scanner.nextInt();
                    if(cine.getSalaCine(salaReserva)!=null)
                    {
                        cine.getSalaCine(salaReserva).pintar();
                        System.out.print("Introduce el número de fila a reservar: ");
                        int numFila = scanner.nextInt();
                        System.out.print("Introduce el número de butaca a reservar: ");
                        int numButaca = scanner.nextInt();
                        int dimensiones [] = cine.getSalaCine(salaReserva).getDimensiones();
                        Scanner scan = new Scanner(System.in);
                        if (numFila <= 0 || numFila > dimensiones[0] || numButaca <= 0 || numButaca > dimensiones[1]) {
                            System.out.println("Número de fila o butaca no válido.");
                            break;
                        }
                        if (cine.getSalaCine(salaReserva) instanceof SalaAccion)
                        {
                            SalaAccion salaAccion = (SalaAccion) cine.getSalaCine(salaReserva);
                            System.out.println();
                            System.out.println("Introduzca los datos de la persona a reservar la entrada (+18 años)");
                            System.out.print("Nombre: ");
                            String nombre = scan.nextLine();
                            System.out.print("Apellidos: ");
                            String apellidos = scan.nextLine();
                            System.out.print("Edad: ");
                            int edad = scan.nextInt();
                            Persona p = new Persona(nombre, apellidos, edad);
                            salaAccion.reservarAsiento(numFila, numButaca, p);
                        }
                        else if (cine.getSalaCine(salaReserva) instanceof SalaInfantil)
                        {
                            SalaInfantil salaInfantil = (SalaInfantil) cine.getSalaCine(salaReserva);
                            System.out.println();
                            System.out.println("Introduzca los datos de la persona a reservar la entrada (adulto). Se reserva un asiento contiguo para el menor.");
                            System.out.println();
                            System.out.print("Nombre: ");
                            String nombre = scan.nextLine();
                            System.out.print("Apellidos: ");
                            String apellidos = scan.nextLine();
                            System.out.print("Edad: ");
                            int edad = scan.nextInt();
                            Persona p = new Persona(nombre, apellidos, edad);
                            salaInfantil.reservarAsiento(numFila, numButaca, p);
                        }
                        else 
                        {
                            cine.getSalaCine(salaReserva).reservarAsiento(numFila, numButaca);
                        } 
                    }
                    break;
                case 4:
                    // Liberar asiento en sala
                    if (cine.getNumSalas()==0)                    {
                        System.out.println();
                        System.out.println("El cine Almenara no presenta ninguna sala definida.");
                        System.out.println("Pulse Enter para continuar...");
                        scanner.nextLine();
                        break;
                    }
                     System.out.print("Introduce el número de la sala: ");
                    salaReserva = scanner.nextInt();
                    if(cine.getSalaCine(salaReserva)!=null)
                    {
                        cine.getSalaCine(salaReserva).pintar();
                        System.out.print("Introduce el número de fila a liberar: ");
                        int numFila = scanner.nextInt();
                        System.out.print("Introduce el número de butaca a liberar: ");
                        int numButaca = scanner.nextInt();
                        int dimensiones [] = cine.getSalaCine(salaReserva).getDimensiones();
                        Scanner scan = new Scanner(System.in);
                        if (numFila <= 0 || numFila > dimensiones[0] || numButaca <= 0 || numButaca > dimensiones[1]) {
                            System.out.println("Número de fila o butaca no válido.");
                            break;
                        }
                        if (cine.getSalaCine(salaReserva) instanceof SalaAccion)
                        {
                            SalaAccion salaAccion = (SalaAccion) cine.getSalaCine(salaReserva);
                            salaAccion.liberarAsiento(numFila, numButaca);
                        }
                        else if (cine.getSalaCine(salaReserva) instanceof SalaInfantil)
                        {
                            SalaInfantil salaInfantil = (SalaInfantil) cine.getSalaCine(salaReserva);
                            salaInfantil.liberarAsiento(numFila, numButaca);
                        }
                        else 
                        {
                            cine.getSalaCine(salaReserva).liberarAsiento(numFila, numButaca);
                        }
                        
                    }
                    break;
                case 5:
                    // Mostrar las butacas de cada sala
                    cine.mostrarTodasSalas();
                    break;
                case 6:
                    // Crear nueva sala de cine
                    System.out.print("Indicar el tipo de sala a crear (1: Standard | 2: Infantil | 3: Accion): ");
                    int tipoSala = scanner.nextInt();
                    if (tipoSala == 1)
                    {
                        SalaCine salaNueva = new SalaCine(++contadorSalas, 5, 5);
                        cine.inicializarSalas(salaNueva);
                    }
                    else if (tipoSala == 2)
                    {
                        System.out.print("¿Dispone la sala de parque de bolas (true/false)?: ");
                        boolean parqueBolas = scanner.nextBoolean();
                        SalaInfantil salaNueva = new SalaInfantil(++contadorSalas, 5, 5, parqueBolas);
                        cine.inicializarSalas(salaNueva);
                    }
                    else if (tipoSala == 3)
                    {
                        System.out.print("¿Dispone la sala de sonido especial (true/false)?: ");
                        boolean sonidoEspecial = scanner.nextBoolean();
                        System.out.print("¿Dispone la sala de efecto agua (true/false)?: ");
                        boolean efectoAgua = scanner.nextBoolean();
                        System.out.print("¿Dispone la sala de ventiladores (true/false)?: ");
                        boolean ventiladores = scanner.nextBoolean();
                        SalaAccion salaNueva = new SalaAccion(++contadorSalas, 5, 5, sonidoEspecial, efectoAgua, ventiladores);
                        cine.inicializarSalas(salaNueva);
                    }
                    else
                    {
                        System.out.println("Error a la hora de seleccionar el tipo de Sala de cine a crear");
                    }
                    break;
                case 7:
                    // Salir
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 7.");
            }
        } while (opcion != 7); // Salir del ciclo cuando elija la opción 7
    }
}
