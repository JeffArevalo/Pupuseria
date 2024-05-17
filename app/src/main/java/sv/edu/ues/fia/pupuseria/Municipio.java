package sv.edu.ues.fia.pupuseria;

public class Municipio {

    private int idMunicipio;
    private String municipio;
    private int idDepartamento;

    public Municipio(){
    }
    public Municipio(int idMunicipio, String municipio, int idDepartamento) {
        this.idMunicipio = idMunicipio;
        this.municipio = municipio;
        this.idDepartamento = idDepartamento;
    }
    //GET Y SET
    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio= idMunicipio;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }


    @Override
    public String toString() {
        return idMunicipio + " - Municipio: " + municipio + " - Departamento: " + idDepartamento;
    }
}
