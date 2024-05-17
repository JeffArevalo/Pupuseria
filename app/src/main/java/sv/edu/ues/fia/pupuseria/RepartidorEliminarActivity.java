package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RepartidorEliminarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText edit_id_direccion;
    EditText edit_id_vehiculo;
    EditText edit_id_licencia;
    EditText edit_id_documento_identidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repartidor_eliminar);
        helper = new ControlDBPupuseria(this);
        edit_id_direccion = (EditText) findViewById(R.id.edit_id_direccion);
        edit_id_vehiculo = (EditText) findViewById(R.id.edit_id_vehiculo);
        edit_id_licencia = (EditText) findViewById(R.id.edit_id_licencia);
        edit_id_documento_identidad = (EditText) findViewById(R.id.edit_id_documento_identidad);
    }

    public void eliminarRepartidor(View v){
        String regEliminadas = " ";
        Repartidor repartidor= new Repartidor();
        repartidor.setId_direccion(Integer.parseInt(edit_id_direccion.getText().toString()));
        repartidor.setId_vehiculo(Integer.parseInt(edit_id_vehiculo.getText().toString()));
        repartidor.setId_licencia(Integer.parseInt(edit_id_licencia.getText().toString()));
        repartidor.setId_documento_identidad(Integer.parseInt(edit_id_documento_identidad.getText().toString()));
        helper.abrir();
        regEliminadas=helper.eliminarRepartidor(repartidor);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

    }
}