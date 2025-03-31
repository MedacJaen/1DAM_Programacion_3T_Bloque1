### 🏨 Proyecto: Sistema de reservas de hotel

Desarrollar un programa en Java que permita gestionar reservas en un hotel, aplicando principios de programación orientada a objetos, estructuras dinámicas y control de excepciones. Para simplificar, se permitirá reservar la habitación solo 1 día.

Debes crear un sistema que permita realizar reservas de habitaciones en un hotel. El programa deberá:
- Almacenar todas las reservas realizadas en un `ArrayList<Reserva>`.
- Detectar conflictos de fechas (no se puede reservar una misma habitación si ya está ocupada).
- Lanzar y capturar excepciones en los casos necesarios.

**Clases que debe incluir el proyecto:**
- Clase Cliente
  - String nombre
  - String dni
- Clase Habitacion
  - int numero
  - String tipo (individual, doble, suite)
- Clase Reserva
  - Cliente cliente
  - Habitacion habitacion
  - LocalDate fechaReserva
- Clase GestorReservas
  - ArrayList<Reserva> reservas
  - Métodos:
    - `void añadirReserva(Reserva r)`    //Añade una nueva reserva si no hay conflicto de fechas.
    - `boolean hayConflicto(Reserva r)`  //Devuelve true si ya existe una reserva para la misma habitación y la misma fecha.
    - `void mostrarReservas()`           //Muestra todas las reservas actuales.
- Excepción personalizada ConflictoReservaException: Se lanza cuando se intenta añadir una reserva que entra en conflicto con otra existente

**💻 En el main:**
- Crear varias habitaciones y varios clientes.
- Pedir por teclado los datos de una reserva (cliente, habitación, fecha inicio y fin).
- Crear el objeto Reserva y añadirlo al GestorReservas.
- Capturar posibles excepciones como:
  - DateTimeParseException (si introducen una fecha mal)
  - ConflictoReservaException (si ya hay una reserva para esa habitación y fechas)
  - Cualquier otra excepción de entrada (InputMismatchException, etc.)
