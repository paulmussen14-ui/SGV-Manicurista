package modelo;

// Guarda las reservas del salón y permite buscarlas y listar las pendientes.
// El arreglo es privado: solo se accede a él mediante los métodos de la clase.
public class Agenda {
    private Reserva[] reservas;
    private int cantidad;

    public Agenda() {
        this.reservas = new Reserva[100];
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Agrega una reserva (devuelve false si la agenda está llena)
    public boolean agregar(Reserva reserva) {
        if (cantidad < reservas.length) {
            reservas[cantidad] = reserva;
            cantidad++;
            return true;
        }
        return false;
    }

    // Busca por número de reserva (devuelve null si no existe)
    public Reserva buscar(int numero) {
        if (numero >= 1 && numero <= cantidad) {
            return reservas[numero - 1];
        }
        return null;
    }

    // Muestra las reservas pendientes y devuelve cuántas hay
    public int mostrarPendientes() {
        int encontradas = 0;
        for (int i = 0; i < cantidad; i++) {
            if (reservas[i].getEstado().equals("Pendiente")) {
                reservas[i].mostrarResumen();
                encontradas++;
            }
        }
        return encontradas;
    }
}