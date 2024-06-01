package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorEliminarActivity extends Activity {

    EditText editIdAdmin;
    ControlDBPupuseria controlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_eliminar);
        controlHelper = new ControlDBPupuseria(this);
        editIdAdmin=(EditText) findViewById(R.id.editIdAdminDlt);
    }

    public void eliminarAdminDel(View v){
        try{
            if(editIdAdmin.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID Admin se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                String regDel;
                Administrador adminD = new Administrador();
                adminD.setId_administrador(Integer.parseInt(editIdAdmin.getText().toString()));
                controlHelper.abrir();
                regDel=controlHelper.eliminarAdministrador(adminD);
                controlHelper.cerrar();
                Toast.makeText(this, regDel, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Eliminar", Toast.LENGTH_SHORT).show();
        }

    }

}