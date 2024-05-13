package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VehiculoConsultarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText edit_tipo_vehiculo;
    EditText edit_placa_vehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo_consultar);
        helper = new ControlDBPupuseria(this);
        edit_tipo_vehiculo=(EditText) findViewById(R.id.edit_tipo_vehiculo);
        edit_placa_vehiculo=(EditText) findViewById(R.id.edit_placa_vehiculo);
    }

    public void consultarVehiculo(View v) {
        helper.abrir();
        Vehiculo vehiculo = helper.consultarVehiculo(edit_placa_vehiculo.getText().toString());
        helper.cerrar();
        if (vehiculo == null)
            Toast.makeText(this, "Numero de licencia: " +
                    edit_placa_vehiculo.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else {
            edit_tipo_vehiculo.setText(vehiculo.getTipo_vehiculo());
            edit_placa_vehiculo.setText(vehiculo.getPlaca_vehiculo());
        }
    }

    public void limpiarTexto(View v){
        edit_tipo_vehiculo.setText("");
        edit_placa_vehiculo.setText("");
    }

}