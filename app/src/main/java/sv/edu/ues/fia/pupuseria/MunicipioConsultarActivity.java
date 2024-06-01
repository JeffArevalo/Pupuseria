package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MunicipioConsultarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDMunicipio;
    EditText editIDMunicipio2;
    EditText editMunicipio;
    EditText editDepartamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_consultar);
        helper = new ControlDBPupuseria(this);
        editIDMunicipio= (EditText) findViewById(R.id.editIDMunicipio);
        editIDMunicipio2= (EditText) findViewById(R.id.editIDMunicipio2);
        editMunicipio = (EditText) findViewById(R.id.editnomMunicipio);
        editDepartamento= (EditText) findViewById(R.id.editIDDepartamento);
    }

    public void consultarMunicipio(View v) {
        if (editIDMunicipio.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            helper.abrir();
            Municipio municipio = helper.consultarMunicipio(Integer.parseInt(editIDMunicipio.getText().toString()));
            helper.cerrar();
            if (municipio == null)
                Toast.makeText(this, "El municipio" +
                        "Municipio con ID " + Integer.parseInt(editIDMunicipio.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIDMunicipio2.setText(String.valueOf(municipio.getIdMunicipio()));
                editMunicipio.setText(municipio.getMunicipio());
                editDepartamento.setText(String.valueOf(municipio.getIdDepartamento()));
            }
        }
    }

    public void limpiarTexto(View v) {
        editIDMunicipio.setText("");
        editIDMunicipio2.setText("");
        editMunicipio.setText("");
        editDepartamento.setText("");
    }
}