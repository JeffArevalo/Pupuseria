package sv.edu.ues.fia.pupuseria;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DocumentoIdentidadConsultarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editTextIdDocumentoIdentidad;
    TextView textViewTipoDocumentoIdentidad;
    TextView textViewNumeroDocumentoIdentidad;
    Button buttonConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_identidad_consultar);

        helper = new ControlDBPupuseria(this);

        editTextIdDocumentoIdentidad = findViewById(R.id.editTextIdDocumentoIdentidad);
        textViewTipoDocumentoIdentidad = findViewById(R.id.textViewTipoDocumentoIdentidad);
        textViewNumeroDocumentoIdentidad = findViewById(R.id.textViewNumeroDocumentoIdentidad);
        buttonConsultar = findViewById(R.id.buttonConsultar);

        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarDocumentoIdentidad();
            }
        });
    }

    public void consultarDocumentoIdentidad() {
        String idDocIdentidadStr = editTextIdDocumentoIdentidad.getText().toString();
        if (idDocIdentidadStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un ID de documento de identidad.", Toast.LENGTH_SHORT).show();
            return;
        }

        int idDocIdentidad = Integer.parseInt(idDocIdentidadStr);
        helper.abrir();
        Documento_Identidad documentoIdentidad = helper.consultarDocumentoIdentidad(idDocIdentidad);
        helper.cerrar();

        if (documentoIdentidad != null) {
            textViewTipoDocumentoIdentidad.setText("Tipo de Documento: " + documentoIdentidad.getTipoDocumentoIdentidad());
            textViewNumeroDocumentoIdentidad.setText("Número de Documento: " + documentoIdentidad.getNumeroDocumentoIdentidad());
        } else {
            Toast.makeText(this, "Documento de identidad no encontrado.", Toast.LENGTH_SHORT).show();
            textViewTipoDocumentoIdentidad.setText("Tipo de Documento:");
            textViewNumeroDocumentoIdentidad.setText("Número de Documento:");
        }
    }
}
