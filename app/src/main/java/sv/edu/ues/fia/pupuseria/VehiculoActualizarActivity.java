package sv.edu.ues.fia.pupuseria;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VehiculoActualizarActivity extends Activity {


    ControlDBPupuseria helper;

    EditText edit_tipo_vehiculo;
    EditText edit_placa_vehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo_actualizar);

        helper = new ControlDBPupuseria(this);

        edit_tipo_vehiculo=(EditText) findViewById(R.id.edit_tipo_vehiculo);
        edit_placa_vehiculo=(EditText) findViewById(R.id.edit_placa_vehiculo);
    }

    public void actualizarVehiculo(View v) {
        String tipo_vehiculo = edit_tipo_vehiculo.getText().toString();
        String placa_vehiculo = edit_placa_vehiculo.getText().toString();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setTipo_vehiculo(tipo_vehiculo);
        vehiculo.setPlaca_vehiculo(placa_vehiculo);
        helper.abrir();
        String estado = helper.actualizarVehiculo(vehiculo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();

    }

}