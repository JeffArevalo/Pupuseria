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

public class MunicipioActualizarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDMunicipio;
    EditText editIDMunicipio2;
    EditText editnomMunicipio;
    Spinner spinnerDepartamento;
    List<Integer> listIDDepartamento = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_actualizar);


        helper = new ControlDBPupuseria(this);
        editIDMunicipio= (EditText) findViewById(R.id.editIDMunicipio);
        editIDMunicipio2= (EditText) findViewById(R.id.editIDMunicipio2);
        editnomMunicipio= (EditText) findViewById(R.id.editnomMunicipio);
        spinnerDepartamento = findViewById(R.id.spinnerDepartamento);

        SpinnerDepartamento();
    }
    public void editarMunicipio(View v) {
        if(editIDMunicipio.getText().toString().isEmpty() ) {
            Toast.makeText(this, "No ha ingresado ningun ID de municipio", Toast.LENGTH_SHORT).show();
        }
        else{
            helper.abrir();
            Municipio municipio = helper.consultarMunicipio(Integer.parseInt(editIDMunicipio.getText().toString()));
            helper.cerrar();
            if (municipio == null)
                Toast.makeText(this, "El municipio con ID " + Integer.parseInt(editIDMunicipio.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIDMunicipio2.setText(String.valueOf(municipio.getIdMunicipio()));
                editnomMunicipio.setText(String.valueOf(municipio.getMunicipio()));
            }
        }
    }


    public void actualizarMunicipio(View v) {
        if (editIDMunicipio.getText().toString().isEmpty() || listIDDepartamento.size() == 0 ||
                editIDMunicipio2.getText().toString().isEmpty() || editnomMunicipio.getText().toString().isEmpty()) {
            Toast.makeText(MunicipioActualizarActivity.this, "Ingresar datos obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            String idmunicipio = editIDMunicipio.getText().toString();
            String municipio = editnomMunicipio.getText().toString();
            int idMunicipio = Integer.parseInt(idmunicipio);
            int idDepartamento = listIDDepartamento.get(spinnerDepartamento.getSelectedItemPosition());
            String regInsertados;

            Municipio mun = new Municipio();
            mun.setIdMunicipio(idMunicipio);
            mun.setMunicipio(municipio);
            mun.setIdDepartamento(idDepartamento);

            helper.abrir();
            regInsertados = helper.actualizarMunicipio(mun);
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