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

public class DistritoInsertarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDDistrito;
    EditText editnomDistrito;
    Spinner spinnerMunicipio;
    List<Integer> listIDMunicipio = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrito_insertar);

        helper = new ControlDBPupuseria(this);
        editIDDistrito= (EditText) findViewById(R.id.editIDDistrito);
        editnomDistrito= (EditText) findViewById(R.id.editnomDistrito);
        spinnerMunicipio = findViewById(R.id.spinnerMunicipio);

        SpinnerMunicipio();

    }
    public void insertarDistrito(View v) {
        String iddistrito= editIDDistrito.getText().toString();
        String distrito= editnomDistrito.getText().toString();
        int idDistrito = Integer.parseInt(iddistrito);
        int idMunicipio= listIDMunicipio.get(spinnerMunicipio.getSelectedItemPosition());
        String regInsertados;

        if (iddistrito.isEmpty()) {
            Toast.makeText(DistritoInsertarActivity.this, "Ingresar datos obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            Distrito dis = new Distrito();
            dis.setIdMunicipio(idMunicipio);
            dis.setIdDistrito(idDistrito);
            dis.setDistrito(distrito);

            helper.abrir();
            regInsertados=helper.insertarDistrito(dis);
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