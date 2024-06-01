package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DistritoConsultarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDDistrito;
    EditText editIDDistrito2;
    EditText editDistrito;
    EditText editIDMunicipio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrito_consultar);

        helper = new ControlDBPupuseria(this);
        editIDDistrito= (EditText) findViewById(R.id.editIDDistrito);
        editIDDistrito2= (EditText) findViewById(R.id.editIDDistrito2);
        editDistrito = (EditText) findViewById(R.id.editnomDistrito);
        editIDMunicipio= (EditText) findViewById(R.id.editIDMunicipio);
    }

    public void consultarDistrito(View v) {
        if (editIDDistrito.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            helper.abrir();
            Distrito distrito = helper.consultarDistrito(Integer.parseInt(editIDDistrito.getText().toString()));
            helper.cerrar();
            if (distrito == null)
                Toast.makeText(this, "El distrito" +
                        "Distrito con ID " + Integer.parseInt(editIDDistrito.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIDDistrito2.setText(String.valueOf(distrito.getIdDistrito()));
                editDistrito.setText(distrito.getDistrito());
                editIDMunicipio.setText(String.valueOf(distrito.getIdMunicipio()));
            }
        }
    }

    public void limpiarTexto(View v) {
        editIDMunicipio.setText("");
        editIDDistrito2.setText("");
        editDistrito.setText("");
        editIDDistrito2.setText("");
    }
}