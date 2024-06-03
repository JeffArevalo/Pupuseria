package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class UsuarioEliminarWsActivity extends AppCompatActivity {
    private EditText idUsuario;
    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/eliminar_usuario.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_eliminar_ws);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        idUsuario = findViewById(R.id.idUsuario);
    }

    public void eliminarUsuario(View v) {
        String idUsuarioVal = idUsuario.getText().toString();
        String url = urlHostingGratuito + "?ID_USUARIO=" + idUsuarioVal;
        ControladorServicio.eliminarUsuario(url, this);
    }

    public void limpiarTexto(View v) {
        idUsuario.setText("");
    }
}
