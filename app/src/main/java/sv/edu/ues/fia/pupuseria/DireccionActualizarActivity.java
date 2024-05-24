package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DireccionActualizarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdDireccion, editIdDistrito, editDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_actualizar);

        helper = new ControlDBPupuseria(this);
        editIdDireccion = findViewById(R.id.editIdDireccion);
        editIdDistrito = findViewById(R.id.editIdDistrito);
        editDireccion = findViewById(R.id.editDireccion);

        Button buttonActualizar = findViewById(R.id.buttonActualizarDireccion);
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDireccion();
            }
        });
    }

    public void actualizarDireccion() {
        int idDireccion = Integer.parseInt(editIdDireccion.getText().toString());
        int idDistrito = Integer.parseInt(editIdDistrito.getText().toString());
        String direccion = editDireccion.getText().toString();

        Direccion dir = new Direccion(idDireccion, idDistrito, direccion);
        helper.abrir();
        String regAfectados = helper.actualizarDireccion(dir);
        helper.cerrar();
        Toast.makeText(this, regAfectados, Toast.LENGTH_SHORT).show();

        limpiarCampos();
    }

    public void limpiarCampos() {
        editIdDireccion.setText("");
        editIdDistrito.setText("");
        editDireccion.setText("");
    }
}
