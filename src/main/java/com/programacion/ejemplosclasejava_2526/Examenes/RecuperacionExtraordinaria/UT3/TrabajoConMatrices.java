package com.programacion.examenes_2526.RecuperaciónExtraordinaria.UT3;

import java.util.Scanner;

public class TrabajoConMatrices {

    // Variable global de la matriz
    static int[][] matriz;

    // ─────────────────────────────────────────────
    // a) tomaDeDatos()
    // ─────────────────────────────────────────────
    static void tomaDeDatos() {
        Scanner sc = new Scanner(System.in);

        // Pedir número de filas
        System.out.print("Introduce el número de filas (N): ");
        int n = sc.nextInt();

        // Pedir número de columnas
        System.out.print("Introduce el número de columnas (M): ");
        int m = sc.nextInt();

        // Crear la matriz con las dimensiones indicadas
        matriz = new int[n][m];

        // Rellenar la matriz con validación de rango [-100, 100]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int valor;
                do {
                    System.out.print("Valor para posición [" + i + "][" + j + "] (-100 a 100): ");
                    valor = sc.nextInt();
                    if (valor < -100 || valor > 100) {
                        System.out.println("  Fuera de rango. Inténtalo de nuevo.");
                    }
                } while (valor < -100 || valor > 100);
                matriz[i][j] = valor;
            }
        }
    }

    // ─────────────────────────────────────────────
    // b) calculoSuma(...)
    // ─────────────────────────────────────────────
    static int calculoSuma(int[][] m) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                suma += m[i][j];
            }
        }
        return suma;
    }

    // ─────────────────────────────────────────────
    // c) calculoProducto(...)
    // ─────────────────────────────────────────────
    static int calculoProducto(int[][] m) {
        int producto = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                producto *= m[i][j];
            }
        }
        return producto;
    }

    // ─────────────────────────────────────────────
    // d) bidimensional2Unidimensional(...)
    // ─────────────────────────────────────────────
    static int[] bidimensional2Unidimensional(int[][] m) {
        int filas = m.length;
        int cols  = m[0].length;
        int[] uni = new int[filas * cols];
        int idx = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                uni[idx++] = m[i][j];
            }
        }
        return uni;
    }

    // ─────────────────────────────────────────────
    // e) matrizTranspuesta(...)
    // ─────────────────────────────────────────────
    static int[][] matrizTranspuesta(int[][] m) {
        int filas = m.length;
        int cols  = m[0].length;
        // La transpuesta tiene dimensiones invertidas: cols x filas
        int[][] transpuesta = new int[cols][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                transpuesta[j][i] = m[i][j];
            }
        }
        return transpuesta;
    }

    // ─────────────────────────────────────────────
    // f) sumaYProducto(...)
    // ─────────────────────────────────────────────
    static int[] sumaYProducto(int[][] m) {
        int[] resultado = new int[2];
        resultado[0] = calculoSuma(m);      // posición 0 → suma
        resultado[1] = calculoProducto(m);  // posición 1 → producto
        return resultado;
    }

    // ─────────────────────────────────────────────
    // Métodos auxiliares de impresión
    // ─────────────────────────────────────────────
    static void imprimirMatriz2D(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%6d ", m[i][j]);
            }
            System.out.println("]");
        }
    }

    static void imprimirMatriz1D(int[] m) {
        System.out.print("[ ");
        for (int v : m) System.out.printf("%d ", v);
        System.out.println("]");
    }

    // ─────────────────────────────────────────────
    // g) main(...)
    // ─────────────────────────────────────────────
    public static void main(String[] args) {

        /** Salida esperada (ejemplo con matriz 2x3)
         * 
         * ¿Desea iniciar el programa? (si/s para continuar): si
         * Introduce el número de filas (N): 2
         * Introduce el número de columnas (M): 3
         * Valor para posición [0][0] (-100 a 100): 1
         * Valor para posición [0][1] (-100 a 100): 2
         * Valor para posición [0][2] (-100 a 100): 3
         * Valor para posición [1][0] (-100 a 100): 4
         * Valor para posición [1][1] (-100 a 100): 5
         * Valor para posición [1][2] (-100 a 100): 6

         * --- Suma y Producto ---
         * Suma     : 21
         * Producto : 720

         * --- Matriz original ---
         * [      1      2      3 ]
         * [      4      5      6 ]

         * --- Matriz transpuesta ---
         * [      1      4 ]
         * [      2      5 ]
         * [      3      6 ]

         * --- Matriz unidimensional ---
         * [ 1 2 3 4 5 6 ]

         * * ¿Desea iniciar el programa? (si/s para continuar): no

        Fin de la ejecución del programa 
         * 
         */


        Scanner sc = new Scanner(System.in);
        String respuesta;

        do {
            System.out.print("\n¿Desea iniciar el programa? (si/s para continuar): ");
            respuesta = sc.next().trim().toLowerCase();

            if (respuesta.equals("si") || respuesta.equals("s")) {

                // 1. Toma de datos
                tomaDeDatos();

                // 2. sumaYProducto → imprimir resultado
                int[] sp = sumaYProducto(matriz);
                System.out.println("\n--- Suma y Producto ---");
                System.out.println("Suma     : " + sp[0]);
                System.out.println("Producto : " + sp[1]);

                // 3. matrizTranspuesta → imprimir antes y después
                System.out.println("\n--- Matriz original ---");
                imprimirMatriz2D(matriz);

                int[][] transpuesta = matrizTranspuesta(matriz);
                System.out.println("\n--- Matriz transpuesta ---");
                imprimirMatriz2D(transpuesta);

                // 4. bidimensional2Unidimensional → imprimir resultado
                int[] uni = bidimensional2Unidimensional(matriz);
                System.out.println("\n--- Matriz unidimensional ---");
                imprimirMatriz1D(uni);

            } else {
                System.out.println("\nFin de la ejecución del programa");
            }

        } while (respuesta.equals("si") || respuesta.equals("s"));

        sc.close();
    }
}
