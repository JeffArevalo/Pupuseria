package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DepartamentoConsultarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDDepartamento;
    EditText editIDDepartamento2;
    EditText editnomDepartamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_consultar);

        helper = new ControlDBPupuseria(this);
        editIDDepartamento= (EditText) findViewById(R.id.editIDDepartamento);
        editnomDepartamento = (EditText) findViewById(R.id.editnomDepartamento);
        editIDDepartamento2 = (EditText) findViewById(R.id.editIDDepartamento2);
    }

    public void consultarDepartamento(View v) {
        helper.abrir();
        Departamento departamento = helper.consultarDepartamento(Integer.parseInt(editIDDepartamento.getText().toString()));
        helper.cerrar();
        if (departamento == null)
            Toast.makeText(this, "El departamento con ID " + Integer.parseInt(editIDDepartamento.getText().toString()) +
                    " no fue encontrado", Toast.LENGTH_LONG).show();
        else {
            editIDDepartamento2.setText(String.valueOf(departamento.getIdDepartamento()));
            editnomDepartamento.setText(departamento.getDepartamento());
        }
    }

    public void limpiarTexto(View v) {
        editIDDepartamento.setText("");
        editIDDepartamento2.setText("");
        editnomDepartamento.setText("");
    }
}