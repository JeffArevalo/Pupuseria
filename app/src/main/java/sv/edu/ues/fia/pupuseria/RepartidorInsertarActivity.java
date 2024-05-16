package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RepartidorInsertarActivity extends Activity {

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
        setContentView(R.layout.activity_repartidor_insertar);
        helper = new ControlDBPupuseria(this);
        edit_id_direccion = (EditText) findViewById(R.id.edit_id_direccion);
        edit_id_vehiculo = (EditText) findViewById(R.id.edit_id_vehiculo);
        edit_id_licencia = (EditText) findViewById(R.id.edit_id_licencia);
        edit_id_documento_identidad = (EditText) findViewById(R.id.edit_id_documento_identidad);
        edit_nombre_repartidor = (EditText) findViewById(R.id.edit_nombre_repartidor);
        edit_apellido_repartidor = (EditText) findViewById(R.id.edit_apellido_repartidor);
        edit_telefono_repartidor = (EditText) findViewById(R.id.edit_telefono_repartidor);
    }

    public void insertarRepartidor(View v) {
        String regInsertados = " ";
        String id_direccion= edit_id_direccion.getText().toString();
        String id_vehiculo=edit_id_vehiculo.getText().toString();
        String id_licencia=edit_id_licencia.getText().toString();
        String id_documento_identidad=edit_id_documento_identidad.getText().toString();
        String nombre_repartidor=edit_nombre_repartidor.getText().toString();
        String apellido_repartidor=edit_apellido_repartidor.getText().toString();
        String telefono_repartidor=edit_telefono_repartidor.getText().toString();

        Repartidor repartidor= new Repartidor();
        repartidor.setId_direccion(Integer.parseInt(id_direccion));
        repartidor.setId_vehiculo(Integer.parseInt(id_vehiculo));
        repartidor.setId_licencia(Integer.parseInt(id_licencia));
        repartidor.setId_documento_identidad(Integer.parseInt(id_documento_identidad));
        repartidor.setNombre_repartidor(nombre_repartidor);
        repartidor.setApellido_repartidor(apellido_repartidor);
        repartidor.setTelefono_repartidor(telefono_repartidor);
        helper.abrir();
        regInsertados=helper.insertarRepartidor(repartidor);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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