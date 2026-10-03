package modelo;

// Clase hija de Servicio: servicio de nail art con efecto especial.
public class Efecto extends Servicio {

    public Efecto(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override // cambia el tipo que devuelve el padre
    public String getTipo() {
        return "Efecto";
    }
}