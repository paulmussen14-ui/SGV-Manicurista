package servicios;

import modelo.Efecto;
import modelo.Otro;
import modelo.Servicio;

// Guarda la lista de servicios, efectos y otros del salón, y permite buscarlos por nombre.
public class Catalogo {
    private Servicio[] servicios;
    private Servicio[] efectos;
    private Servicio[] otros;

    public Catalogo() {
        String[] nombresServicios = {
                "Acrílicas", "Rubber", "Poly Gel", "Soft Gel", "Builder Gel",
                "Híbridas", "Esculpidas", "Esmaltado en Gel", "Dipping",
                "Baño de Acrílico", "Retiro", "Pedicure en Gel",
                "Pedicure en Acrílico", "Pedicure Tradicional", "Pedicure Spa",
                "Pedicure Rubber", "Pedicure con Tips", "Pestañas 1x1", "Botox"
        };

        double[] preciosServicios = { 60, 75, 90, 70, 80, 80, 90, 40, 60, 60,
                20, 50, 70, 25, 50, 60, 65, 25, 50 };

        servicios = new Servicio[nombresServicios.length];
        for (int i = 0; i < nombresServicios.length; i++) {
            servicios[i] = new Servicio(nombresServicios[i], preciosServicios[i]);
        }

        String[] nombresEfectos = { "Espejo", "Ojo de Gato", "Aurora", "Camaleón", "Stickers",
                "Dijes", "Pedrería", "Flores en 3D", "Sellos",
                "Molde de Silicona", "Nail Art", "Baby Glitter", "Pigmentos",
                "Polvo", "Brillo", "Relieves", "Foil", "Baby Boomer", "Baby Glam" };

        double[] preciosEfectos = { 10, 15, 15, 15, 10, 10, 10, 15, 10, 15,
                20, 15, 10, 10, 10, 15, 15, 15, 15 };

        efectos = new Servicio[nombresEfectos.length];
        for (int i = 0; i < nombresEfectos.length; i++) {
            efectos[i] = new Efecto(nombresEfectos[i], preciosEfectos[i]);
        }

        otros = new Servicio[2];
        otros[0] = new Otro("Reconstrucción de manos", 5);
        otros[1] = new Otro("Reconstrucción de pies", 10);
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public Servicio[] getEfectos() {
        return efectos;
    }

    public Servicio[] getOtros() {
        return otros;
    }

    // Busca un servicio por nombre dentro de una lista (devuelve null si no existe)
    private Servicio buscar(Servicio[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getNombre().equalsIgnoreCase(nombre)) {
                return lista[i];
            }
        }
        return null;
    }

    public Servicio buscarServicio(String nombre) {
        return buscar(servicios, nombre);
    }

    public Servicio buscarEfecto(String nombre) {
        return buscar(efectos, nombre);
    }

    public Servicio buscarOtro(String nombre) {
        return buscar(otros, nombre);
    }

    public void mostrarLista(Servicio[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("  " + lista[i].getNombre() + " - S/ " + lista[i].getPrecio());
        }
    }
}