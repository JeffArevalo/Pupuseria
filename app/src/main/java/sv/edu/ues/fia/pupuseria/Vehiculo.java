package sv.edu.ues.fia.pupuseria;

public class Vehiculo {

    private String placa_vehiculo;
    private String tipo_vehiculo;

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public Vehiculo(){}

    public Vehiculo(String placa_vehiculo, String tipo_vehiculo){
        this.placa_vehiculo=placa_vehiculo;
        this.tipo_vehiculo=tipo_vehiculo;
    }

}
