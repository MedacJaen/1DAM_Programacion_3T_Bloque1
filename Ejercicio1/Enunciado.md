### Ejercicio 1. Gestión de notas con validaciones y excepciones.

Crea un programa que permita a un profesor introducir las notas de varios estudiantes y calcular la media de la clase. Al principio, se solicita el número total de estudiantes. Por cada estudiante, se pedirá una única nota.

El programa debe validar que las notas sean:
- Valores numéricos enteros: si no lo son, se captura y muestra la excepción `NumberFormatException` (se pedirán datos utilizando `NextLine()` de la clase Scanner y convirtiéndolo a `Int`).
- Valores comprendidos entre 0 y 10: si no lo están, se lanza y captura una excepción `IllegalArgumentException`.
- En cualquiera de estos casos, se debe volver a pedir la nota hasta que se introduzca correctamente.

Al final, se mostrará la media de la clase, calculada en base a todas las notas válidas introducidas.

Requisitos:
- El número de estudiantes también debe introducirse como valor numérico válido (`int`).
- Se debe usar al menos un bloque `try-catch` para capturar `NumberFormatException`.
- Se debe lanzar manualmente una `IllegalArgumentException` cuando la nota esté fuera de rango.
- El control de errores debe quedar centralizado en las excepciones (no se permiten estructuras if-else clásicas sin lanzar excepción).
