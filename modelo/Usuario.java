package modelo;

import interfaces.Autenticable;

public abstract class Usuario extends Persona implements Autenticable {
    private String nombreUsuario;
    private String clave;
    private boolean activo;


    public Usuario(String nombre, String apellido, String telefono, String nombreUsuario, String clave,
            boolean activo) {
        super(nombre, apellido, telefono);
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.activo = activo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override 
    public boolean validarClave(String intento) {
        return activo && clave != null && clave.equals(intento);
    }


    
}
