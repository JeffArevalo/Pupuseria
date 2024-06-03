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
public class AdministradorInsertarWSActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_administrador_insertar_wsactivity);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder() .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editIdAdminSw = (EditText) findViewById(R.id.editIdAdminInsertWS);
        editNombreAdminSw = (EditText) findViewById(R.id.editNomAdminInsrtWS);
        editApellidoAdminSw = (EditText) findViewById(R.id.editApellidosAdminInsrtWS);
        editTelefonoAdminSw = (EditText) findViewById(R.id.editTelAdminInsrtWS);
    }

    public void insertarAdministrador(View view) {
        try{
            if(editIdAdminSw.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID Admin se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                int idAdminSW = Integer.parseInt(editIdAdminSw.getText().toString());
                String nomAdminSw = editNombreAdminSw.getText().toString();
                String apllAdminSw = editApellidoAdminSw.getText().toString();
                String telAdminSw = editTelefonoAdminSw.getText().toString();
                String nomModi = nomAdminSw.replace(" ", "%20");
                String AplModi = apllAdminSw.replace(" ", "%20");
                String telModi = telAdminSw.replace(" ", "%20");

                String url = null;
                JSONObject datosAdministrador = new JSONObject();
                JSONObject administrador = new JSONObject();

                url = urlHostingGratuito + "?ID_ADMINISTRADOR=" +idAdminSW + "?NOMBRE_ADMINISTRADOR=" + nomModi + "?APELLIDO_ADMINISTRADOR=" + AplModi + "?TELEFONO_ADMINISTRADOR=" + telModi;
                ControladorServicio.insertarFormaPago(url, this);
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Insertar", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View view) {

        editIdAdminSw.setText("");
        editNombreAdminSw.setText("");
        editApellidoAdminSw.setText("");
        editTelefonoAdminSw.setText("");

    }
}