package sv.edu.ues.fia.pupuseria;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EditarUsuarioActivity extends AppCompatActivity {

    private EditText editUsuario, editNombre, editApellido, editTelefono, editDocumentoIdentidad, editDireccion;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        // Inicializa los campos de edición
        editUsuario = findViewById(R.id.editUsuario);
        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editTelefono = findViewById(R.id.editTelefono);
        editDocumentoIdentidad = findViewById(R.id.editDocumentoIdentidad);
        editDireccion = findViewById(R.id.editDireccion);

        // Encuentra el botón de guardar
        btnGuardar = findViewById(R.id.btnGuardar);

        // Agrega un OnClickListener al botón de guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama al método para guardar los cambios
                saveUserDetails();
            }
        });
    }

    private void saveUserDetails() {
        // Obtiene los datos de los campos de edición
        String usuario = editUsuario.getText().toString();
        String nombre = editNombre.getText().toString();
        String apellido = editApellido.getText().toString();
        String telefono = editTelefono.getText().toString();
        String documentoIdentidad = editDocumentoIdentidad.getText().toString();
        String direccion = editDireccion.getText().toString();

    }
}
