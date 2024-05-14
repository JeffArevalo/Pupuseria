package sv.edu.ues.fia.pupuseria;

import java.sql.Timestamp;
import java.util.Date;

public class Venta {
    //ATRIBUTOS
    private int idVenta;
    private int idPedido;
    private int idDireccion;
    private int idFormaPago;
    private double monto;
    private Date fecha;
    private Timestamp hora;

    public Venta(){
    }

    public Venta(int idVenta, int idPedido, int idDireccion,int idFormaPago, double monto,Date fecha,Timestamp hora ) {
        this.idVenta = idVenta;
        this.idPedido = idPedido;
        this.idDireccion = idDireccion;
        this.idFormaPago = idFormaPago;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
    }

    //GET Y SET

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    public int getIdDireccion() {
        return idDireccion;
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }
}
