package modelo;

public class Manicurista extends Usuario {
    private String especialidad;

    public Manicurista(String nombre, String apellido, String telefono, String nombreUsuario, String clave,
            boolean activo, String especialidad) {
        super(nombre, apellido, telefono, nombreUsuario, clave, activo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override 
    public String getRol() {
        return "Manicurista";
    }

    
    
}
