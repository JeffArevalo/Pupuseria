package sv.edu.ues.fia.pupuseria;

public class Usuario {
    private int idUsuario;
    private int idDireccion;
    private int idDocumentoIdentidad;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String telefonoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idDireccion, int idDocumentoIdentidad, String nombreUsuario, String apellidoUsuario, String telefonoUsuario) {
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
        this.idDocumentoIdentidad = idDocumentoIdentidad;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdDocumentoIdentidad() {
        return idDocumentoIdentidad;
    }

    public void setIdDocumentoIdentidad(int idDocumentoIdentidad) {
        this.idDocumentoIdentidad = idDocumentoIdentidad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
}
