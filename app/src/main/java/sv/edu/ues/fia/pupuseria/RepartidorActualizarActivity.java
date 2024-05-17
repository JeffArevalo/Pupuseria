package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RepartidorActualizarActivity extends Activity {

    ControlDBPupuseria helper;
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
        setContentView(R.layout.activity_repartidor_actualizar);
        helper = new ControlDBPupuseria(this);
        edit_id_direccion = (EditText) findViewById(R.id.edit_id_direccion);
        edit_id_vehiculo = (EditText) findViewById(R.id.edit_id_vehiculo);
        edit_id_licencia = (EditText) findViewById(R.id.edit_id_licencia);
        edit_id_documento_identidad = (EditText) findViewById(R.id.edit_id_documento_identidad);
        edit_nombre_repartidor = (EditText) findViewById(R.id.edit_nombre_repartidor);
        edit_apellido_repartidor = (EditText) findViewById(R.id.edit_apellido_repartidor);
        edit_telefono_repartidor = (EditText) findViewById(R.id.edit_telefono_repartidor);
    }

    public void actualizarRepartidor(View v) {
        Repartidor repartidor= new Repartidor();
        repartidor.setId_direccion(Integer.parseInt(edit_id_direccion.getText().toString()));
        repartidor.setId_vehiculo(Integer.parseInt(edit_id_vehiculo.getText().toString()));
        repartidor.setId_licencia(Integer.parseInt(edit_id_licencia.getText().toString()));
        repartidor.setId_documento_identidad(Integer.parseInt(edit_id_documento_identidad.getText().toString()));
        repartidor.setNombre_repartidor(edit_nombre_repartidor.getText().toString());
        repartidor.setApellido_repartidor(edit_apellido_repartidor.getText().toString());
        repartidor.setTelefono_repartidor(edit_telefono_repartidor.getText().toString());
        helper.abrir();
        String estado = helper.actualizarRepartidor(repartidor);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

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