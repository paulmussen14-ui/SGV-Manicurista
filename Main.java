import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
         * PROYECTO: "Marie Nails" - Sistema de reserva y pago
         * (Salón de manicure, pedicure y nail art, con servicio a domicilio)
         * 
         * MODELO IPO
         * 
         * Entrada:
         * - Nombre de la clienta
         * - Tipo de clienta (Nueva, Normal, VIP)
         * - Tipo de sistema de uñas (Manicure, Pedicure, Nail Art)
         * - Precio por sistema de uñas
         * - Cantidad de servicios aplicados
         * - Precio por servicio
         * - Monto del adelanto
         * 
         * Proceso:
         * - Calcular costo base
         * - Calcular descuento según tipo de clienta
         * - Identificar tipo de sistema de uñas
         * - Calcular total a pagar
         * - Validar adelanto mínimo del 50%
         * - Calcular saldo pendiente
         * - Registrar reservas
         * 
         * Salida:
         * - Comprobante de la reserva
         * - Recorrido de las reservas registradas
         */

        //Entrada

        Scanner entrada = new Scanner(System.in);

        int anchoColumna = 35;

        String nombreCliente;
        String tipoCliente;
        String tipoSistemaUñas;

        int cantidadReservas = 0;
        String continuar;

        String[] nombres = new String[100];
        String[] tiposCliente = new String[100];
        String[] sistemasUñas = new String[100];

        double[] totales = new double[100];
        double[] adelantos = new double[100];
        double[] saldos = new double[100];

        System.out.println("\n====Bienvenida al sistema de reserva de Marie Nails====\n");

        do {

            System.out.println("\n========== REGISTRO DE RESERVA ==========\n");

            System.out.print("Ingrese el nombre del Cliente: ");
            nombreCliente = entrada.nextLine();

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

            System.out.print("\nIngrese el precio por sistema de uñas S/.: ");
            double precioSistemaUñas = entrada.nextDouble();

            System.out.print("Ingrese la cantidad de servicios Agregados: ");
            int cantidadServicios = entrada.nextInt();

            System.out.print("Ingrese el precio por servicio S/.: ");
            double precioServicio = entrada.nextDouble();

            // Procesos
            double costoBase = (cantidadServicios * precioServicio)
                    + precioSistemaUñas;

            double descuentoAnticipado = 0.0;
            String descripcionCliente;

            if (tipoCliente.equals("Nueva")) {

                descuentoAnticipado = costoBase * 0.10;
                descripcionCliente = "Cliente Nueva";

            } else if (tipoCliente.equals("Normal")) {

                descripcionCliente = "Cliente Normal";

            } else if (tipoCliente.equals("VIP")) {

                descuentoAnticipado = costoBase * 0.15;
                descripcionCliente = "Cliente VIP";

            } else {

                descripcionCliente = "No identificada";
            }

            if (tipoSistemaUñas.equals("Manicure")) {

                System.out.println("\nServicio de Manicure seleccionado.");

            } else if (tipoSistemaUñas.equals("Pedicure")) {

                System.out.println("\nServicio de Pedicure seleccionado.");

            } else if (tipoSistemaUñas.equals("Nail Art")) {

                System.out.println("\nServicio de Nail Art seleccionado.");
            }

            System.out.println("Costo base: S/."
                    + String.format("%.2f", costoBase));

            double costoConDescuento = costoBase - descuentoAnticipado;
            double totalPagar = costoConDescuento;

            System.out.println("Total a pagar: S/."
                    + String.format("%.2f", totalPagar));

            double adelantoMinimo = totalPagar * 0.50;
            double montoAdelanto;

            do {

                System.out.println("\nPara confirmar la reserva se requiere");
                System.out.println("un adelanto mínimo del 50%.");
                System.out.println("Adelanto mínimo: S/."
                        + String.format("%.2f", adelantoMinimo));

                System.out.print("Ingrese el monto del adelanto S/.: ");
                montoAdelanto = entrada.nextDouble();

                if (montoAdelanto < adelantoMinimo) {

                    System.out.println(
                            "El adelanto debe ser como mínimo el 50% del total.");

                } else if (montoAdelanto > totalPagar) {

                    System.out.println(
                            "El adelanto no puede superar el total a pagar.");
                }

            } while (montoAdelanto < adelantoMinimo
                    || montoAdelanto > totalPagar);

            double saldoPendiente = totalPagar - montoAdelanto;

            nombres[cantidadReservas] = nombreCliente;
            tiposCliente[cantidadReservas] = descripcionCliente;
            sistemasUñas[cantidadReservas] = tipoSistemaUñas;
            totales[cantidadReservas] = totalPagar;
            adelantos[cantidadReservas] = montoAdelanto;
            saldos[cantidadReservas] = saldoPendiente;

            cantidadReservas++;

            // Salida: comprobante de reserva
            System.out.println("\n--- COMPROBANTE DE RESERVA ---");

            System.out.printf("%-" + anchoColumna + "s%s (%s)\n",
                    "Clienta:",
                    nombreCliente,
                    descripcionCliente);

            System.out.printf("%-" + anchoColumna + "s%s\n",
                    "Sistema de uñas:",
                    tipoSistemaUñas);

            System.out.printf("%-" + anchoColumna + "s%d\n",
                    "Cantidad de servicios reservados:",
                    cantidadServicios);

            System.out.printf("%-" + anchoColumna + "sS/.%s\n",
                    "Precio por servicio:",
                    String.format("%.2f", precioServicio));

            System.out.printf("%-" + anchoColumna + "sS/.%s\n",
                    "Costo base:",
                    String.format("%.2f", costoBase));

            System.out.printf("%-" + anchoColumna + "sS/.%s\n",
                    "Descuento aplicado:",
                    String.format("%.2f", descuentoAnticipado));

            System.out.printf("%-" + anchoColumna + "sS/.%s\n",
                    "Total a pagar:",
                    String.format("%.2f", totalPagar));

            System.out.printf("%-" + anchoColumna + "sS/.%s\n",
                    "Adelanto realizado:",
                    String.format("%.2f", montoAdelanto));

            System.out.printf("%-" + anchoColumna + "sS/.%s\n",
                    "Saldo pendiente:",
                    String.format("%.2f", saldoPendiente));

            System.out.println("----------------------------------------");
            System.out.println("Reserva procesada correctamente.");

            entrada.nextLine();

            System.out.print("\n¿Desea registrar otra reserva? (SI/NO): ");
            continuar = entrada.nextLine();

        } while (continuar.equalsIgnoreCase("SI"));

        System.out.println("\n========================================");
        System.out.println("       RESERVAS REGISTRADAS");
        System.out.println("========================================");

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
            System.out.println("----------------------------------------");
        }

        System.out.println("\nGracias por utilizar el sistema de Marie Nails.");

        entrada.close();
    }
}