# 📦 Recursos — UT6

Ficheros de apoyo necesarios para realizar los ejercicios del cuaderno de actividades de repaso de la UT6.

---

## Contenido por bloque

### Bloque 1 — Ficheros de texto (CSV / JSON)

| Subbloque | Ficheros incluidos |
|---|---|
| **SB 1.1** | `peliculas.csv`, `inventario.json`, `resultados.csv`, `temperaturas.json`, `contactos.csv` |
| **SB 1.2** | `biblioteca.csv`, `pacientes.json`, `asistencia.csv`, `videojuegos.csv`, `eventos.csv` |
| **SB 1.3** | Ficheros de ejemplo para verificar salidas esperadas *(los ejercicios generan ficheros nuevos desde teclado)* |

### Bloque 2 — Ficheros binarios (serialización)

| Subbloque | Contenido |
|---|---|
| **SB 2.1** | Clases de dominio: `Empleado`, `Pedido`, `Producto`, `Reserva`, `Alumno` + `GenerarXxx.java` para crear los `.dat` antes de cada ejercicio |
| **SB 2.2** | Clases de dominio: `Socio`, `Medicamento`, `EmpleadoRRHH`, `Incidencia` |
| **SB 2.3** | Clases de dominio: `ProductoStock`, `Jugador`, `Suscriptor`, `Turno` + `GenerarDatIniciales.java` para crear los `.dat` de partida |

> **Nota:** Los ficheros `.dat` son binarios y no pueden distribuirse como texto plano. Cada carpeta incluye una clase `GenerarXxx.java` que debe compilarse y ejecutarse antes del ejercicio principal para generar el fichero `.dat` correspondiente.

### Bloque 3 — Acceso a bases de datos MySQL

| Subbloque | Contenido |
|---|---|
| **SB 3.1** | Scripts SQL de referencia (estructura a replicar desde Java) |
| **SB 3.2** | Scripts de población de datos (ejecutar tras los de SB 3.1) |
| **SB 3.3** | Scripts de setup con tablas vacías listas para recibir `INSERT` |
| **SB 3.4** | Scripts SQL completos a replicar desde Java |
| **SB 3.5** | `INSTRUCCIONES.txt` con el orden de ejecución de scripts |

### Bloque 4 — Ejercicios integrados (fichero + BD)

| Subbloque | Contenido |
|---|---|
| **SB 4.1** | CSV/JSON de entrada + `setup_bds_destino.sql` |
| **SB 4.2** | `INSTRUCCIONES.txt` con el orden de ejecución |

---

## Orden de uso recomendado

1. Leer el enunciado del ejercicio en el cuaderno Word de actividades.
2. Consultar la carpeta auxiliar correspondiente al ejercicio.
3. **Ejercicios de BD:** ejecutar en MySQL el/los scripts SQL indicados.
4. **Ejercicios de binarios:** compilar y ejecutar el `GenerarXxx.java` para crear el `.dat` de partida.
5. Implementar el ejercicio Java en NetBeans.

---

## Credenciales MySQL por defecto

```
Host:     localhost:3306
Usuario:  root
Password: RootPass123!
```

> Ajustar si tu instalación local usa credenciales distintas.