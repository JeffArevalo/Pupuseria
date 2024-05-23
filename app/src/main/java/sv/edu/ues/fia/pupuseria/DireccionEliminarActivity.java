package sv.edu.ues.fia.pupuseria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DireccionEliminarActivity extends AppCompatActivity {

    EditText editIdDireccion;
    Button buttonEliminarDireccion;
    ControlDBPupuseria helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_eliminar);

        helper = new ControlDBPupuseria(this);

        editIdDireccion = findViewById(R.id.editIdDireccion);
        buttonEliminarDireccion = findViewById(R.id.buttonEliminarDireccion);

        buttonEliminarDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int idDireccion = Integer.parseInt(editIdDireccion.getText().toString());
                    helper.abrir();
                    String regEliminados = helper.eliminarDireccion(idDireccion);
                    helper.cerrar();

                    Toast.makeText(DireccionEliminarActivity.this, regEliminados, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(DireccionEliminarActivity.this, "Error en la conversión de datos", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(DireccionEliminarActivity.this, "Error al eliminar dirección", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}

