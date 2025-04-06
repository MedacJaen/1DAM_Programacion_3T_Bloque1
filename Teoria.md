## Bloque 1: Programacion avanzada (Excepciones, Depuración y Estructuras de Datos)

Este bloque de programación avanzada incluye:
- Excepciones (tema 13)
- Depuración y pruebas (tema 15)
- Estructuras de datos (tema 16)

<br>

### Tema 13: Excepciones en Java

Los programas pueden fallar en tiempo de ejecución, es decir, fallos que no ha detectado el IDE, si no que descubrimos mientras se utiliza el programa. Estos fallos incluso pueden darse algunas veces y otras no, por lo que son difíciles de detectar. Son lo que se llaman excepciones, y su manejo permitirá que el programa sepa cómo gestionarlas sin cerrarse de forma abrupta.

**¿Error o excepción?**  
En Java, diferenciamos entre un `Error` y una `Exception`:
- Los `Error` representan fallos graves del sistema y **no deben capturarse**. Digamos que no tienen solución (fallos de memoria, por ejemplo).
- Las `Exception` sí pueden gestionarse y evitar que rompan el programa, y son el foco de este tema.

#### ¿Por qué son importantes las excepciones?
Durante la ejecución de un programa pueden ocurrir errores inesperados: división por cero, acceso a una posición inexistente de un array, archivo no encontrado, entre otros. Aunque podríamos intentar prevenir algunos de estos errores con condicionales `if`, este enfoque no es escalable ni efectivo, porque:

- No siempre es posible anticipar todos los errores.
- Los errores pueden provenir de librerías externas o de métodos profundos en la pila de ejecución.
- Los `if` mezclan la lógica del programa con la gestión de errores, haciendo el código menos legible.

Con las **excepciones**, el tratamiento de errores se gestiona mediante una estructura independiente (`try-catch`), lo que permite **separar claramente la lógica principal del programa del código que maneja los errores**.

El lenguaje Java contempla múltipes excepciones (creadas internamente en un sistema de herencia), y al que podemos agregarle las que necesitemos.

![image](https://github.com/user-attachments/assets/938b8fae-e127-47f3-9dab-d24e455426ea)


#### 1. Manejo básico de excepciones: `try-catch-finally`

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: División por cero.");
} finally {
    System.out.println("Este bloque se ejecuta siempre.");
}
```

El bloque `try` contiene la lógica principal (el código que podría generar una excepción). Si ocurre una excepción, el flujo se desvía al `catch`, donde se trata el error sin que se rompa el programa. El bloque `finally` se ejecuta siempre, tanto si ha ocurrido la excepción como si no.

En muchas ocasiones, las excepciones 'saltan' automáticamente (Java detecta el error y lanza la excepción), pero nosotros también podemos lanzarlas intencionadamente mediante la palabra `throw`.

```java
    if (b == 0) {
        throw new ArithmeticException("No se puede dividir por cero");
    }
    System.out.println(a / b);
```

#### 2. Dónde gestionar la excepción.

En Programación Orientada a Objetos, cuando trabajamos con múltiples clases y métodos, a veces queremos propagar el error en lugar de manejarlo directamente, especialmente si la decisión de qué hacer corresponde a un nivel superior de la aplicación. Esto es útil cuando la clase que lanza el error no tiene contexto suficiente para resolverlo, pero quien llama al método sí.

En ese caso, usamos `throws` en la firma del método para lanzar la excepción, por lo que no se usará un `try-catch` en el método, si no en el lugar donde se haya llamado al método (por ejemplo, en el main):

```java
public void dividir(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("No se puede dividir por cero");
    }
    System.out.println(a / b);
}
```

- **`try-catch`**: Se utiliza cuando podemos **gestionar la excepción localmente**, es decir, tenemos una solución o mensaje para el error en ese punto del programa. Ej: volver a pedir datos al usuario, registrar un error, usar un valor alternativo.

- **`throw`**: Se utiliza cuando **no podemos resolver el problema localmente**, y es mejor que lo gestione otro nivel del programa (por ejemplo, otra clase que llamó al método que da el error). Usamos `throw` para lanzar la excepción y `throws` en la firma del método para indicar que esa excepción será gestionada en otro punto del programa mediante try-catch.

#### 3. Principales tipos de excepciones en Java
- `NumberFormatException`: Errores en conversiones de números.
- `ArithmeticException`: Errores aritméticos, como división por cero.
- `NullPointerException`: Se intenta acceder a una referencia nula.
- `ArrayIndexOutOfBoundsException`: Acceso fuera de los límites de un array.
- `IllegalArgumentException`: Argumento inválido pasado a un método.
- `IOException`: Problemas de entrada/salida de información (lo veremos en los próximos temas).
- `FileNotFoundException`: Archivo no encontrado (lo veremos en los próximos temas).
- `SocketException`: problemas de conexión (lo estudiaremos en 2º).

#### 4. Excepciones personalizadas: ¿cuándo crearlas?
Aunque lo más habitual es usar las excepciones de Java, podemos crear nuestras propias excepciones cuando:
- Queremos dar **información específica** sobre errores en nuestra lógica particular.
- Necesitamos que el código que vemos indique exactamente qué ha fallado.
- Buscamos un tratamiento uniforme de errores definidos por nosotros.

Para ello, debemos crear una clase que herede de Exception y llame a su constructor. Una vez creada dicha clase, podremos lanzar nuestras propias excepciones.

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


