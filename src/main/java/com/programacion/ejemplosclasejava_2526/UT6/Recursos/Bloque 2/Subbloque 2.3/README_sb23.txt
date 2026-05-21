SUBBLOQUE 2.3 - INSTRUCCIONES PARA GENERAR LOS FICHEROS .dat DE PARTIDA
========================================================================

1. Añade GeneradorDat_SB23.java a tu proyecto NetBeans.
2. Crea la carpeta src/datos/ si no existe.
3. Ejecuta GeneradorDat_SB23.main() UNA sola vez.
4. Se crearán los ficheros de partida:
     - clientes.dat          (4 clientes)     → Ejercicio 1
     - productos_stock.dat   (5 productos)    → Ejercicio 2
     - jugadores.dat         (5 jugadores)    → Ejercicio 3
     - suscriptores.dat      (4 suscriptores) → Ejercicio 4
     - turnos.dat            (5 turnos)       → Ejercicio 5

5. A continuación ejecuta el ejercicio correspondiente. Leerá el fichero,
   mostrará los datos en tabla y te pedirá si deseas añadir nuevos registros.

RECUERDA: Usa AppendObjectOutputStream (incluida en las soluciones) para
evitar StreamCorruptedException al añadir objetos a un .dat existente.
