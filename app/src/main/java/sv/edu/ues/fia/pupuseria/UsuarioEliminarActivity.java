package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UsuarioEliminarActivity extends AppCompatActivity {

    EditText editIdUsuario;
    Button btnEliminarUsuario;
    ControlDBPupuseria helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_eliminar);

        helper = new ControlDBPupuseria(this);

        editIdUsuario = findViewById(R.id.editIdUsuario);
        btnEliminarUsuario = findViewById(R.id.btnEliminarUsuario);

        btnEliminarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idUsuario = Integer.parseInt(editIdUsuario.getText().toString());
                helper.abrir();
                String regEliminados = helper.eliminarUsuario(idUsuario);
                helper.cerrar();

                Toast.makeText(UsuarioEliminarActivity.this, regEliminados, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
