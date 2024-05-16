package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MunicipioInsertarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDMunicipio;
    EditText editnomMunicipio;
    Spinner spinnerDepartamento;
    List<Integer> listIDDepartamento = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_insertar);

        helper = new ControlDBPupuseria(this);
        editIDMunicipio= (EditText) findViewById(R.id.editIDMunicipio);
        editnomMunicipio= (EditText) findViewById(R.id.editnomMunicipio);
        spinnerDepartamento = findViewById(R.id.spinnerDepartamento);

        SpinnerDepartamento();
    }

    public void insertarMunicipio(View v) {
        String idmunicipio= editIDMunicipio.getText().toString();
        String municipio= editnomMunicipio.getText().toString();
        int idMunicipio = Integer.parseInt(idmunicipio);
        int idDepartamento = listIDDepartamento.get(spinnerDepartamento.getSelectedItemPosition());
        String regInsertados;

        if (idmunicipio.isEmpty()) {
            Toast.makeText(MunicipioInsertarActivity.this, "Ingresar datos obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            Municipio mun = new Municipio();
            mun.setIdMunicipio(idMunicipio);
            mun.setMunicipio(municipio);
            mun.setIdDepartamento(idDepartamento);

            helper.abrir();
            regInsertados=helper.insertarMunicipio(mun);
            helper.cerrar();

            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }

    }

    public void SpinnerDepartamento(){
        String sql = "SELECT ID_DEPARTAMENTO FROM DEPARTAMENTO";
        Cursor cursor = helper.llenarSpinner(sql);
        while (cursor.moveToNext()) {
            @SuppressLint("Range")
            int idDepartamento = cursor.getInt(cursor.getColumnIndex("ID_DEPARTAMENTO"));
            listIDDepartamento.add(idDepartamento);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listIDDepartamento);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepartamento.setAdapter(adapter);
    }

    public void limpiarTexto(View v) {
        editIDMunicipio.setText("");
        editnomMunicipio.setText("");
    }
}