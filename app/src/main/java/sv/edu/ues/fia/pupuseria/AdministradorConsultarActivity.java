package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorConsultarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdAdmin;
    EditText editNombreAdmin;
    EditText editApellidoAdmin;
    EditText editTelefonoAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_consultar);
        helper=new ControlDBPupuseria(this);
        editIdAdmin=(EditText)findViewById(R.id.editIdAdminRetrv);
        editNombreAdmin=(EditText) findViewById(R.id.editNomAdminRetrv);
        editApellidoAdmin=(EditText) findViewById(R.id.editApellidosAdminRetrv);
        editTelefonoAdmin=(EditText) findViewById(R.id.editTelAdminRetrv);

    }

    public void consultarAdministrador(View v){
        try{//verifica si el control edittext del id esta vacio, si lo esta enviara un toast, sino realizara la consulta donde se revisara la tabla
            //para nuevamente verificar si existe el registro, si no existe envia un toast. pero si existe retornara los datos
            if(editIdAdmin.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID Admin se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else {
                helper.abrir();
                Administrador admiConsulta= helper.consultarAdministrador(Integer.parseInt(editIdAdmin.getText().toString()));
                helper.cerrar();
                if(admiConsulta==null){
                    Toast.makeText(this, "Administrador con ID: " + Integer.parseInt(editIdAdmin.getText().toString()) + " no fue encontrado", Toast.LENGTH_LONG).show();
                }else{
                    editNombreAdmin.setText(admiConsulta.getNombre_administrador());
                    editApellidoAdmin.setText(admiConsulta.getApellido_administrador());
                    editTelefonoAdmin.setText(admiConsulta.getTelefono_administrador());
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Consultar", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTxtCA(View v){
        editIdAdmin.setText("");
        editNombreAdmin.setText("");
        editApellidoAdmin.setText("");
        editTelefonoAdmin.setText("");
    }
}