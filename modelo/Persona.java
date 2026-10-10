package modelo;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String telefono;


    public Persona(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }


    public abstract String getRol();

    @Override 
    public String toString() {
        return getRol() + ": " + getNombreCompleto() + " - Telefono: " + getTelefono();
    }

}
