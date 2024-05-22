package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DireccionInsertarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdDistrito, editDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_insertar);

        helper = new ControlDBPupuseria(this);
        editIdDistrito = findViewById(R.id.editIdDistrito);
        editDireccion = findViewById(R.id.editDireccion);

        Button buttonInsertar = findViewById(R.id.buttonInsertarDireccion);
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarDireccion();
            }
        });
    }

    public void insertarDireccion() {
        int idDistrito = Integer.parseInt(editIdDistrito.getText().toString());
        String direccion = editDireccion.getText().toString();

        Direccion dir = new Direccion(0, idDistrito, direccion);
        helper.abrir();
        String regInsertados = helper.insertarDireccion(dir);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

        limpiarCampos();
    }

    public void limpiarCampos() {
        editIdDistrito.setText("");
        editDireccion.setText("");
    }
}
