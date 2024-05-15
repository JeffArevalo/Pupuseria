package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DepartamentoInsertarActivity extends Activity {

    ControlDBPupuseria helper;

    EditText editnomDepartamento;
    EditText editIdDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_insertar);
        helper = new ControlDBPupuseria(this);
        editnomDepartamento = (EditText) findViewById(R.id.editnomDepartamento);
        editIdDepartamento = (EditText) findViewById(R.id.editIDDepartamento);
    }

    public void insertarDepartamento(View v) {
        String departamento=editnomDepartamento.getText().toString();
        int idDepartamento= Integer.parseInt(editIdDepartamento.getText().toString());
        String regInsertados;
        Departamento depto=new Departamento();
        depto.setIdDepartamento(idDepartamento);
        depto.setDepartamento(departamento);
        helper.abrir();
        regInsertados = helper.insertar(depto);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editnomDepartamento.setText("");
    }

}