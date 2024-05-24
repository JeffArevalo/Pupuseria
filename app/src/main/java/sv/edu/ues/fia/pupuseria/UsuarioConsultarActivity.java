package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UsuarioConsultarActivity extends AppCompatActivity {

    EditText editIdUsuario, editIdDireccion, editIdDocumentoIdentidad, editNombreUsuario, editApellidoUsuario, editTelefonoUsuario;
    Button btnConsultarUsuario;
    ControlDBPupuseria helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_consultar);

        helper = new ControlDBPupuseria(this);

        editIdUsuario = findViewById(R.id.editIdUsuario);
        editIdDireccion = findViewById(R.id.editIdDireccion);
        editIdDocumentoIdentidad = findViewById(R.id.editIdDocumentoIdentidad);
        editNombreUsuario = findViewById(R.id.editNombreUsuario);
        editApellidoUsuario = findViewById(R.id.editApellidoUsuario);
        editTelefonoUsuario = findViewById(R.id.editTelefonoUsuario);
        btnConsultarUsuario = findViewById(R.id.btnConsultarUsuario);

        btnConsultarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idUsuario = editIdUsuario.getText().toString();
                helper.abrir();
                Usuario usuario = helper.consultarUsuario(Integer.parseInt(idUsuario));
                helper.cerrar();

                if (usuario == null) {
                    Toast.makeText(UsuarioConsultarActivity.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                } else {
                    editIdDireccion.setText(String.valueOf(usuario.getIdDireccion()));
                    editIdDocumentoIdentidad.setText(String.valueOf(usuario.getIdDocumentoIdentidad()));
                    editNombreUsuario.setText(usuario.getNombreUsuario());
                    editApellidoUsuario.setText(usuario.getApellidoUsuario());
                    editTelefonoUsuario.setText(usuario.getTelefonoUsuario());
                }
            }
        });
    }
}
