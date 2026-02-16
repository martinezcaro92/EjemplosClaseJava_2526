package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_estudiantes;

import java.util.*;

import com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_estudiantes.Cine;
import com.programacion.examenes_2526.Parcial_20260213_estudiantes.Pelicula;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        int contadorSalas = 0;
        // Crear instancia de Cine (cine) con el nombre "Almenara"
        // Añadir el código aquí
        
        
        // Crear algunas películas y agregarlas a la lista de películas compradas por el Cine
        // Las películas añadidas serán las siguientes:
        // - Tiburón (1975, Steven Spielberg, Acción)
        // - Avatar (2009, James Cameron, Acción)
        // - El Rey León (1994, Roger Allers, Infantil)
        // - El Libro de la Selva (1967, Wolfgang Reitherman, Infantil)
        // - Lo que el viento se llevó (1939, Victor Fleming, Romance)
        // Añadir el código aquí
        

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
                    // Listar todas las películas compradas por el Cine ordenadas por año/titulo ascendente
                    // Añadir el código correspondiente aquí.


                    
                    break;
                case 2:
                    // Asignar película a sala
                    // Solicitar al usuario el id de la película a asignar y el número de sala al que se desea asignar la película.
                    System.out.print("Introduce el id de la película a asignar: ");
                    int idPelicula = scanner.nextInt();
                    System.out.print("Introduce el número de la sala: ");
                    int numSala = scanner.nextInt();
                    
                    // Asignar la película a la sala utilizando el método apropiado de la clase Cine. 
                    // Si la película no se encuentra en la lista de películas compradas por el cine, 
                    // o el número de sala no es válido, o la película no es compatible con la categoría de la sala, se mostrará un mensaje de error indicando el motivo. 
                    // Añadir el código correspondiente aquí.


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
                        // Mostrar la distribución de los asientos de la sala utilizando el método pintar()  de la clase SalaCine 
                        // para que el usuario pueda elegir el asiento que desea reservar.
                        // Añadir el código correspondiente aquí.

                        


                        // Solicitar al usuario el número de fila y el número de butaca que desea reservar.
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

                        // Reservar el asiento utilizando el método reservarAsiento de la clase SalaAcción, si la sala de Cine es de ese tipo.
                        // En primer lugar comprobar si la sala es de tipo SalaAccion
                        // Definir la condición dentro del if siguiente
                        if ()
                        {
                            // Realizar un casting de la sala obtenida a SalaAccion para poder utilizar el método reservarAsiento de dicha clase
                            // Añadir código aquí



                            System.out.println();
                            System.out.println("Introduzca los datos de la persona a reservar la entrada (+18 años)");
                            System.out.print("Nombre: ");
                            String nombre = scan.nextLine();
                            System.out.print("Apellidos: ");
                            String apellidos = scan.nextLine();
                            System.out.print("Edad: ");
                            int edad = scan.nextInt();

                            // A partir de los campos anteriormente solicitados por pantalla, generar una nueva persona y reservar el asiento a nombre de
                            // dicha persona utilizando el método reservarAsiento de la clase SalaAccion.
                            // Añadir el código correspondiente aquí
                            
                            


                        }
                        // Reservar el asiento utilizando el método reservarAsiento de la clase SalaInfantil, si la sala de Cine es de ese tipo.
                        // En primer lugar comprobar si la sala es de tipo SalaInfantil
                        // Definir la condición dentro del if siguiente
                        else if ()
                        {
                            // Realizar un casting de la sala obtenida a SalaInfantil para poder utilizar el método reservarAsiento de dicha clase
                            // Añadir código aquí



                            System.out.println();
                            System.out.println("Introduzca los datos de la persona a reservar la entrada (adulto). Se reserva un asiento contiguo para el menor.");
                            System.out.println();
                            System.out.print("Nombre: ");
                            String nombre = scan.nextLine();
                            System.out.print("Apellidos: ");
                            String apellidos = scan.nextLine();
                            System.out.print("Edad: ");
                            int edad = scan.nextInt();
                            
                            // A partir de los campos anteriormente solicitados por pantalla, generar una nueva persona y reservar el asiento a nombre de
                            // dicha persona utilizando el método reservarAsiento de la clase SalaInfantil.
                            // Añadir el código correspondiente aquí


                        }
                        else 
                        {
                            // Reservar el asiento utilizando el método reservarAsiento de la clase SalaCine para el resto de tipos de sala.
                            // Al contrario que en los casos anteriores, el método reservarAsiento de la clase SalaCine no requiere una persona para realizar la reserva, 
                            // por lo que no es necesario solicitar los datos de la persona por pantalla ni generar una nueva persona para realizar la reserva.
                            // Añadir el código correspondiente aquí

                            

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
                        // Mostrar la distribución de los asientos de la sala utilizando el método pintar()  de la clase SalaCine 
                        // para que el usuario pueda elegir el asiento que desea reservar.
                        // Añadir el código correspondiente aquí.



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
                        
                        // Reservar el asiento utilizando el método reservarAsiento de la clase SalaAcción, si la sala de Cine es de ese tipo.
                        // En primer lugar comprobar si la sala es de tipo SalaAccion
                        // Definir la condición dentro del if siguiente
                        if ()
                        {
                            // Realizar un casting de la sala obtenida a SalaAccion para poder utilizar el método liberarAsiento de dicha clase
                            // Añadir código aquí
                            
                            

                        }

                        // Reservar el asiento utilizando el método reservarAsiento de la clase SalaInfantil, si la sala de Cine es de ese tipo.
                        // En primer lugar comprobar si la sala es de tipo SalaInfantil
                        // Definir la condición dentro del if siguiente
                        else if ()
                        {
                            // Realizar un casting de la sala obtenida a SalaInfantil para poder utilizar el método liberarAsiento de dicha clase
                            // Añadir código aquí
                            
                            

                        }
                        else 
                        {
                            // Reservar el asiento utilizando el método liberarAsiento de la clase SalaCine aquellas salas que no sean de tipo SalaAccion ni SalaInfantil.
                            // Añadir código aquí



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
                        // Crear nueva sala de cine de tipo Standard (SalaCine), solicitando al usuario el número de filas y el número de butacas por fila para la nueva sala.
                        // Debe proporcionarle un número de sala automáticamente a la nueva sala creado (el número de sala de la nueva sala será el número de salas actualmente existentes en el cine + 1).
                        // El número de filas y el número de butacas por fila para la nueva sala será por defecto de 5 filas y 5 butacas por fila, por lo que no es necesario solicitarlo al usuario.
                        // Añadir el código correspondiente aquí para crear la nueva sala de cine de tipo Standard y registrarla en el cine utilizando el método inicializarSalas de la clase Cine.

                        
                    }
                    else if (tipoSala == 2)
                    {
                        System.out.print("¿Dispone la sala de parque de bolas (true/false)?: ");
                        boolean parqueBolas = scanner.nextBoolean();
                        // Crear nueva sala de cine de tipo Infantil, solicitando al usuario si la sala dispone de parque de bolas o no para la nueva sala (ya definido).
                        // Debe proporcionarle un número de sala automáticamente a la nueva sala creado (el número de sala de la nueva sala será el número de salas actualmente existentes en el cine + 1).
                        // El número de filas y el número de butacas por fila para la nueva sala será por defecto de 5 filas y 5 butacas por fila, por lo que no es necesario solicitarlo al usuario.
                        // Añadir el código correspondiente aquí para crear la nueva sala de cine de tipo Infantil y registrarla en el cine utilizando el método inicializarSalas de la clase Cine.
                        
                        

                    }
                    else if (tipoSala == 3)
                    {
                        System.out.print("¿Dispone la sala de sonido especial (true/false)?: ");
                        boolean sonidoEspecial = scanner.nextBoolean();
                        System.out.print("¿Dispone la sala de efecto agua (true/false)?: ");
                        boolean efectoAgua = scanner.nextBoolean();
                        System.out.print("¿Dispone la sala de ventiladores (true/false)?: ");
                        boolean ventiladores = scanner.nextBoolean();
                        
                        // Crear nueva sala de cine de tipo Acción, solicitando al usuario si la sala dispone de sonido especial, efecto de agua y ventiladores para la nueva sala (ya definido).
                        // Debe proporcionarle un número de sala automáticamente a la nueva sala creado (el número de sala de la nueva sala será el número de salas actualmente existentes en el cine + 1).
                        // El número de filas y el número de butacas por fila para la nueva sala será por defecto de 5 filas y 5 butacas por fila, por lo que no es necesario solicitarlo al usuario.
                        // Añadir el código correspondiente aquí para crear la nueva sala de cine de tipo Acción y

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
