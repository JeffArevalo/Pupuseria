package sv.edu.ues.fia.pupuseria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LicenciaEliminarActivity extends Activity {

    EditText edit_numero_licencia;
    //ControlBDee19001 controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licencia_eliminar);
        //controlhelper=new ControlBDee19001 (this);
        edit_numero_licencia=(EditText)findViewById(R.id.edit_numero_licencia);
    }

    public void eliminarLicencia(View v){
        String regEliminadas = " ";
        Licencia licencia=new Licencia();
        licencia.setNumero_licencia(edit_numero_licencia.getText().toString());
        //controlhelper.abrir();
        //regEliminadas=controlhelper.eliminar(alumno);
        //controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}