package sv.edu.ues.fia.pupuseria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UsuarioActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        // Encuentra el botón de editar
        Button btnEditar = findViewById(R.id.btnEditar);

        // Agrega un OnClickListener al botón
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir la actividad de edición
                Intent intent = new Intent(UsuarioActivity.this, EditarUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }

}
