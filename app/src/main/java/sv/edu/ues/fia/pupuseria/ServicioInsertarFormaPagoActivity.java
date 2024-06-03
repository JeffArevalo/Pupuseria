package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import org.json.JSONObject;
@SuppressLint("NewApi")
public class ServicioInsertarFormaPagoActivity extends AppCompatActivity {
    ControlDBPupuseria db;
    EditText editIDFormaPago;
    EditText editnomFormaPago;

    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insertar_forma_pago.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_insertar_forma_pago);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder() .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIDFormaPago = (EditText) findViewById(R.id.editIDFormaPago2);
        editnomFormaPago = (EditText) findViewById(R.id.editnomFormaPago);
    }

    public void insertarForma(View v) {
        int idFormapago = Integer.parseInt(editIDFormaPago.getText().toString());
        String nomFormapago = editnomFormaPago.getText().toString();
        String nombreModificado = nomFormapago.replace(" ", "%20");
        String url = null;
        JSONObject datosFormaPago = new JSONObject();
        JSONObject formapago = new JSONObject();
        url = urlHostingGratuito + "?ID_FORMAPAGO=" + idFormapago + "&NOMBRE_FORMAPAGO=" + nombreModificado;
        ControladorServicio.insertarFormaPago(url, this);
    }

    public void limpiarTexto(View v) {
        editIDFormaPago.setText("");
        editnomFormaPago.setText("");
    }
}