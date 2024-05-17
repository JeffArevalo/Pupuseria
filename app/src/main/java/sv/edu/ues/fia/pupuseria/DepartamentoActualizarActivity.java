package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DepartamentoActualizarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDDepartamento;
    EditText editIDDepartamento2;
    EditText editnomDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_actualizar);
        helper = new ControlDBPupuseria(this);
        editIDDepartamento= (EditText) findViewById(R.id.editIDDepartamento);
        editnomDepartamento = (EditText) findViewById(R.id.editnomDepartamento);
        editIDDepartamento2 = (EditText) findViewById(R.id.editIDDepartamento2);
    }

    public void editarDepartamento(View v) {
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
    public void actualizarDepartamento(View v) {
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(Integer.parseInt(editIDDepartamento.getText().toString()));
        departamento.setDepartamento(editnomDepartamento.getText().toString());
        helper.abrir();
        String estado = helper.actualizarDepartamento(departamento);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIDDepartamento.setText("");
        editIDDepartamento2.setText("");
        editnomDepartamento.setText("");
    }
}