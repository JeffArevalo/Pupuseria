package sv.edu.ues.fia.pupuseria;

public class Tienda {

    //Atributos
    private int id_direccion;
    private int id_tienda;
    private int administrador;
    private String nombre_tienda;
    private String telefono_tienda;
    //Constructores

    public Tienda() {
    }

    public Tienda(int id_direccion, int id_tienda, int administrador, String nombre_tienda, String telefono_tienda) {
        this.id_direccion = id_direccion;
        this.id_tienda = id_tienda;
        this.administrador = administrador;
        this.nombre_tienda = nombre_tienda;
        this.telefono_tienda = telefono_tienda;
    }

    //getters and setters


    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getAdministrador() {
        return administrador;
    }

    public void setAdministrador(int administrador) {
        this.administrador = administrador;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getTelefono_tienda() {
        return telefono_tienda;
    }

    public void setTelefono_tienda(String telefono_tienda) {
        this.telefono_tienda = telefono_tienda;
    }
}
