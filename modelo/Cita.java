package modelo;

// Clase que une a una clienta con un servicio en una fecha y hora.
public class Cita {
    private Cliente cliente;
    private Servicio servicio;
    private String fecha;
    private String hora;

    public Cita(Cliente cliente, Servicio servicio, String fecha, String hora) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void mostrarInformacion() {
        System.out.println("Clienta: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Servicio: " + servicio.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }
}