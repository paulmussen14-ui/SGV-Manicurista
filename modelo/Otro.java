package modelo;

// Clase hija de Servicio: otros servicios del salón (reconstrucción de manos o pies).
public class Otro extends Servicio {

    public Otro(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override // cambia el tipo que devuelve el padre
    public String getTipo() {
        return "Otro";
    }
}