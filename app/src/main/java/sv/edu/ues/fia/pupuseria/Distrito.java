package sv.edu.ues.fia.pupuseria;

public class Distrito {

    private int idDistrito;


    private String distrito;
    private int idMunicipio;

    public Distrito(){
    }
    public Distrito(int idDistrito, String distrito, int idMunicipio ) {
        this.distrito = distrito;
        this.idDistrito = idDistrito;
        this.idMunicipio = idMunicipio;

    }
    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }
    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

}
