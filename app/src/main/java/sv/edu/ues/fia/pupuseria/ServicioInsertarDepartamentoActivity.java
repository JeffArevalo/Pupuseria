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

public class ServicioInsertarDepartamentoActivity extends AppCompatActivity {
    EditText editIDDepartamento;
    EditText editnomDepartamento;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_insertar_departamento);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        editIDDepartamento = (EditText) findViewById(R.id.editIDDepartamento2);
        editnomDepartamento = (EditText) findViewById(R.id.editnomDepartamento);
    }

    public void insertarDepartamento(View v) {
        String iddepto = editIDDepartamento.getText().toString();
        String nomdepto = editnomDepartamento.getText().toString();
        String nombreModificado = nomdepto.replace(" ", "%20");

        if (editIDDepartamento.getText().toString().trim().isEmpty() || editnomDepartamento.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Ingrese los campos necesarios", Toast.LENGTH_LONG).show();
        } else {
            int idDepartamento = Integer.parseInt(iddepto);
            String url = null;
            JSONObject datosDepartamento = new JSONObject();
            JSONObject departamento = new JSONObject();
            String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insert_departamento.php";
            url = urlHostingGratuito + "?ID_DEPARTAMENTO=" + idDepartamento + "&NOM_DEPARTAMENTO=" + nombreModificado;
            ControladorServicio.insertarDepartamento(url, this);
        }
    }


    public void limpiarTexto(View v) {
        editIDDepartamento.setText("");
        editnomDepartamento.setText("");
    }
}