package modelo;

// Clase que guarda la reserva de una cita: precio base, adelanto (mínimo 50%) y saldo.
// Estado: "Pendiente" hasta que se registra un adelanto válido, luego "Confirmada".
public class Reserva {
    private Cita cita;
    private double precioBase;
    private double adelanto;
    private String estado;

    public Reserva(Cita cita) {
        this.cita = cita;
        this.precioBase = cita.getServicio().getPrecio(); // el precio viene del catálogo
        this.adelanto = 0;
        this.estado = "Pendiente";
    }

    public String getEstado() {
        return estado;
    }

    public Cita getCita() {
        return cita;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getAdelanto() {
        return adelanto;
    }

    // Solo guarda el adelanto si es mínimo el 50% del precio base y no pasa del
    // total
    public void registrarAdelanto(double monto) {
        double adelantoMinimo = precioBase * 50 / 100;

        if (monto < adelantoMinimo) {
            System.out.println("Adelanto inválido: debe ser mínimo S/ " + adelantoMinimo);
        } else if (monto > precioBase) {
            System.out.println("Adelanto inválido: no puede superar S/ " + precioBase);
        } else {
            adelanto = monto;
            estado = "Confirmada";
            System.out.println("Adelanto registrado: S/ " + adelanto);
        }
    }

    public double calcularSaldo() {
        return precioBase - adelanto;
    }

    public void mostrarComprobante() {
        System.out.println("--- COMPROBANTE DE RESERVA ---");
        cita.mostrarInformacion();
        System.out.println("Precio base: S/ " + precioBase);
        System.out.println("Adelanto: S/ " + adelanto);
        System.out.println("Saldo pendiente: S/ " + calcularSaldo());
        System.out.println("Estado: " + estado);
    }

    // Resumen corto para el listado de la agenda
    public void mostrarResumen() {
        System.out.println("Clienta: " + cita.getCliente().getNombre() + " "
                + cita.getCliente().getApellido());
        System.out.println("Cita: " + cita.getFecha() + " " + cita.getHora());
        System.out.println("Estado: " + estado);
        System.out.println("----------------------------------------");
    }
}