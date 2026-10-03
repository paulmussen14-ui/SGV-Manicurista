package modelo;

// Clase padre: representa a una clienta del salón Marie Nails (nueva o normal).
public class Cliente {
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String tipoCliente; // "Nueva" o "Normal"

    public Cliente(String nombre, String apellido, String telefono, String tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    // Devuelve el porcentaje de descuento: Nueva 10%, Normal 0%
    public double getDescuento() {
        if (tipoCliente.equals("Nueva")) {
            return 10;
        } else {
            return 0;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Clienta: " + nombre + " " + apellido);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Tipo de clienta: " + tipoCliente);
        System.out.println("Descuento: " + getDescuento() + "%");
    }
}