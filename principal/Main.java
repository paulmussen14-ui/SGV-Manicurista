package principal;

import java.util.ArrayList;
import java.util.List;

import modelo.Administrador;
import modelo.Cliente;
import modelo.ClienteVip;
import modelo.Manicurista;
import modelo.Persona;

public class Main {
    public static void main(String[] args) {
        //Prueba 1 =================================================================================================================================
        List<Persona> personas = new ArrayList<>();

        personas.add(new Administrador("Camile", "Flores", "999888777", "camile", "1234", true));
        personas.add(new Manicurista("Rosa", "Quispe", "988777666", "rosa", "abcd", true, "Acrílico"));
        personas.add(new Cliente("Ana", "Pérez", "977666555", "Nueva"));
        personas.add(new ClienteVip("Lucía", "Torres", "966555444", "Diseño gratis", 15));

        for (Persona p : personas) {
            System.out.println(p.getRol() + " -> " + p.getNombreCompleto());
        }
        //============================================================================================================================================
    }
}