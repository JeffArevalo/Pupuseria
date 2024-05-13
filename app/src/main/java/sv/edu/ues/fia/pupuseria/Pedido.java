package sv.edu.ues.fia.pupuseria;

public class Pedido {

    //ATRIBUTOS
    private int idPedido;
    private int idRepartidor;
    private int idUsuario;

    public Pedido(){
    }
    public Pedido(int idPedidoo, int idRepartidor, int idUsuario) {
        this.idPedido = idPedidoo;
        this.idRepartidor = idRepartidor;
        this.idUsuario = idUsuario;
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


    @Override
    public String toString() {
        return idPedido + " - usuario: " + idUsuario + " - repartidor: " + idRepartidor;
    }
}
