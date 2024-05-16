package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DepartamentoEliminarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDDepartamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_eliminar);
        helper =new ControlDBPupuseria(this);
        editIDDepartamento=(EditText)findViewById(R.id.editIDDepartamento);
    }
    public void eliminarDepartamento(View v){
        String regEliminadas;
        Departamento departamento=new Departamento();
        departamento.setIdDepartamento(Integer.parseInt(editIDDepartamento.getText().toString()));
        helper.abrir();
        regEliminadas=helper.eliminarDepartamento(departamento);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}