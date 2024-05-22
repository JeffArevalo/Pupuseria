package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiendaEliminarActivity extends Activity {

    EditText editIdDir, editIdTienda;
    ControlDBPupuseria helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_eliminar);

        helper = new ControlDBPupuseria(this);

        editIdDir=(EditText) findViewById(R.id.editIdDirTiendaDlt);
        editIdTienda=(EditText) findViewById(R.id.editIdTiendaDlt);
    }

    public void eliminarTienda(View v) {
        String regEliminados;
        Tienda tiendaDlt = new Tienda();
        tiendaDlt.setId_direccion(Integer.parseInt(editIdDir.getText().toString()));
        tiendaDlt.setId_tienda(Integer.parseInt(editIdTienda.getText().toString()));

        helper.abrir();
        regEliminados= helper.eliminarTienda(tiendaDlt);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}