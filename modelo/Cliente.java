package modelo;
import interfaces.Descontable;

public class Cliente extends Persona implements Descontable {
    protected String tipoCliente;

    public Cliente(String nombre, String apellido, String telefono, String tipoCliente) {
        super(nombre, apellido, telefono);
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public double getDescuento() {
        if (tipoCliente.equals("Nueva")) {
            return 10;
        } else {
            return 0;
        }
    }

    @Override 
    public String getRol() {
        return "Cliente";
    }

    public String mostrarInformacion() {
        return getRol() + ": " + getNombreCompleto() + " | Tel: " + getTelefono() + " | Tipo: " + getTipoCliente() + " | Descuento: " + getDescuento() + "%";
    }
}
