package sv.edu.ues.fia.pupuseria;

public class EventoEspecial {
    private int idEventoEspecial;
    private float montoMinimoEvento;
    private float montoMaximoEvento;

    public EventoEspecial() {
    }

    public EventoEspecial(int idEventoEspecial, float montoMinimoEvento, float montoMaximoEvento) {
        this.idEventoEspecial = idEventoEspecial;
        this.montoMinimoEvento = montoMinimoEvento;
        this.montoMaximoEvento = montoMaximoEvento;
    }

    public int getIdEventoEspecial() {
        return idEventoEspecial;
    }

    public void setIdEventoEspecial(int idEventoEspecial) {
        this.idEventoEspecial = idEventoEspecial;
    }

    public float getMontoMinimoEvento() {
        return montoMinimoEvento;
    }

    public void setMontoMinimoEvento(float montoMinimoEvento) {
        this.montoMinimoEvento = montoMinimoEvento;
    }

    public float getMontoMaximoEvento() {
        return montoMaximoEvento;
    }

    public void setMontoMaximoEvento(float montoMaximoEvento) {
        this.montoMaximoEvento = montoMaximoEvento;
    }
}
