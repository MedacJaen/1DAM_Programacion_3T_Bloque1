### Ejercicio 3. Sistema bancario básico con clases y excepciones

Crea una clase CuentaBancaria con los siguientes atributos:
- String titular
- double saldo

Y los métodos:
- ingresar(double cantidad)
- retirar(double cantidad)
- consultarSaldo()

El método retirar debe lanzar una excepción personalizada (`SaldoInsuficienteException`) si se intenta retirar más dinero del disponible. Se debe controlar también la posibilidad de que se introduzcan caracteres no numéricos (`NumberFormatException`). Por útlimo, puedes lanzar manualmente una excepción (`IllegalArgumentException`) si el saldo a ingresar o a retirar es menor que cero.

En el programa principal (main):
- Crea una cuenta con saldo inicial de cero.
- Muestra un menú al usuario para ingresar, retirar o consultar el saldo.
- Controla entradas inválidas y errores con try-catch.
