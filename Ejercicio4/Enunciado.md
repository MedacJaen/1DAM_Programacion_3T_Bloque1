### Ejercicio 4. Errores en tiempo de ejecución.

Se te proporciona el siguiente código Java. Compila correctamente, pero cuando se ejecuta no muestra la media correcta de las notas introducidas por el usuario. Tu tarea es usar el depurador (con puntos de ruptura, seguimiento de variables, etc.) para encontrar y corregir los errores.

```java
import java.util.Scanner;

public class CalculoMedia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] notas = new int[5];
        int suma = 0;

        System.out.println("Introduce 5 notas (de 0 a 10):");

        for (int i = 0; i <= notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextInt();
            suma =+ notas[i];  // ← ¿Qué pasa aquí?
        }

        double media = suma / notas.length;

        System.out.println("La media es: " + media);
    }
}
```

**Instrucciones:**
- Crea un fichero .java y copia ahí el código.
- Puedes ejecutarlo y probarlo, pero no modifiques nada de primeras hasta no depurar y encontrar los errores.
- Utiliza las herramientas de depuración del IDE, analizando en concreto:
  - ¿Qué valor tiene suma tras cada iteración?
  - ¿Qué ocurre en la última vuelta del bucle?
  - ¿Qué tipo de excepción ocurre y por qué?
  - ¿Por qué el resultado de la media no tiene decimales?
- La finalidad de este ejercicio no es corregirlo rápidamente, sino practicar con las herramientas de depuración del IDE. Analízalo detenidamente, añadiendo puntos de ruptura, ejecutando paso a paso y observando qué sucede con las variables.
- Haz un primer commit en el que añadas comentarios explicando los errores encontrados, pero sin modificar el código original.
- Haz un segundo commit con el ejercicio ya corregido y funcional.

