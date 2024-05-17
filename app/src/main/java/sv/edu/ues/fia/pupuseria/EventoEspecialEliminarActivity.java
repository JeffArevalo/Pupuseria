package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoEspecialEliminarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDEventoEspecial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_especial_eliminar);

        helper =new ControlDBPupuseria(this);
        editIDEventoEspecial=(EditText)findViewById(R.id.editIDEventoEspecial);
    }

    public void eliminarEventoEspecial(View v){
        String regEliminadas;
        EventoEspecial evento=new EventoEspecial();
        evento.setIdEventoEspecial(Integer.parseInt(editIDEventoEspecial.getText().toString()));
        helper.abrir();
        regEliminadas=helper.eliminarEventoEspecial(evento);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}