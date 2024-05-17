package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoEspecialInsertarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDEventoEspecial;
    EditText editmontoMinimo;
    EditText editmontoMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_especial_insertar);

        helper = new ControlDBPupuseria(this);
        editIDEventoEspecial = (EditText) findViewById(R.id.editIDEventoEspecial2);
        editmontoMinimo = (EditText) findViewById(R.id.editmontoMinimo);
        editmontoMaximo = (EditText) findViewById(R.id.editmontoMaximo);
    }

    public void insertarEventoEspecial(View v) {
        int idEvento= Integer.parseInt(editIDEventoEspecial.getText().toString());
        float montoMinimo= Float.parseFloat(editmontoMinimo.getText().toString());
        float montoMaximo= Float.parseFloat(editmontoMaximo.getText().toString());

        String regInsertados;

        EventoEspecial evento = new EventoEspecial();
        evento.setIdEventoEspecial(idEvento);
        evento.setMontoMinimoEvento(montoMinimo);
        evento.setMontoMaximoEvento(montoMaximo);
        helper.abrir();
        regInsertados = helper.insertarEventoEspecial(evento);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editIDEventoEspecial.setText("");
        editmontoMinimo.setText("");
        editmontoMaximo.setText("");
    }

}