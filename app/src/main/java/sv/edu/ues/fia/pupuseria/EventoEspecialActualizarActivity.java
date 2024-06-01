package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoEspecialActualizarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDEventoEspecial;
    EditText editIDEventoEspecial2;
    EditText editMontoMinimo;
    EditText editMontoMaximo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_especial_actualizar);

        helper = new ControlDBPupuseria(this);
        editIDEventoEspecial= (EditText) findViewById(R.id.editIDEventoEspecial);
        editIDEventoEspecial2 = (EditText) findViewById(R.id.editIDEventoEspecial2);
        editMontoMinimo = (EditText) findViewById(R.id.editmontoMinimo);
        editMontoMaximo = (EditText) findViewById(R.id.editmontoMaximo);
    }

    public void editarEventoEspecial(View v) {
        if (editIDEventoEspecial.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        }else {
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
    public void actualizarEventoEspecial(View v) {
        if (editIDEventoEspecial.getText().toString().trim().isEmpty() || editMontoMinimo.getText().toString().trim().isEmpty() ||
                editMontoMaximo.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            EventoEspecial evento = new EventoEspecial();
            evento.setIdEventoEspecial(Integer.parseInt(editIDEventoEspecial.getText().toString()));
            evento.setMontoMinimoEvento(Float.parseFloat(editMontoMinimo.getText().toString()));
            evento.setMontoMaximoEvento(Float.parseFloat(editMontoMaximo.getText().toString()));

            helper.abrir();
            String estado = helper.actualizarEventoEspecial(evento);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiarTexto(View v) {
        editIDEventoEspecial.setText("");
        editIDEventoEspecial2.setText("");
        editMontoMaximo.setText("");
        editMontoMinimo.setText("");
    }
}