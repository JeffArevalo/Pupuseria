package sv.edu.ues.fia.pupuseria;

public class Administrador {

    //Atributos
    private int id_administrador;
    private String nombre_administrador;
    private String apellido_administrador;
    private String telefono_administrador;
    //Constructores

    public Administrador() {
    }

    public Administrador(int id_administrador, String nombre_administrador, String apellido_administrador, String telefono_administrador) {
        this.id_administrador = id_administrador;
        this.nombre_administrador = nombre_administrador;
        this.apellido_administrador = apellido_administrador;
        this.telefono_administrador = telefono_administrador;
    }

    //getters and setters


    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    public String getApellido_administrador() {
        return apellido_administrador;
    }

    public void setApellido_administrador(String apellido_administrador) {
        this.apellido_administrador = apellido_administrador;
    }

    public String getTelefono_administrador() {
        return telefono_administrador;
    }

    public void setTelefono_administrador(String telefono_administrador) {
        this.telefono_administrador = telefono_administrador;
    }
}
