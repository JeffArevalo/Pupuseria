package sv.edu.ues.fia.pupuseria;

public class Direccion {
    private int id;
    private int idDistrito;
    private String direccion;
    private String tipoDireccion; // Nuevo campo para el tipo de dirección

    public Direccion(int id, int idDistrito, String direccion, String tipoDireccion) {
        this.id = id;
        this.idDistrito = idDistrito;
        this.direccion = direccion;
        this.tipoDireccion = tipoDireccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    @Override
    public String toString() {
        return direccion;
    }
}
