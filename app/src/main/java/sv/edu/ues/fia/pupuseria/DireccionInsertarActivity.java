package sv.edu.ues.fia.pupuseria;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DireccionInsertarActivity extends AppCompatActivity {

    private EditText editTextDireccion;
    private Spinner spinnerTipoDireccion;
    private Button buttonGuardarDireccion;
    private ControlDBPupuseria controlDB; // Instancia de la clase para interactuar con la base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_insertar);

        // Inicializar instancia de la base de datos
        controlDB = new ControlDBPupuseria(this);

        // Inicializar vistas
        editTextDireccion = findViewById(R.id.editTextDireccion);
        spinnerTipoDireccion = findViewById(R.id.spinnerTipoDireccion);
        buttonGuardarDireccion = findViewById(R.id.buttonGuardarDireccion);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tipos_direccion,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoDireccion.setAdapter(adapter);

        buttonGuardarDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDireccion();
            }
        });
    }

    private void guardarDireccion() {
        // Obtener los valores ingresados por el usuario
        String direccion = editTextDireccion.getText().toString();
        String tipoDireccion = spinnerTipoDireccion.getSelectedItem().toString();

        // Crear una instancia de la clase Direccion con los datos ingresados
        Direccion nuevaDireccion = new Direccion(0, 0, direccion, tipoDireccion);

        // Insertar la dirección en la base de datos
        String mensaje = controlDB.insertarDireccion(nuevaDireccion);

        // Mostrar un mensaje al usuario con el resultado de la inserción
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

}
