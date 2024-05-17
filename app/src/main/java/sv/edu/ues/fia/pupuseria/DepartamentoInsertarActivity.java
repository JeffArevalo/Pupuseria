package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DepartamentoInsertarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDDepartamento;
    EditText editnomDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_insertar);
        helper = new ControlDBPupuseria(this);
        editIDDepartamento = (EditText) findViewById(R.id.editIDDepartamento2);
        editnomDepartamento = (EditText) findViewById(R.id.editnomDepartamento);
    }

    public void insertarDepartamento(View v) {
        String iddepto = editIDDepartamento.getText().toString();
        int idDepartamento = Integer.parseInt(iddepto);
        String nomdepto = editnomDepartamento.getText().toString();
        String regInsertados;

        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(idDepartamento);
        departamento.setDepartamento(nomdepto);
        helper.abrir();
        regInsertados = helper.insertarDepartamento(departamento);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editIDDepartamento.setText("");
        editnomDepartamento.setText("");
    }
}