package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoIdentidadActualizarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editTextIdDocumentoIdentidad;
    EditText editTextTipoDocumentoIdentidad;
    EditText editTextNumeroDocumentoIdentidad;
    Button buttonActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_identidad_actualizar);

        helper = new ControlDBPupuseria(this);

        editTextIdDocumentoIdentidad = findViewById(R.id.editTextIdDocumentoIdentidad);
        editTextTipoDocumentoIdentidad = findViewById(R.id.editTextTipoDocumentoIdentidad);
        editTextNumeroDocumentoIdentidad = findViewById(R.id.editTextNumeroDocumentoIdentidad);
        buttonActualizar = findViewById(R.id.buttonActualizar);

        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDocumentoIdentidad();
            }
        });
    }

    public void actualizarDocumentoIdentidad() {
        String idDocIdentidadStr = editTextIdDocumentoIdentidad.getText().toString();
        String tipoDocIdentidad = editTextTipoDocumentoIdentidad.getText().toString();
        String numeroDocIdentidad = editTextNumeroDocumentoIdentidad.getText().toString();

        if (idDocIdentidadStr.isEmpty() || tipoDocIdentidad.isEmpty() || numeroDocIdentidad.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        int idDocIdentidad = Integer.parseInt(idDocIdentidadStr);
        Documento_Identidad documentoIdentidad = new Documento_Identidad(idDocIdentidad, tipoDocIdentidad, numeroDocIdentidad);

        helper.abrir();
        String resultado = helper.actualizarDocumentoIdentidad(documentoIdentidad);
        helper.cerrar();

        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();

        // Limpiar los campos después de actualizar
        editTextIdDocumentoIdentidad.setText("");
        editTextTipoDocumentoIdentidad.setText("");
        editTextNumeroDocumentoIdentidad.setText("");
    }
}
