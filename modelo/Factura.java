package modelo;

// Ficha de servicio de una cita: suma servicio, efectos, reconstrucción y recargo por tamaño,
// aplica descuento y registra el estado de pago (Pendiente o Pagado).
public class Factura {
    private int numero;
    private Reserva reserva;
    private Cita cita;
    private double precioServicio; // precio cobrado del servicio principal
    private int tamanoUña; // 1 a 20

    private Servicio[] efectos;
    private double[] preciosEfectos;
    private int cantidadEfectos;

    private Servicio otro; // reconstrucción (puede ser null)
    private int cantidadDedos;
    private double precioPorDedo;

    private double descuentoPorcentaje;
    private double descuentoMonto;
    private String motivoDescuento;
    private String autorizo;

    private String estado; // Pendiente o Pagado
    private String tipoPago;

    public Factura(int numero, Reserva reserva) {
        this.numero = numero;
        this.reserva = reserva;
        this.cita = reserva.getCita();
        this.precioServicio = reserva.getPrecioBase(); // el precio viene del catálogo
        this.tamanoUña = 1; // se define al finalizar el servicio

        this.efectos = new Servicio[19];
        this.preciosEfectos = new double[19];
        this.cantidadEfectos = 0;

        this.otro = null;
        this.cantidadDedos = 0;
        this.precioPorDedo = 0;

        this.descuentoPorcentaje = 0;
        this.descuentoMonto = 0;
        this.motivoDescuento = "";
        this.autorizo = "";

        this.estado = "Pendiente";
        this.tipoPago = "";
    }

    public int getNumero() {
        return numero;
    }

    public Cita getCita() {
        return cita;
    }

    public int getTamanoUña() {
        return tamanoUña;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    // Setters con validación
    public void setPrecioServicio(double precioServicio) {
        if (precioServicio >= 0) {
            this.precioServicio = precioServicio;
        }
    }

    public void setTamanoUña(int tamanoUña) {
        if (tamanoUña >= 1 && tamanoUña <= 20) {
            this.tamanoUña = tamanoUña;
        }
    }

    // Agrega un efecto (se pueden marcar varios); el precio viene del catálogo
    public boolean agregarEfecto(Servicio efecto) {
        if (cantidadEfectos < efectos.length) {
            efectos[cantidadEfectos] = efecto;
            preciosEfectos[cantidadEfectos] = efecto.getPrecio();
            cantidadEfectos++;
            return true;
        }
        return false;
    }

    // Agrega la reconstrucción (precio por dedo, tomado del catálogo)
    public boolean agregarReconstruccion(Servicio otro, int dedos) {
        if (dedos >= 1 && dedos <= 10) {
            this.otro = otro;
            this.cantidadDedos = dedos;
            this.precioPorDedo = otro.getPrecio();
            return true;
        }
        return false;
    }

    // Descuento en porcentaje
    public boolean aplicarDescuentoPorcentaje(double porcentaje, String motivo, String autorizo) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            this.descuentoPorcentaje = porcentaje;
            this.descuentoMonto = 0;
            this.motivoDescuento = motivo;
            this.autorizo = autorizo;
            return true;
        }
        return false;
    }

    // Descuento en soles
    public boolean aplicarDescuentoMonto(double monto, String motivo, String autorizo) {
        if (monto >= 0) {
            this.descuentoMonto = monto;
            this.descuentoPorcentaje = 0;
            this.motivoDescuento = motivo;
            this.autorizo = autorizo;
            return true;
        }
        return false;
    }

    // Registra el pago
    public void registrarPago(String tipoPago) {
        this.estado = "Pagado";
        this.tipoPago = tipoPago;
    }

    // Recargo por tamaño: 1 a 4 sin recargo, desde el 5 sube S/10 por número
    public double calcularRecargoTamano() {
        if (tamanoUña <= 4) {
            return 0;
        }
        return (tamanoUña - 4) * 10;
    }

    public double calcularTotalEfectos() {
        double total = 0;
        for (int i = 0; i < cantidadEfectos; i++) {
            total = total + preciosEfectos[i];
        }
        return total;
    }

    public double calcularTotalReconstruccion() {
        return cantidadDedos * precioPorDedo;
    }

    public double calcularSubtotal() {
        return precioServicio + calcularTotalEfectos()
                + calcularTotalReconstruccion() + calcularRecargoTamano();
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        double descuento = descuentoMonto + (subtotal * descuentoPorcentaje / 100);
        if (descuento > subtotal) {
            descuento = subtotal;
        }
        return descuento;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }

    // Saldo que falta pagar: total menos el adelanto de la reserva
    public double calcularSaldo() {
        double saldo = calcularTotal() - reserva.getAdelanto();
        if (saldo < 0) {
            saldo = 0;
        }
        return saldo;
    }

    // Muestra la ficha completa
    public void mostrarFicha() {
        Cliente cliente = cita.getCliente();

        System.out.println("======== FICHA DE SERVICIO N.º " + numero + " ========");
        System.out.println("MARIE NAILS");
        System.out.println("Fecha: " + cita.getFecha() + " " + cita.getHora());
        System.out.println("Clienta: " + cliente.getNombre() + " " + cliente.getApellido()
                + " - " + cliente.getTipoCliente());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("----------------------------------------");

        System.out.println(cita.getServicio().getNombre() + ": S/ " + precioServicio);

        for (int i = 0; i < cantidadEfectos; i++) {
            System.out.println(efectos[i].getNombre() + ": S/ " + preciosEfectos[i]);
        }

        if (otro != null) {
            System.out.println(otro.getNombre() + " (" + cantidadDedos + " dedos): S/ "
                    + calcularTotalReconstruccion());
        }

        System.out.println("Tamaño de uña " + tamanoUña + " (recargo): S/ " + calcularRecargoTamano());
        System.out.println("----------------------------------------");

        System.out.println("SUBTOTAL: S/ " + calcularSubtotal());
        System.out.println("DESCUENTO: S/ " + calcularDescuento());
        if (calcularDescuento() > 0) {
            System.out.println("Motivo: " + motivoDescuento + " | Autorizó: " + autorizo);
        }
        System.out.println("TOTAL COBRADO: S/ " + calcularTotal());
        System.out.println("Adelanto pagado (mínimo 50% del precio del servicio): S/ " + reserva.getAdelanto());
        System.out.println("SALDO A PAGAR: S/ " + calcularSaldo());
        System.out.println("----------------------------------------");
        System.out.print("Estado: " + estado);
        if (estado.equals("Pagado")) {
            System.out.print(" | Tipo de pago: " + tipoPago);
        }
        System.out.println();
    }
}