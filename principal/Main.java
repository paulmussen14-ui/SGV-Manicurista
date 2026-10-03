package principal;

import modelo.Agenda;
import modelo.Catalogo;
import modelo.Cita;
import modelo.Cliente;
import modelo.ClienteVip;
import modelo.Factura;
import modelo.Reserva;
import modelo.Servicio;

// Programa principal: crea los objetos, llama a sus métodos y muestra los resultados.
public class Main {
    public static void main(String[] args) {
        Catalogo catalogo1 = new Catalogo();

        System.out.println("==============================================");
        System.out.println("1. CLIENTA NORMAL (clase Cliente)");
        Cliente cliente1 = new Cliente("Lucía", "Torres", "987654321", "Normal");
        cliente1.mostrarInformacion();

        System.out.println("==============================================");
        System.out.println("2. CLIENTA VIP (clase ClienteVip, hija de Cliente)");
        ClienteVip clienteVip1 = new ClienteVip("Camila", "Rojas", "912345678", "Atención prioritaria", 15);
        clienteVip1.mostrarInformacion();

        System.out.println("==============================================");
        System.out.println("3. SERVICIO TOMADO DEL CATÁLOGO (clase Servicio)");
        Servicio servicio1 = catalogo1.buscarServicio("Esmaltado en Gel");
        servicio1.mostrarInformacion();

        System.out.println("==============================================");
        System.out.println("4. EFECTO TOMADO DEL CATÁLOGO (clase Efecto, hija de Servicio)");
        Servicio efecto1 = catalogo1.buscarEfecto("Espejo");
        efecto1.mostrarInformacion();

        System.out.println("==============================================");
        System.out.println("5. OTRO SERVICIO TOMADO DEL CATÁLOGO (clase Otro, hija de Servicio)");
        Servicio otro1 = catalogo1.buscarOtro("Reconstrucción de manos");
        otro1.mostrarInformacion();

        System.out.println("==============================================");
        System.out.println("6. CITA DE LA CLIENTA VIP CON EL SERVICIO DEL PUNTO 3");
        Cita cita1 = new Cita(clienteVip1, servicio1, "10/10/2026", "15:00");
        cita1.mostrarInformacion();

        System.out.println("==============================================");
        System.out.println("7. RESERVA: PRUEBA DEL ADELANTO (mínimo 50% del precio base)");
        Reserva reserva1 = new Reserva(cita1);
        System.out.println("Probando un adelanto de S/ 10 (menor al 50%):");
        reserva1.registrarAdelanto(10);
        System.out.println("Probando un adelanto de S/ 20 (el 50%):");
        reserva1.registrarAdelanto(20);
        double saldo = reserva1.calcularSaldo();
        System.out.println("El saldo pendiente es: " + saldo);

        System.out.println("==============================================");
        System.out.println("8. COMPROBANTE DE LA RESERVA");
        reserva1.mostrarComprobante();

        System.out.println("==============================================");
        System.out.println("9. AGENDA: SE GUARDAN 2 RESERVAS Y SE LISTAN LAS PENDIENTES");
        Servicio acrilicas = catalogo1.buscarServicio("Acrílicas");
        Cita cita2 = new Cita(cliente1, acrilicas, "11/10/2026", "10:00");
        Reserva reserva2 = new Reserva(cita2);
        Agenda agenda1 = new Agenda();
        agenda1.agregar(reserva1);
        agenda1.agregar(reserva2);
        int pendientes = agenda1.mostrarPendientes();
        System.out.println("Reservas pendientes: " + pendientes);

        System.out.println("==============================================");
        System.out.println("10. FACTURA: FICHA DE SERVICIO CON VARIOS EFECTOS");
        Servicio efecto2 = catalogo1.buscarEfecto("Stickers");
        Servicio efecto3 = catalogo1.buscarEfecto("Pedrería");
        System.out.println("La clienta paga su adelanto de S/ 30 (50% del precio base de S/ 60):");
        reserva2.registrarAdelanto(30);
        Factura factura1 = new Factura(1, reserva2);
        factura1.setTamanoUña(6);
        factura1.agregarEfecto(efecto1);
        factura1.agregarEfecto(efecto2);
        factura1.agregarEfecto(efecto3);
        factura1.agregarReconstruccion(otro1, 2);
        factura1.aplicarDescuentoPorcentaje(10, "Cumpleaños", "Marie");
        factura1.registrarPago("Yape");
        factura1.mostrarFicha();
    }
}