package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoIdentidadEliminarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editTextIdDocumentoIdentidad;
    Button buttonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_identidad_eliminar);

        helper = new ControlDBPupuseria(this);

        editTextIdDocumentoIdentidad = findViewById(R.id.editTextIdDocumentoIdentidad);
        buttonEliminar = findViewById(R.id.buttonEliminar);

        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarDocumentoIdentidad();
            }
        });
    }

    public void eliminarDocumentoIdentidad() {
        String idDocIdentidadStr = editTextIdDocumentoIdentidad.getText().toString();
        if (idDocIdentidadStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un ID de documento de identidad.", Toast.LENGTH_SHORT).show();
            return;
        }

        int idDocIdentidad = Integer.parseInt(idDocIdentidadStr);
        Documento_Identidad documentoIdentidad = new Documento_Identidad();
        documentoIdentidad.setIdDocumentoIdentidad(idDocIdentidad);

        helper.abrir();
        String resultado = helper.eliminarDocumentoIdentidad(documentoIdentidad);
        helper.cerrar();

        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();

        // Limpiar el campo después de eliminar
        editTextIdDocumentoIdentidad.setText("");
    }
}
