package sv.edu.ues.fia.pupuseria;

public class Repartidor {

    private int id_direccion;
    private int id_vehiculo;
    private int id_licencia;
    private int id_documento_identidad;
    private String nombre_repartidor;
    private String apellido_repartidor;
    private String telefono_repartidor;

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_licencia() {
        return id_licencia;
    }

    public void setId_licencia(int id_licencia) {
        this.id_licencia = id_licencia;
    }

    public int getId_documento_identidad() {
        return id_documento_identidad;
    }

    public void setId_documento_identidad(int id_documento_identidad) {
        this.id_documento_identidad = id_documento_identidad;
    }

    public String getNombre_repartidor() {
        return nombre_repartidor;
    }

    public void setNombre_repartidor(String nombre_repartidor) {
        this.nombre_repartidor = nombre_repartidor;
    }

    public String getApellido_repartidor() {
        return apellido_repartidor;
    }

    public void setApellido_repartidor(String apellido_repartidor) {
        this.apellido_repartidor = apellido_repartidor;
    }

    public String getTelefono_repartidor() {
        return telefono_repartidor;
    }

    public void setTelefono_repartidor(String telefono_repartidor) {
        this.telefono_repartidor = telefono_repartidor;
    }

    public Repartidor(){}

    public Repartidor(int id_direccion,int id_vehiculo,int id_licencia,int id_documento_identidad,String nombre_repartidor,String apellido_repartidor, String telefono_repartidor){
        this.id_direccion = id_direccion;
        this.id_vehiculo = id_vehiculo;
        this.id_licencia = id_licencia;
        this.id_documento_identidad = id_documento_identidad;
        this.nombre_repartidor = nombre_repartidor;
        this.apellido_repartidor = apellido_repartidor;
        this.telefono_repartidor = telefono_repartidor;
    }

}
