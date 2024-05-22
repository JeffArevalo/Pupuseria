package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiendaConsultarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdDirRead;
    EditText editIdTiendaRead;
    EditText editIdAdminRead;
    EditText editNomTiendaRead;
    EditText editTelTiendaRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_consultar);


        helper = new ControlDBPupuseria(this);

        editIdDirRead=(EditText) findViewById(R.id.editIdDirRetrv);
        editIdTiendaRead=(EditText) findViewById(R.id.editIdTiendaRetrv);
        editIdAdminRead=(EditText) findViewById(R.id.editIdAdminTiendaRetrv);
        editNomTiendaRead=(EditText) findViewById(R.id.editNomTiendaRetrv);
        editTelTiendaRead=(EditText) findViewById(R.id.editTelTiendaRetrv);
    }

    public void consultarTienda(View v) {
        helper.abrir();

        Tienda tiendaConsulta = helper.consultarTienda(Integer.parseInt(editIdTiendaRead.getText().toString()), Integer.parseInt(editIdDirRead.getText().toString()));

        helper.cerrar();

        if(tiendaConsulta==null){
            Toast.makeText(this, "Tienda no registrada o no existe", Toast.LENGTH_LONG).show();
        }else{
            editNomTiendaRead.setText(tiendaConsulta.getNombre_tienda());
            editTelTiendaRead.setText(tiendaConsulta.getTelefono_tienda());
            editIdAdminRead.setText(String.valueOf(tiendaConsulta.getAdministrador()));
        }
    }

    public void limpiarTxtConsultarTienda(View v) {
        editIdDirRead.setText("");
        editIdTiendaRead.setText("");
        editIdAdminRead.setText("");
        editNomTiendaRead.setText("");
        editTelTiendaRead.setText("");
    }
}