package sv.edu.ues.fia.pupuseria;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LicenciaActualizarActivity extends Activity {

    ControlDBPupuseria helper;

    EditText edit_tipo_licencia;
    EditText edit_numero_licencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licencia_actualizar);
        helper = new ControlDBPupuseria(this);
        edit_tipo_licencia=(EditText) findViewById(R.id.edit_tipo_licencia);
        edit_numero_licencia=(EditText) findViewById(R.id.edit_numero_licencia);
    }

    public void actualizarLicencia(View v) {
        String tipo_licencia = edit_tipo_licencia.getText().toString();
        String numero_licencia = edit_numero_licencia.getText().toString();
        Licencia licencia = new Licencia();
        licencia.setNumero_licencia(numero_licencia);
        licencia.setTipo_licencia(tipo_licencia);
        helper.abrir();
        String estado = helper.actualizarLicencia(licencia);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        edit_tipo_licencia.setText("");
        edit_numero_licencia.setText("");
    }
}