package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;

@SuppressLint("NewApi")
public class UsuarioInsertarWsActivity extends AppCompatActivity {
    private EditText idUsuario, idDireccion, idDocumentoIdentidad, nombreUsuario, apellidoUsuario, telefonoUsuario;
    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insert_usuario.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_insertar_ws);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        idUsuario = findViewById(R.id.idUsuario);
        idDireccion = findViewById(R.id.idDireccion);
        idDocumentoIdentidad = findViewById(R.id.idDocumentoIdentidad);
        nombreUsuario = findViewById(R.id.nombreUsuario);
        apellidoUsuario = findViewById(R.id.apellidoUsuario);
        telefonoUsuario = findViewById(R.id.telefonoUsuario);
    }

    public void insertarUsuario(View v) {
        int idUsuarioVal = Integer.parseInt(idUsuario.getText().toString());
        int idDireccionVal = Integer.parseInt(idDireccion.getText().toString());
        int idDocumentoIdentidadVal = Integer.parseInt(idDocumentoIdentidad.getText().toString());
        String nombreUsuarioVal = nombreUsuario.getText().toString().replace(" ", "%20");
        String apellidoUsuarioVal = apellidoUsuario.getText().toString().replace(" ", "%20");
        String telefonoUsuarioVal = telefonoUsuario.getText().toString().replace(" ", "%20");

        String url = urlHostingGratuito + "?ID_USUARIO=" + idUsuarioVal +
                "&ID_DIRECCION=" + idDireccionVal +
                "&ID_DOCUMENTO_IDENTIDAD=" + idDocumentoIdentidadVal +
                "&NOMBRE_USUARIO=" + nombreUsuarioVal +
                "&APELLIDO_USUARIO=" + apellidoUsuarioVal +
                "&TELEFONO_USUARIO=" + telefonoUsuarioVal;

        ControladorServicio.insertarUsuario(url, this);
    }

    public void limpiarTexto(View v) {
        idUsuario.setText("");
        idDireccion.setText("");
        idDocumentoIdentidad.setText("");
        nombreUsuario.setText("");
        apellidoUsuario.setText("");
        telefonoUsuario.setText("");
    }
}


