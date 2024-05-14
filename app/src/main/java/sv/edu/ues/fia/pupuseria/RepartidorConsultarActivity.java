package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RepartidorConsultarActivity extends Activity {

    //ControlBDCarnet helper;
    EditText edit_id_direccion;
    EditText edit_id_vehiculo;
    EditText edit_id_licencia;
    EditText edit_id_documento_identidad;
    EditText edit_nombre_repartidor;
    EditText edit_apellido_repartidor;
    EditText edit_telefono_repartidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repartidor_consultar);
        //helper = new ControlBDCarnet(this);
        edit_id_direccion = (EditText) findViewById(R.id.edit_id_direccion);
        edit_id_vehiculo = (EditText) findViewById(R.id.edit_id_vehiculo);
        edit_id_licencia = (EditText) findViewById(R.id.edit_id_licencia);
        edit_id_documento_identidad = (EditText) findViewById(R.id.edit_id_documento_identidad);
        edit_nombre_repartidor = (EditText) findViewById(R.id.edit_nombre_repartidor);
        edit_apellido_repartidor = (EditText) findViewById(R.id.edit_apellido_repartidor);
        edit_telefono_repartidor = (EditText) findViewById(R.id.edit_telefono_repartidor);
    }

    /*public void consultarNota(View v) {
        helper.abrir();
        Repartidor repartidor = helper.consultarNota(edit_id_vehiculo.getText().toString(),edit_id_licencia.getText().toString(), edit_id_documento_identidad.getText().toString());
        helper.cerrar();
        if(repartidor == null)
            Toast.makeText(this, "Nota no registrada",
                    Toast.LENGTH_LONG).show();
        else{
            edit_nombre_repartidor.setText(String.valueOf(repartidor.getNombre_repartidor()));
        }
    }*/

    public void limpiarTexto(View v) {
        edit_id_direccion.setText("");
        edit_id_vehiculo.setText("");
        edit_id_licencia.setText("");
        edit_id_documento_identidad.setText("");
        edit_nombre_repartidor.setText("");
        edit_apellido_repartidor.setText("");
        edit_telefono_repartidor.setText("");
    }

}