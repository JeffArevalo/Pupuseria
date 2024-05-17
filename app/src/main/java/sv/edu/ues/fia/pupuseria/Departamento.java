package sv.edu.ues.fia.pupuseria;

public class Departamento {
    //Atributos
    private int idDepartamento;
    private String departamento;
    public Departamento(){
    }
    public Departamento(int idDepartamento, String departamento) {
        this.idDepartamento = idDepartamento;
        this.departamento = departamento;
    }
    //Get y set
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return idDepartamento + " - " + departamento;
    }

}
