package sv.edu.ues.fia.pupuseria;

public class Licencia {

    private String tipo_licencia;
    private String numero_licencia;

    public Licencia(){}
    public Licencia(String tipo_licencia, String numero_licencia){
        this.tipo_licencia = tipo_licencia;
        this.numero_licencia = numero_licencia;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

}
