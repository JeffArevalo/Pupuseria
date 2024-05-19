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
        String regDel;
        Administrador adminD = new Administrador();
        adminD.setId_administrador(Integer.parseInt(editIdAdmin.getText().toString()));
        controlHelper.abrir();
        regDel=controlHelper.eliminarAdministrador(adminD);
        controlHelper.cerrar();
        Toast.makeText(this, regDel, Toast.LENGTH_SHORT).show();
    }

}