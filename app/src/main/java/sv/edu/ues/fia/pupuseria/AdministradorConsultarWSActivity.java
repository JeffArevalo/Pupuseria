package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.view.View;

@SuppressLint("NewApi")
public class AdministradorConsultarWSActivity extends AppCompatActivity {

    ControlDBPupuseria db;
    EditText editIdAdminSw;
    EditText editNombreAdminSw;
    EditText editApellidoAdminSw;
    EditText editTelefonoAdminSw;

    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/insert_administrador.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_consultar_wsactivity);


    }

    public void consultarAdministrador(View view) {
    }

    public void limpiarTxtCA(View view) {
    }
}