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
public class ServicioInsertarLicenciaActivity extends AppCompatActivity {
    EditText edit_id_licencia;
    EditText edit_tipo_licencia;
    EditText edit_numero_licencia;
    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insert_licencia.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_insertar_licencia);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        edit_id_licencia = (EditText) findViewById(R.id.edit_id_licencia);
        edit_numero_licencia = (EditText) findViewById(R.id.edit_numero_licencia);
        edit_tipo_licencia = (EditText) findViewById(R.id.edit_tipo_licencia);

    }
        public void insertarLicenciaWS(View v){
        String id_licencia = edit_id_licencia.getText().toString();
        String tipo_licencia = edit_tipo_licencia.getText().toString();
        String numero_licencia = edit_numero_licencia.getText().toString();
        String url = null;
        JSONObject datosLicencia = new JSONObject();
        JSONObject nota = new JSONObject();
        url = urlHostingGratuito+ "?ID_LICENCIA=" + id_licencia + "&NUMERO_LICENCIA=" + tipo_licencia + "&TIPO_LICENCIA=" + numero_licencia;
        ControladorServicio.insertarLicenciaWSC(url, this);
    }
    public void limpiarTexto(View v){
        edit_id_licencia.setText("");
        edit_tipo_licencia.setText("");
        edit_numero_licencia.setText("");
    }
}