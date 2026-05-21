SUBBLOQUE 2.1 - INSTRUCCIONES PARA GENERAR LOS FICHEROS .dat
=============================================================

Los ficheros .dat son binarios y no pueden distribuirse como texto plano.
Para generarlos sigue estos pasos en NetBeans:

1. Crea la carpeta  src/datos/  dentro de tu proyecto si no existe.
2. Añade el fichero  GeneradorDat.java  a tu proyecto.
3. Ejecuta  GeneradorDat.main()  UNA sola vez.
4. Se crearán los siguientes ficheros en src/datos/:
     - empleados.dat   (6 objetos Empleado)   → Ejercicio 1
     - pedidos.dat     (7 objetos Pedido)      → Ejercicio 2
     - productos.dat   (6 objetos Producto)    → Ejercicio 3
     - reservas.dat    (5 objetos Reserva)     → Ejercicio 4
     - alumnos.dat     (8 objetos Alumno)      → Ejercicio 5

IMPORTANTE:
- El generador usa clases internas propias para ser autocontenido.
- En tus ejercicios debes definir las clases de dominio reales
  (Empleado, Pedido, Producto, Reserva, Alumno) con implements Serializable
  y el mismo serialVersionUID = 1L que usa el generador.
- Si cambias los atributos o el serialVersionUID obtendrás
  InvalidClassException al leer los ficheros. En ese caso borra los .dat
  y vuelve a ejecutar el generador con tu versión de las clases.
