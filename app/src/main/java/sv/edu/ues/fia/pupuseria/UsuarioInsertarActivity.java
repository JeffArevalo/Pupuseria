package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UsuarioInsertarActivity extends AppCompatActivity {

    EditText editIdUsuario, editIdDireccion, editIdDocumentoIdentidad, editNombreUsuario, editApellidoUsuario, editTelefonoUsuario;
    Button btnInsertarUsuario;
    ControlDBPupuseria helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_insertar);

        helper = new ControlDBPupuseria(this);

        editIdUsuario = findViewById(R.id.editIdUsuario);
        editIdDireccion = findViewById(R.id.editIdDireccion);
        editIdDocumentoIdentidad = findViewById(R.id.editIdDocumentoIdentidad);
        editNombreUsuario = findViewById(R.id.editNombreUsuario);
        editApellidoUsuario = findViewById(R.id.editApellidoUsuario);
        editTelefonoUsuario = findViewById(R.id.editTelefonoUsuario);
        btnInsertarUsuario = findViewById(R.id.btnInsertarUsuario);

        btnInsertarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idUsuario = Integer.parseInt(editIdUsuario.getText().toString());
                int idDireccion = Integer.parseInt(editIdDireccion.getText().toString());
                int idDocumentoIdentidad = Integer.parseInt(editIdDocumentoIdentidad.getText().toString());
                String nombreUsuario = editNombreUsuario.getText().toString();
                String apellidoUsuario = editApellidoUsuario.getText().toString();
                String telefonoUsuario = editTelefonoUsuario.getText().toString();

                String regInsertados;
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(idUsuario);
                usuario.setIdDireccion(idDireccion);
                usuario.setIdDocumentoIdentidad(idDocumentoIdentidad);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setApellidoUsuario(apellidoUsuario);
                usuario.setTelefonoUsuario(telefonoUsuario);

                helper.abrir();
                regInsertados = helper.insertarUsuario(usuario);
                helper.cerrar();

                Toast.makeText(UsuarioInsertarActivity.this, regInsertados, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

