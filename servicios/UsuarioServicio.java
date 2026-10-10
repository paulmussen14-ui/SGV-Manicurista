package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Administrador;
import modelo.Manicurista;
import modelo.Usuario;

public class UsuarioServicio {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean agregar(Usuario u) {
        if (buscarPorNombreUsuario(u.getNombreUsuario()) != null) {
            return false;
        }
        usuarios.add(u);
        return true;
    }

    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Usuario> listar() {
        return usuarios;
    }

    public void guardar(String ruta) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(ruta));
        for (Usuario u : usuarios) {
            String tipo = "ADMIN";
            String especialidad = "";
            if (u instanceof Manicurista) {
                tipo = "MANICURISTA";
                especialidad = ((Manicurista) u).getEspecialidad();
            }
            pw.println(tipo + ";" + u.getNombre() + ";" + u.getApellido() + ";"
                    + u.getTelefono() + ";" + u.getNombreUsuario() + ";"
                    + u.getClave() + ";" + u.isActivo() + ";" + especialidad);
        }
        pw.close();
    }

    public void cargar(String ruta) throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(ruta));
        } catch (IOException e) {
            return;
        }
        usuarios.clear();
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty())
                continue;
            String[] c = linea.split(";", -1);
            boolean activo = Boolean.parseBoolean(c[6]);
            if (c[0].equals("MANICURISTA")) {
                usuarios.add(new Manicurista(c[1], c[2], c[3], c[4], c[5], activo, c[7]));
            } else {
                usuarios.add(new Administrador(c[1], c[2], c[3], c[4], c[5], activo));
            }
        }
        br.close();
    }
}