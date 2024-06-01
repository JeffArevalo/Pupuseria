package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoEspecialConsultarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDEventoEspecial;
    EditText editIDEventoEspecial2;
    EditText editMontoMinimo;
    EditText editMontoMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_especial_consultar);

        helper = new ControlDBPupuseria(this);
        editIDEventoEspecial= (EditText) findViewById(R.id.editIDEventoEspecial);
        editIDEventoEspecial2 = (EditText) findViewById(R.id.editIDEventoEspecial2);
        editMontoMinimo = (EditText) findViewById(R.id.editmontoMinimo);
        editMontoMaximo = (EditText) findViewById(R.id.editmontoMaximo);
    }


    public void consultarEventoEspecial(View v) {
        if (editIDEventoEspecial.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            helper.abrir();
            EventoEspecial evento = helper.consultarEventoEspecial(Integer.parseInt(editIDEventoEspecial.getText().toString()));
            helper.cerrar();
            if (evento == null)
                Toast.makeText(this, "El departamento con ID " + Integer.parseInt(editIDEventoEspecial.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIDEventoEspecial2.setText(String.valueOf(evento.getIdEventoEspecial()));
                editMontoMinimo.setText(String.valueOf(evento.getMontoMinimoEvento()));
                editMontoMaximo.setText(String.valueOf(evento.getMontoMaximoEvento()));
            }
        }
    }

    public void limpiarTexto(View v) {
        editIDEventoEspecial.setText("");
        editIDEventoEspecial2.setText("");
        editMontoMaximo.setText("");
        editMontoMinimo.setText("");
    }
}