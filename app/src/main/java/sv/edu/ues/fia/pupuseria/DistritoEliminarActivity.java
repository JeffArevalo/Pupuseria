package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DistritoEliminarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDDistrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrito_eliminar);

        helper =new ControlDBPupuseria(this);
        editIDDistrito= (EditText) findViewById(R.id.editIDDistrito);
    }

    public void eliminarDistrito(View v){
        String regEliminadas;
        Distrito distrito=new Distrito();
        distrito.setIdDistrito(Integer.parseInt(editIDDistrito.getText().toString()));
        helper.abrir();
        regEliminadas=helper.eliminarDistrito(distrito);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}