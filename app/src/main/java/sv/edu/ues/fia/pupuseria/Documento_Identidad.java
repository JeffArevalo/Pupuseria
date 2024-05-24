package sv.edu.ues.fia.pupuseria;

public class Documento_Identidad {
    private int idDocumentoIdentidad;
    private String tipoDocumentoIdentidad;
    private String numeroDocumentoIdentidad;

    public Documento_Identidad() {}

    public Documento_Identidad(int idDocumentoIdentidad, String tipoDocumentoIdentidad, String numeroDocumentoIdentidad) {
        this.idDocumentoIdentidad = idDocumentoIdentidad;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public int getIdDocumentoIdentidad() {
        return idDocumentoIdentidad;
    }

    public void setIdDocumentoIdentidad(int idDocumentoIdentidad) {
        this.idDocumentoIdentidad = idDocumentoIdentidad;
    }

    public String getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }
}
