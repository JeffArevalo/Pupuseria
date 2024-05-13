package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VehiculoEliminarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText edit_placa_vehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo_eliminar);
        helper=new ControlDBPupuseria (this);
        edit_placa_vehiculo=(EditText)findViewById(R.id.edit_placa_vehiculo);
    }

    public void eliminarVehiculo(View v){
        String regEliminadas = " ";
        Vehiculo vehiculo=new Vehiculo();
        vehiculo.setPlaca_vehiculo(edit_placa_vehiculo.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminarVehiculo(vehiculo);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}