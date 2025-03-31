### Ejercicio 1. Gestión de notas con validaciones y excepciones.

Crea un programa que permita a un profesor introducir las notas de varios estudiantes y calcular la media de la clase. Al principio, se solicita el número total de estudiantes. Por cada estudiante, se pedirá una única nota.

El programa debe validar que las notas sean:
- Valores numéricos enteros: si no lo son, se captura y muestra la excepción `NumberFormatException` (se pedirán datos utilizando `NextLine()` de la clase Scanner y convirtiéndolo a `Int`).
- Valores comprendidos entre 0 y 10: si no lo están, se lanza y captura una excepción `IllegalArgumentException`.

Se permite continuar con el siguiente estudiante aunque una nota no sea válida. Al final, se mostrará la media global de las notas válidas introducidas.

Requisitos:
- Se debe usar `Integer.parseInt()` para provocar `NumberFormatException` en caso de entrada no válida.
- Se debe lanzar manualmente una `IllegalArgumentException` si la nota está fuera del rango permitido.
- El cálculo de la media solo debe considerar las notas válidas.
- No es necesario repetir la entrada en caso de error.
- **El programa debe seguir su ejecución sin romperse aunque se introduzcan datos no válidos**.
