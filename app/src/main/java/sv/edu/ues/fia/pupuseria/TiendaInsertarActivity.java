package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiendaInsertarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdDirInsrt;
    EditText editIdTiendaInsrt;
    EditText editIdAdminInsrt;
    EditText editNomTiendaInsrt;
    EditText editTelTiendaInsrt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_insertar);

        helper = new ControlDBPupuseria(this);

        editIdDirInsrt=(EditText) findViewById(R.id.editIdDirTiendaInsrt);
        editIdTiendaInsrt=(EditText) findViewById(R.id.editIdTiendaInsrt);
        editIdAdminInsrt=(EditText) findViewById(R.id.editIdAdminTiendaInsrt);
        editNomTiendaInsrt=(EditText) findViewById(R.id.editNomTiendaInsrt);
        editTelTiendaInsrt=(EditText) findViewById(R.id.editTelTiendaInsrt);
    }

    public void insertarTienda(View v) {
        String regInsrtTienda;
        String idDir = editIdDirInsrt.getText().toString();
        int idDirc = Integer.parseInt(idDir);
        String idTienda = editIdTiendaInsrt.getText().toString();
        int idTiendaC = Integer.parseInt(idTienda);
        String idAdmin = editIdAdminInsrt.getText().toString();
        int idAdminC = Integer.parseInt(idAdmin);
        String nomTienda = editNomTiendaInsrt.getText().toString();
        String telTienda = editTelTiendaInsrt.getText().toString();

        Tienda tiendaInsert = new Tienda();
        tiendaInsert.setId_direccion(idDirc);
        tiendaInsert.setId_tienda(idTiendaC);
        tiendaInsert.setAdministrador(idAdminC);
        tiendaInsert.setNombre_tienda(nomTienda);
        tiendaInsert.setTelefono_tienda(telTienda);

        helper.abrir();
        regInsrtTienda=helper.insertarTienda(tiendaInsert);
        helper.cerrar();
        Toast.makeText(this, regInsrtTienda, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTiendaTxtInsert(View v) {
        editIdDirInsrt.setText("");
        editIdTiendaInsrt.setText("");
        editIdAdminInsrt.setText("");
        editNomTiendaInsrt.setText("");
        editTelTiendaInsrt.setText("");
    }
}