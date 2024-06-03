package sv.edu.ues.fia.pupuseria;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
@SuppressLint("NewApi")
public class ServicioInsertarVehiculoActivity extends AppCompatActivity {
    EditText edit_id_vehiculo;
    EditText edit_tipo_vehiculo;
    EditText edit_placa_vehiculo;
    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insert_vehiculo.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_insertar_vehiculo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        edit_id_vehiculo = (EditText) findViewById(R.id.edit_id_vehiculo);
        edit_placa_vehiculo = (EditText) findViewById(R.id.edit_placa_vehiculo);
        edit_tipo_vehiculo = (EditText) findViewById(R.id.edit_tipo_vehiculo);
    }

    public void insertarVehiculoWS(View v){
        String id_vehiculo = edit_id_vehiculo.getText().toString();
        String tipo_vehiculo = edit_placa_vehiculo.getText().toString();
        String placa_vehiculo = edit_tipo_vehiculo.getText().toString();
        String url = null;
        JSONObject datosVehiculo = new JSONObject();
        JSONObject vehiculo = new JSONObject();
        url = urlHostingGratuito+ "?ID_VEHICULO=" + id_vehiculo + "&PLACA_VEHICULO=" + tipo_vehiculo + "&TIPO_VEHICULO=" + placa_vehiculo;
        ControladorServicio.insertarVehiculoWSC(url, this);
    }

    public void limpiarTexto(View v){
        edit_id_vehiculo.setText("");
        edit_placa_vehiculo.setText("");
        edit_tipo_vehiculo.setText("");
    }

}