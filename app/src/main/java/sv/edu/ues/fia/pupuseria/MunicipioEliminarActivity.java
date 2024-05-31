package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MunicipioEliminarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDMunicipio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_eliminar);
        helper =new ControlDBPupuseria(this);
        editIDMunicipio=(EditText)findViewById(R.id.editIDMunicipio);
    }

    public void eliminarMunicipio(View v){
        if (editIDMunicipio.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            String regEliminadas;
            Municipio municipio = new Municipio();
            municipio.setIdMunicipio(Integer.parseInt(editIDMunicipio.getText().toString()));
            helper.abrir();
            regEliminadas = helper.eliminarMunicipio(municipio);
            helper.cerrar();
            Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        }
    }
}