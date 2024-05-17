package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LicenciaConsultarActivity extends Activity {

    ControlDBPupuseria helper;

    EditText edit_tipo_licencia;
    EditText edit_numero_licencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licencia_consultar);
        helper = new ControlDBPupuseria(this);
        edit_tipo_licencia=(EditText) findViewById(R.id.edit_tipo_licencia);
        edit_numero_licencia=(EditText) findViewById(R.id.edit_numero_licencia);
    }

    public void consultarLicencia(View v) {
        helper.abrir();
        Licencia licencia = helper.consultarLicencia(edit_numero_licencia.getText().toString());
        helper.cerrar();
        if (licencia == null)
            Toast.makeText(this, "Numero de licencia: " +
                    edit_numero_licencia.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else {
            edit_tipo_licencia.setText(licencia.getTipo_licencia());
            edit_numero_licencia.setText(licencia.getNumero_licencia());
        }
    }

    public void limpiarTexto(View v){
        edit_tipo_licencia.setText("");
        edit_numero_licencia.setText("");
    }

}