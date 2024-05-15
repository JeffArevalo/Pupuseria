package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LicenciaInsertarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText edit_tipo_licencia;
    EditText edit_numero_licencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licencia_insertar);
        helper=new ControlDBPupuseria (this);
        edit_tipo_licencia=(EditText) findViewById(R.id.edit_tipo_licencia);
        edit_numero_licencia=(EditText) findViewById(R.id.edit_numero_licencia);
    }

    public void insertarLicencia(View v){
        String tipo_licencia = edit_tipo_licencia.getText().toString();
        String numero_licencia = edit_numero_licencia.getText().toString();
        String regInsertados = " ";
        Licencia licencia = new Licencia();
        licencia.setTipo_licencia(tipo_licencia);
        licencia.setNumero_licencia(numero_licencia);
        helper.abrir();
        regInsertados = helper.insertarLicencia(licencia);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

}