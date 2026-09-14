# Sistema de Reserva y Pago – Marie Nails

## Descripción

El proyecto **Sistema de Reserva y Pago – Marie Nails** consiste en el desarrollo de un sistema de consola en Java para gestionar reservas de servicios de manicure, pedicure y nail art.

El sistema permite registrar los datos de la clienta, seleccionar el tipo de clienta y el sistema de uñas, ingresar los precios correspondientes, calcular el costo base, aplicar descuentos, validar el adelanto mínimo para confirmar la reserva y calcular el saldo pendiente.

En esta segunda entrega se incorporaron estructuras repetitivas, validaciones y arreglos para permitir el registro de varias reservas y realizar posteriormente un recorrido de las mismas.

## Objetivo

Desarrollar y verificar un sistema computacional aplicando algoritmos y estructuras de programación en Java, mejorando el código desarrollado en la primera entrega mediante estructuras repetitivas, validaciones y almacenamiento de reservas.

## Algoritmos implementados

### Selección y validación del tipo de clienta

Se implementó una estructura `do-while` para validar la selección del tipo de clienta. El sistema presenta tres opciones: Nueva, Normal y VIP. Si se ingresa una opción incorrecta, se solicita nuevamente la selección.

```java
String tipoCliente;

do {
    System.out.println("\nTipo de clienta:");
    System.out.println("1. Nueva");
    System.out.println("2. Normal");
    System.out.println("3. VIP");
    System.out.print("Seleccione una opción: ");

    int opcionCliente = entrada.nextInt();
    entrada.nextLine();

    if (opcionCliente == 1) {
        tipoCliente = "Nueva";

    } else if (opcionCliente == 2) {
        tipoCliente = "Normal";

    } else if (opcionCliente == 3) {
        tipoCliente = "VIP";

    } else {
        tipoCliente = "";
        System.out.println("Opción no válida.");
    }

} while (tipoCliente.equals(""));

Selección del sistema de uñas
También se implementó do-while para validar el sistema de uñas seleccionado. Las opciones disponibles son Manicure, Pedicure y Nail Art.

String tipoSistemaUñas;

do {
    System.out.println("\nTipo de sistema de uñas:");
    System.out.println("1. Manicure");
    System.out.println("2. Pedicure");
    System.out.println("3. Nail Art");
    System.out.print("Seleccione una opción: ");

    int opcionSistema = entrada.nextInt();
    entrada.nextLine();

    if (opcionSistema == 1) {
        tipoSistemaUñas = "Manicure";

    } else if (opcionSistema == 2) {
        tipoSistemaUñas = "Pedicure";

    } else if (opcionSistema == 3) {
        tipoSistemaUñas = "Nail Art";

    } else {
        tipoSistemaUñas = "";
        System.out.println("Opción no válida.");
    }

} while (tipoSistemaUñas.equals(""));

Cálculo del costo base
El costo base se calcula considerando la cantidad de servicios agregados, el precio de cada servicio y el precio del sistema de uñas.

double costoBase = (cantidadServicios * precioServicio) + precioSistemaUñas;
Aplicación de descuentos
El sistema aplica un descuento de acuerdo con el tipo de clienta:

Nueva: 10 %

Normal: 0 %

VIP: 15 %

if (tipoCliente.equals("Nueva")) {

    descuentoAnticipado = costoBase * 0.10;
    descripcionCliente = "Cliente Nueva";

} else if (tipoCliente.equals("Normal")) {

    descripcionCliente = "Cliente Normal";

} else if (tipoCliente.equals("VIP")) {

    descuentoAnticipado = costoBase * 0.15;
    descripcionCliente = "Cliente VIP";
}

double costoConDescuento = costoBase - descuentoAnticipado;
double totalPagar = costoConDescuento;

Validación del adelanto
Para confirmar la reserva se establece un adelanto mínimo equivalente al 50 % del total.

double adelantoMinimo = totalPagar * 0.50;

do {
    System.out.print("Ingrese el monto del adelanto S/.: ");
    montoAdelanto = entrada.nextDouble();

    if (montoAdelanto < adelantoMinimo) {

        System.out.println(
            "El adelanto debe ser como mínimo el 50% del total."
        );

    } else if (montoAdelanto > totalPagar) {

        System.out.println(
            "El adelanto no puede superar el total a pagar."
        );
    }

} while (montoAdelanto < adelantoMinimo
        || montoAdelanto > totalPagar);

double saldoPendiente = totalPagar - montoAdelanto;

Registro de varias reservas
Se implementó un ciclo do-while para permitir registrar varias reservas en una misma ejecución.

do {

    // Registro y procesamiento de la reserva

    System.out.print("\n¿Desea registrar otra reserva? (SI/NO): ");
    continuar = entrada.nextLine();

} while (continuar.equalsIgnoreCase("SI"));

Almacenamiento de reservas
Se utilizaron arreglos para almacenar la información de las reservas registradas.

String[] nombres = new String[100];
String[] tiposCliente = new String[100];
String[] sistemasUñas = new String[100];

double[] totales = new double[100];
double[] adelantos = new double[100];
double[] saldos = new double[100];

Recorrido de reservas mediante for
Se implementó una estructura for para realizar el recorrido de las reservas almacenadas

for (int i = 0; i < cantidadReservas; i++) {

    System.out.println("\nReserva N.º " + (i + 1));
    System.out.println("Clienta: " + nombres[i]);
    System.out.println("Tipo de clienta: " + tiposCliente[i]);
    System.out.println("Sistema de uñas: " + sistemasUñas[i]);

    System.out.println("Total: S/."
            + String.format("%.2f", totales[i]));

    System.out.println("Adelanto: S/."
            + String.format("%.2f", adelantos[i]));

    System.out.println("Saldo pendiente: S/."
            + String.format("%.2f", saldos[i]));
}

Comprobante de reserva
Después de registrar una reserva, el sistema genera un comprobante en consola con los principales datos de la operación:

Nombre de la clienta.

Tipo de clienta.

Sistema de uñas.

Cantidad de servicios.

Precio por servicio.

Costo base.

Descuento aplicado.

Total a pagar.

Adelanto realizado.

Saldo pendiente.

--- COMPROBANTE DE RESERVA ---

Clienta:                           Cliente Nueva
Sistema de uñas:                  Manicure
Cantidad de servicios reservados: 1
Precio por servicio:              S/.20.00
Costo base:                       S/.60.00
Descuento aplicado:               S/.6.00
Total a pagar:                    S/.54.00
Adelanto realizado:               S/.30.00
Saldo pendiente:                  S/.24.00

----------------------------------------
Reserva procesada correctamente.

Pruebas realizadas
Para verificar el funcionamiento del software se realizaron pruebas sobre las principales funcionalidades implementadas:

Validación del tipo de clienta: Se verificaron las opciones Nueva, Normal y VIP. Se comprobó que una opción incorrecta genere el mensaje de validación y permita realizar nuevamente la selección.

Validación del sistema de uñas: Se verificaron Manicure, Pedicure y Nail Art. Las opciones incorrectas son rechazadas solicitando una nueva selección.

Validación de descuentos: Se comprobó la correcta aplicación de los porcentajes correspondientes (10%, 0%, 15%).

Validación del adelanto: Se verificó que el sistema bloquee adelantos inferiores al 50% o superiores al total a pagar.

Registro de varias reservas: Se verificó el flujo continuo mediante do-while y la visualización final con el ciclo for.
<img width="663" height="369" alt="image" src="https://github.com/user-attachments/assets/ede0cf81-2624-45ad-a016-aa481063fc57" />
Tecnologías utilizadas
Java: Lenguaje de programación orientado a objetos.

Scanner: Clase para el ingreso de datos por consola.

Visual Studio Code: Entorno de desarrollo integrado (IDE).

Git: Sistema de control de versiones.

GitHub: Plataforma de almacenamiento y gestión de código fuente.

Conclusión
La segunda entrega permitió mejorar el sistema desarrollado inicialmente para Marie Nails mediante la implementación de estructuras repetitivas, validaciones y arreglos.

El uso de do-while permite controlar de manera eficiente las entradas de usuario y repetir el proceso de reserva, mientras que el ciclo for permite recorrer y mostrar de manera ordenada las reservas registradas. Asimismo, la validación del adelanto mínimo y el cálculo del saldo pendiente aseguran la robustez financiera y lógica del proceso de reserva y pago.

Con estas modificaciones, el sistema presenta una solución más estructurada, profesional y funcional para la gestión básica de reservas en Marie Nails.

Referencias bibliográficas
Oracle. The Java Tutorials – Learning the Java Language. Oracle.

Joyanes Aguilar, L. Fundamentos de programación: algoritmos, estructuras de datos y objetos. McGraw-Hill.
Autor:
Jean paul Moncada Nateros


