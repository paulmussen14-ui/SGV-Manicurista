package pruebas;

import modelo.Cliente;
import modelo.ClienteVip;

public class PruebaDescuento {
    public static void main(String[] args) {
        Cliente nueva = new Cliente("Ana", "Pérez", "977666555", "Nueva");
        Cliente vip = new ClienteVip("Lucía", "Torres", "966555444", "Diseño gratis", 15);

        verificar("Clienta nueva tiene 10%", 10, nueva.getDescuento());
        verificar("Clienta VIP tiene 15%", 15, vip.getDescuento());
    }

    static void verificar(String nombre, double esperado, double obtenido) {
        if (esperado == obtenido) {
            System.out.println("OK    - " + nombre);
        } else {
            System.out.println("FALLA - " + nombre + " (esperado " + esperado + ", obtenido " + obtenido + ")");
        }
    }
}