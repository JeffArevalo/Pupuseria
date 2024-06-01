package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorActualizarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdAdmin;

    EditText editIdAdminNew;
    EditText editNombreAdmin;
    EditText editApellidoAdmin;
    EditText editTelefonoAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_actualizar);
        helper = new ControlDBPupuseria(this);
        editIdAdmin = (EditText) findViewById(R.id.editIdAdminUpdt);
        editIdAdminNew = (EditText) findViewById(R.id.editIdAdminUpdt2);
        editNombreAdmin = (EditText) findViewById(R.id.editNomAdminUpdt);
        editApellidoAdmin = (EditText) findViewById(R.id.editApellidosAdminUpdt);
        editTelefonoAdmin = (EditText) findViewById(R.id.editTelAdminUpdt);
    }

    //Consulta en la base de datos los valores correspondientes al ID y los presenta en los edittext
    public void editarAdmin(View v) {
        try{
            if(editIdAdmin.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID Admin se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                helper.abrir();
                Administrador admiConsulta = helper.consultarAdministrador(Integer.parseInt(editIdAdmin.getText().toString()));
                helper.cerrar();
                if (admiConsulta == null) {
                    Toast.makeText(this, "Administrador con ID: " + Integer.parseInt(editIdAdmin.getText().toString()) + " no fue encontrado", Toast.LENGTH_LONG).show();
                } else {
                    //en este caso hay que considerar en caso un Id ya sea registrado es posible que haya un error
                    editIdAdminNew.setText(String.valueOf(admiConsulta.getId_administrador()));
                    editNombreAdmin.setText(admiConsulta.getNombre_administrador());
                    editApellidoAdmin.setText(admiConsulta.getApellido_administrador());
                    editTelefonoAdmin.setText(admiConsulta.getTelefono_administrador());
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Actualizar al traer datos", Toast.LENGTH_SHORT).show();
        }

    }
    public void actualizarAdministrador(View v) {
        try{
            if(editIdAdminNew.getText().toString().isEmpty()){
                Toast.makeText(this, "El nuevo valor de ID Admin se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                Administrador admiU = new Administrador();
                admiU.setId_administrador(Integer.parseInt(editIdAdminNew.getText().toString()));
                admiU.setNombre_administrador(editNombreAdmin.getText().toString());
                admiU.setApellido_administrador(editApellidoAdmin.getText().toString());
                admiU.setTelefono_administrador(editTelefonoAdmin.getText().toString());

                helper.abrir();
                String estado = helper.actualizarAdmininstrador(admiU);
                helper.cerrar();
                Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Actualizar al enviar nuevos datos", Toast.LENGTH_SHORT).show();
        }

    }

    public void limpiarTxtACo(View v){
        editIdAdmin.setText("");
        editIdAdminNew.setText("");
        editNombreAdmin.setText("");
        editApellidoAdmin.setText("");
        editTelefonoAdmin.setText("");
    }
}
