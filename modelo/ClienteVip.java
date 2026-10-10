package modelo;

// Clase hija de Cliente: clienta VIP con beneficio y descuento propio.
public class ClienteVip extends Cliente {
    private String beneficio;
    private double porcentajeDescuento;

    public ClienteVip(String nombre, String apellido, String telefono,
            String beneficio, double porcentajeDescuento) {
        super(nombre, apellido, telefono, "VIP");
        this.beneficio = beneficio;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double getDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public String getRol() {
        return "Cliente VIP";
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " | Beneficio: " + beneficio;
    }
}