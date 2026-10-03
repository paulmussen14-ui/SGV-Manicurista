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

    @Override // la clienta VIP tiene su propio descuento (15%)
    public double getDescuento() {
        return porcentajeDescuento;
    }

    @Override // muestra lo del padre y agrega el beneficio
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Beneficio: " + beneficio);
    }
}