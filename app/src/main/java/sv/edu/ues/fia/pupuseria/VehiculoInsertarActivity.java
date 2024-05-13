package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VehiculoInsertarActivity extends Activity {

    //ControlBDee19001 helper;
    EditText edit_tipo_vehiculo;
    EditText edit_placa_vehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo_insertar);
        edit_placa_vehiculo = (EditText) findViewById(R.id.edit_placa_vehiculo);
        edit_tipo_vehiculo = (EditText) findViewById(R.id.edit_tipo_vehiculo);
    }

    public void insertarVehiculo(View v){
        String placa_vehiculo = edit_placa_vehiculo.getText().toString();
        String tipo_vehiculo = edit_tipo_vehiculo.getText().toString();
        String regInsertados = " ";
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setTipo_vehiculo(tipo_vehiculo);
        vehiculo.setPlaca_vehiculo(placa_vehiculo);
        //base de datos
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }


}