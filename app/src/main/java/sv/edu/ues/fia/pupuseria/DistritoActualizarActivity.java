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

public class DistritoActualizarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDDistrito;
    EditText editIDDistrito2;
    EditText editnomDistrito;
    Spinner spinnerMunicipio;
    List<Integer> listIDMunicipio = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrito_actualizar);

        helper = new ControlDBPupuseria(this);
        editIDDistrito= (EditText) findViewById(R.id.editIDDistrito);
        editIDDistrito2= (EditText) findViewById(R.id.editIDDistrito2);
        editnomDistrito= (EditText) findViewById(R.id.editnomDistrito);
        spinnerMunicipio = findViewById(R.id.spinnerMunicipio);

        SpinnerMunicipio();
    }
    public void editarDistrito(View v) {
        if(editIDDistrito.getText().toString().isEmpty() ) {
            Toast.makeText(this, "No ha ingresado ningun ID de distrito", Toast.LENGTH_SHORT).show();
        }
        else{
            helper.abrir();
            Distrito distrito = helper.consultarDistrito(Integer.parseInt(editIDDistrito.getText().toString()));
            helper.cerrar();
            if (distrito == null)
                Toast.makeText(this, "El distrito con ID " + Integer.parseInt(editIDDistrito.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIDDistrito2.setText(String.valueOf(distrito.getIdDistrito()));
                editnomDistrito.setText(String.valueOf(distrito.getDistrito()));
            }
        }
    }


    public void actualizarDistrito(View v) {
        if (editIDDistrito.getText().toString().isEmpty() || listIDMunicipio.size() == 0 ||
                editIDDistrito2.getText().toString().isEmpty() || editnomDistrito.getText().toString().isEmpty()) {
            Toast.makeText(DistritoActualizarActivity.this, "Ingresar datos obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            String iddistrito = editIDDistrito.getText().toString();
            String distrito = editnomDistrito.getText().toString();
            int idDistrito = Integer.parseInt(iddistrito);
            int idMunicipio = listIDMunicipio.get(spinnerMunicipio.getSelectedItemPosition());
            String regInsertados;

            Distrito dis = new Distrito();
            dis.setIdDistrito(idDistrito);
            dis.setDistrito(distrito);
            dis.setIdMunicipio(idMunicipio);

            helper.abrir();
            regInsertados = helper.actualizarDistrito(dis);
            helper.cerrar();

            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }

    public void SpinnerMunicipio(){
        String sql = "SELECT ID_MUNICIPIO FROM MUNICIPIO";
        Cursor cursor = helper.llenarSpinner(sql);
        while (cursor.moveToNext()) {
            @SuppressLint("Range")
            int idMunicipio = cursor.getInt(cursor.getColumnIndex("ID_MUNICIPIO"));
            listIDMunicipio.add(idMunicipio);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listIDMunicipio);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMunicipio.setAdapter(adapter);
    }

    public void limpiarTexto(View v) {
        editIDDistrito.setText("");
        editnomDistrito.setText("");
    }
}