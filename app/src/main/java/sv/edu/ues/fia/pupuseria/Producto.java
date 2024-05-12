package sv.edu.ues.fia.pupuseria;

public class Producto {

    //Atributos
    private int id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private float precio_producto;
    private short estado_producto;

    //Constructores

    public Producto() {
    }

    public Producto(int id_producto, String nombre_producto, String descripcion_producto, float precio_producto, short estado_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.estado_producto = estado_producto;
    }

    //getters and setters


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public float getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(float precio_producto) {
        this.precio_producto = precio_producto;
    }

    public short getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(short estado_producto) {
        this.estado_producto = estado_producto;
    }
}
