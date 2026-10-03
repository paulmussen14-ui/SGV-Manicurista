package modelo;

// Clase padre: servicio que ofrece el salón (manicure, pedicure, etc.).
public class Servicio {
    protected String nombre;
    protected double precio;

    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return "Servicio";
    }

    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre);
        System.out.println("Tipo: " + getTipo());
        System.out.println("Precio: S/ " + precio);
    }
}