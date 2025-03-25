## Bloque 1: Programacion avanzada
## Excepciones, Depuración y Estructuras de Datos

Este bloque de programación avanzada incluye:
- Excepciones (tema 13)
- Depuración y pruebas (tema 15)
- Estructuras de datos (tema 16)

<br>

### Tema 13: Excepciones en Java

#### ¿Por qué son importantes las excepciones?
Durante la ejecución de un programa pueden ocurrir errores inesperados: división por cero, acceso a una posición inexistente de un array, archivo no encontrado, entre otros. Aunque podríamos intentar prevenir algunos de estos errores con condicionales `if`, este enfoque no es escalable ni efectivo, porque:

- No siempre es posible anticipar todos los errores.
- Los errores pueden provenir de librerías externas o de métodos profundos en la pila de ejecución.
- Los `if` mezclan la lógica del programa con la gestión de errores, haciendo el código menos legible.

Con las **excepciones**, el tratamiento de errores se gestiona mediante una estructura independiente (`try-catch`), lo que permite **separar claramente la lógica principal del programa del código que maneja los errores**.

#### Manejo de excepciones: `try-catch-finally`

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: División por cero.");
} finally {
    System.out.println("Este bloque se ejecuta siempre.");
}
```

El bloque `try` contiene la lógica principal. Si ocurre una excepción, el flujo se desvía al `catch`, donde se trata el error. El bloque `finally` se ejecuta siempre, tanto si ha ocurrido la excepción como si no (por ejemplo, para cerrar archivos o liberar recursos).

#### Lanzar excepciones manualmente con `throw`

A veces queremos propagar el error en lugar de manejarlo directamente, especialmente si la decisión de qué hacer corresponde a un nivel superior de la aplicación. En ese caso, usamos `throw` para lanzar la excepción:

```java
public void dividir(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("No se puede dividir por cero");
    }
    System.out.println(a / b);
}
```

#### Cuándo usar `try-catch` y cuándo usar `throw`

- **`try-catch`**: Se utiliza cuando podemos **gestionar la excepción localmente**, es decir, tenemos una solución o mensaje para el error en ese punto del programa. Ej: volver a pedir datos al usuario, registrar un error, usar un valor alternativo.

- **`throw`**: Se utiliza cuando **no podemos resolver el problema localmente**, y es mejor que lo gestione otro nivel del programa (por ejemplo, otra clase que llamó al método que da el error). Se lanza una excepción para que el error se propague.

#### Principales tipos de excepciones en Java
- `ArithmeticException`: Errores aritméticos, como división por cero.
- `NullPointerException`: Se intenta acceder a una referencia nula.
- `ArrayIndexOutOfBoundsException`: Acceso fuera de los límites de un array.
- `IllegalArgumentException`: Argumento inválido pasado a un método.
- `IOException`: Problemas de entrada/salida (archivos).
- `FileNotFoundException`: Archivo no encontrado.

#### Excepciones personalizadas: ¿cuándo crearlas?
Aunque lo más habitual es usar las excepciones de Java, podemos crear nuestras propias excepciones cuando:
- Queremos dar **información específica** sobre errores en nuestra lógica particular.
- Necesitamos que el código que vemos indique exactamente qué ha fallado.
- Buscamos un tratamiento uniforme de errores definidos por nosotros.

```java
public class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
```

---
<br>

### Tema 15: Depuración de Programas

#### ¿Qué es depurar un programa?
**Depurar** es el proceso de ejecutar el programa paso a paso para **detectar y corregir errores lógicos o de flujo**. No se trata de errores de compilación, sino de aquellos casos en que el programa compila pero **no se comporta como se espera**.

#### Herramientas para depurar
- Depurador (Debugger) del IDE (NetBeans, Eclipse, IntelliJ).
- Consola de salida (`System.out.println` en casos simples).

#### Seguimiento de variables
Permite ver el **valor actual de cada variable** durante la ejecución. Es muy útil para detectar:
- Valores que no se están inicializando correctamente.
- Variables que cambian cuando no deberían.
- Comparaciones que fallan por detalles sutiles (como mayúsculas/minúsculas).

#### Análisis del flujo de ejecución
Permite comprobar **qué caminos del código se están ejecutando realmente**:
- ¿Se entra en el `if` que debería?
- ¿Cuántas veces se ejecuta un bucle?
- ¿Se salta algún bloque inesperadamente?

#### Puntos de ruptura (Breakpoints)
Un **punto de ruptura** es una marca que se coloca en una línea de código para detener la ejecución en ese punto y comenzar la inspección paso a paso.

---
<br>

### Tema 16: Introducción a las Estructuras de Datos

#### ¿Qué es una estructura de datos?
Una estructura de datos es una forma de **organizar y almacenar datos** de manera que sea eficiente acceder, buscar, insertar, modificar o eliminar elementos.
<br>

#### Ventajas frente a arrays tradicionales:
- Tamaño dinámico (no hay que definirlo al inicio).
- Mayor flexibilidad para tipos complejos.
- Operaciones integradas como búsqueda, ordenación o eliminación.

#### Clasificación de las estructuras de datos en Java

| Tipo de colección | Descripción |
|-------------------|-------------|
| **Listas** `List` | Permiten elementos duplicados y mantienen el orden de inserción. Se accede por índice. Ej: `ArrayList`, `LinkedList`. Muy útiles cuando necesitas recorrer datos en orden o acceder por posición. |
| **Conjuntos** `Set` | No permiten duplicados. Muy eficientes para comprobar existencia de elementos. Ej: `HashSet`, `TreeSet`. Ideal para listas de elementos únicos. |
| **Colas** `Queue`  | Acceden a los elementos en orden de llegada (FIFO). Se usan para tareas por turnos, colas de procesos, etc. Ej: `LinkedList`, `PriorityQueue`. |
| **Mapas** `Map`    | Almacenan pares clave-valor. Las claves son únicas. Muy útiles para relacionar datos (por ejemplo, DNI - Persona). Ej: `HashMap`, `TreeMap`. |

#### Profundización: `ArrayList` y `HashMap`

##### `ArrayList`
Similar a un array (también es una lista), pero dinámica (no tiene un tamaño establecido previamente), que mantiene sus elementos ordenados y accesibles por índice:

```java
import java.util.ArrayList;

ArrayList<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Luis");
System.out.println(nombres.get(0)); // Ana
```

- Métodos comunes: `add()`, `get()`, `remove()`, `contains()`, `size()`.
- Permite duplicados y conserva el orden de inserción.

**Ideal para:**
- Listados ordenados de cualquier tipo de dato.
- Especialmente si necesitamos recorrer elementos en orden o acceder por índice.
- Ejemplos de uso: listas de la compra, notas de exámenes, listas de tareas, etc.

##### `HashMap`
Estructura que guarda los datos en pares de datos clave-valor (es decir, por parejas de datos, no de uno en uno). Las claves (primer dato) son únicas y no pueden repetirse. Los elementos aquí no están ordenados (no tienen índice):

```java
import java.util.HashMap;

HashMap<String, Integer> edades = new HashMap<>();
edades.put("Ana", 20);
edades.put("Luis", 25);
System.out.println(edades.get("Ana")); // 20
```

- Métodos comunes: `put()`, `get()`, `remove()`, `containsKey()`, `keySet()`, `values()`
- Muy rápido para acceso por clave.

**Ideal para:**
- Asociar valores a claves y hacer búsquedas rápidas por identificador.
- Ejemplos de uso: agenda de contactos (nombre-teléfono), usuarios y contraseñas, inventario en una tienda (producto-cantidad), diccionario (palabra en español - palabra en inglés), etc.

##### Comparativa rápida

| Característica       | `ArrayList`             | `HashMap`                     |
|----------------------|-------------------------|-------------------------------|
| Acceso/búsqueda      | Por índice              | Por clave                     |
| Permite duplicados   | Sí                      | No en claves, sí en valores   |
| Orden                | Conserva el orden       | No garantiza orden            |
| Uso típico           | Listas ordenadas        | Búsqueda por clave            |

---


