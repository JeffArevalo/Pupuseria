package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
@SuppressLint("NewApi")
public class ServicioInsertarMunicipioActivity extends AppCompatActivity {
    EditText editIDMunicipio;
    EditText editnomMunicipio;
    EditText editIDDepartamento;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_insertar_municipio);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIDMunicipio = (EditText) findViewById(R.id.editIDMunicipio);
        editIDDepartamento = (EditText) findViewById(R.id.editIDDepartamento);
        editnomMunicipio = (EditText) findViewById(R.id.editnomMunicipio);
    }

    public void insertarMunicipio(View v) {
        String idmunicipio = editIDMunicipio.getText().toString();
        String nommun = editnomMunicipio.getText().toString();
        String nombreModificado = nommun.replace(" ", "%20");
        String iddepto = editIDDepartamento.getText().toString();

        if (editIDMunicipio.getText().toString().trim().isEmpty() || editnomMunicipio.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            int idMunicipio = Integer.parseInt(idmunicipio);
            int idDepartamento = Integer.parseInt(iddepto);
            String url = null;
            JSONObject datosMunicipio = new JSONObject();
            JSONObject municipio = new JSONObject();
            String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insert_municipio.php";
            url = urlHostingGratuito + "?ID_MUNICIPIO=" + idMunicipio + "&NOM_MUNICIPIO=" + nombreModificado +
            "&ID_DEPARTAMENTO=" + idDepartamento;
            ControladorServicio.insertarMunicipio(url, this);
        }
    }


    public void limpiarTexto(View v) {
        editIDDepartamento.setText("");
        editnomMunicipio.setText("");
        editIDDepartamento.setText("");
    }
}