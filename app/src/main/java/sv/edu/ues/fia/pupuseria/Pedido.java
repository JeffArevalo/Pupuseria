package sv.edu.ues.fia.pupuseria;
import android.os.Parcel;
import android.os.Parcelable;

public class Pedido {

    //ATRIBUTOS
    private int idPedido;
    private int idEventoEspecial;
    private int idRepartidor;
    private int idUsuario;
    private float total;
    private int estado;
    public Pedido(){
    }
    public Pedido(int idPedidoo, int idRepartidor, int idUsuario) {
        this.idPedido = idPedidoo;
        this.idRepartidor = idRepartidor;
        this.idUsuario = idUsuario;
    }
    public Pedido(int idPedidoo,int idEventoEspecial, int idRepartidor, int idUsuario, float total, int estado) {
        this.idPedido = idPedidoo;
        this.idEventoEspecial = idEventoEspecial;
        this.idRepartidor = idRepartidor;
        this.idUsuario = idUsuario;
        this.total = total;
        this.estado = estado;
    }


    //GET Y SET
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getIdRepartidor() {
        return idRepartidor;
    }
    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdEventoEspecial() {
        return idEventoEspecial;
    }

    public void setIdEventoEspecial(int idEventoEspecial) {
        this.idEventoEspecial = idEventoEspecial;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return idPedido + " - usuario: " + idUsuario + " - repartidor: " + idRepartidor;
    }
}
