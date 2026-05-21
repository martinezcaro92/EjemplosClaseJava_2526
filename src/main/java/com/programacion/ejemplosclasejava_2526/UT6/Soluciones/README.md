# ✅ Soluciones — UT6

Ficheros `.java` con la solución de cada ejercicio del cuaderno de actividades de repaso de la UT6. Están organizados por bloque y subbloque siguiendo la misma nomenclatura del enunciado.

---

## Estructura de directorios

```
Soluciones/
├── Bloque 1/
│   ├── Subbloque 1.1/    # Solo lectura CSV / JSON
│   ├── Subbloque 1.2/    # Lectura y escritura CSV / JSON
│   └── Subbloque 1.3/    # Solo escritura desde teclado CSV / JSON
├── Bloque 2/
│   ├── Subbloque 2.1/    # Solo lectura de ficheros binarios
│   ├── Subbloque 2.2/    # Solo escritura de ficheros binarios
│   └── Subbloque 2.3/    # Lectura y escritura combinadas
├── Bloque 3/
│   ├── Subbloque 3.1/    # Operaciones DDL sobre bases de datos
│   ├── Subbloque 3.2/    # Solo lectura SELECT
│   ├── Subbloque 3.3/    # Solo escritura INSERT
│   ├── Subbloque 3.4/    # Creación completa de BD desde Java
│   └── Subbloque 3.5/    # Lectura de BD y exportación a fichero
└── Bloque 4/
    ├── Subbloque 4.1/    # Fichero → inserción en BD
    └── Subbloque 4.2/    # Lectura de BD → exportación a fichero
```

Dentro de cada subbloque los ficheros siguen la nomenclatura `EjercicioN.java`, donde `N` es el número del ejercicio dentro de ese subbloque.

---

## Contenido por bloque

### Bloque 1 — Ficheros de texto (CSV / JSON)

Ejercicios centrados en la lectura y escritura de ficheros de texto plano. Los recursos principales son `Scanner`, `FileReader`, `PrintWriter`, `FileWriter` y la librería `org.json`.

| Subbloque | Descripción | Ejercicios |
|---|---|---|
| **SB 1.1** | Solo lectura — leer fichero y mostrar en tabla | 5 |
| **SB 1.2** | Lectura y escritura — leer, mostrar y añadir registros | 5 |
| **SB 1.3** | Solo escritura — generar fichero desde cero por teclado | 5 |

### Bloque 2 — Ficheros binarios (serialización)

Ejercicios de persistencia de objetos Java mediante serialización. La clase serializada debe implementar `Serializable`. Recursos: `FileInputStream`, `ObjectInputStream`, `FileOutputStream`, `ObjectOutputStream`.

Cada subbloque incluye las **clases de dominio** necesarias (`Empleado`, `Vehiculo`, `Cliente`, etc.) y, cuando aplica, la clase `AppendObjectOutputStream` para añadir objetos a un fichero existente sin corromperlo.

| Subbloque | Descripción | Ejercicios |
|---|---|---|
| **SB 2.1** | Solo lectura de ficheros `.dat` | 5 |
| **SB 2.2** | Solo escritura de objetos en ficheros `.dat` | 5 |
| **SB 2.3** | Lectura y escritura combinadas | 5 |

> **Importante:** antes de ejecutar los ejercicios de SB 2.1 y SB 2.3 es necesario generar los `.dat` de partida usando los `GenerarXxx.java` incluidos en la carpeta `Recursos`.

### Bloque 3 — Acceso a bases de datos MySQL desde Java

Ejercicios de conexión JDBC. Recursos principales: `Connection`, `DriverManager`, `Statement`, `ResultSet`, `SQLException`.

| Subbloque | Descripción | Ejercicios |
|---|---|---|
| **SB 3.1** | Operaciones DDL — crear/eliminar BDs y tablas | 5 |
| **SB 3.2** | Solo lectura — ejecutar `SELECT` y mostrar resultados | 5 |
| **SB 3.3** | Solo escritura — ejecutar `INSERT` desde código o teclado | 5 |
| **SB 3.4** | Creación completa de BD desde Java | 5 |
| **SB 3.5** | Leer BD y exportar a CSV o JSON | 5 |

> Los ejercicios de SB 3.2 al 3.5 requieren tener la BD creada y poblada. Consultar los scripts SQL de la carpeta `Recursos/Bloque 3`.

### Bloque 4 — Ejercicios integrados (fichero + BD)

Ejercicios que combinan el manejo de ficheros con el acceso a bases de datos. Integran los recursos de los bloques 1 y 3.

| Subbloque | Descripción | Ejercicios |
|---|---|---|
| **SB 4.1** | Leer un fichero CSV o JSON e insertar los datos en BD | 5 |
| **SB 4.2** | Consultar la BD y exportar los resultados a CSV o JSON | 5 |

---

## Notas de uso

- Los ejercicios están pensados para abrirse directamente en **NetBeans** copiando el fichero al paquete correspondiente del proyecto.
- Las rutas de ficheros (`fullName`) usan como base el directorio raíz del proyecto. Ajustar según la estructura de tu proyecto NetBeans si es necesario.
- Los ejercicios de los subbloques **3.3, 3.4 y 3.5** que actúan como plantilla incluyen comentarios indicando exactamente qué sentencia SQL o qué campos del `ResultSet` hay que completar.