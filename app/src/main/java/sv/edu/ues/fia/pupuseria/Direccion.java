package sv.edu.ues.fia.pupuseria;


public class Direccion {
    private int idDireccion;
    private int idDistrito;
    private String direccion;

    // Constructor vacío
    public Direccion() {}

    // Constructor con parámetros
    public Direccion(int idDireccion, int idDistrito, String direccion) {
        this.idDireccion = idDireccion;
        this.idDistrito = idDistrito;
        this.direccion = direccion;
    }

    // Métodos getter y setter
    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

