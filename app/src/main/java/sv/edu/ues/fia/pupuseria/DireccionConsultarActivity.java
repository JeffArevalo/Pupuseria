package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DireccionConsultarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdDireccion;
    TextView textDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_consultar);

        helper = new ControlDBPupuseria(this);
        editIdDireccion = findViewById(R.id.editIdDireccion);
        textDireccion = findViewById(R.id.textDireccion);

        Button buttonConsultar = findViewById(R.id.buttonConsultarDireccion);
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarDireccion();
            }
        });
    }

    public void consultarDireccion() {
        int idDireccion = Integer.parseInt(editIdDireccion.getText().toString());
        helper.abrir();
        Direccion direccion = helper.consultarDireccion(idDireccion);
        helper.cerrar();

        if (direccion == null) {
            Toast.makeText(this, "Direccion no encontrada", Toast.LENGTH_SHORT).show();
        } else {
            textDireccion.setText("ID Distrito: " + direccion.getIdDistrito() + "\nDireccion: " + direccion.getDireccion());
        }
    }
}
