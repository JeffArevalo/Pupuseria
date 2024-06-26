package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorInsertarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdAdmin;
    EditText editNombreAdmin;
    EditText editApellidoAdmin;
    EditText editTelefonoAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_insertar);
        //referencias a objetos
        helper = new ControlDBPupuseria(this);
        editIdAdmin=(EditText)findViewById(R.id.editIdAdminInsert);
        editNombreAdmin=(EditText) findViewById(R.id.editNomAdminInsrt);
        editApellidoAdmin=(EditText) findViewById(R.id.editApellidosAdminInsrt);
        editTelefonoAdmin=(EditText) findViewById(R.id.editTelAdminInsrt);
    }

    public void insertarAdministrador(View v){
        try{
            if(editIdAdmin.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID Admin se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                //almacenamiento de datos de entrada
                String idAdmin=editIdAdmin.getText().toString();
                int idAdminC=Integer.parseInt(idAdmin);
                String nomAdmin=editNombreAdmin.getText().toString();
                String apellAdmin=editApellidoAdmin.getText().toString();
                String telAdmin=editTelefonoAdmin.getText().toString();
                //int com = Integer.parseInt(editTelefonoAdmin.getText().toString());
                String regAdminInsert;
                //Inicio de insercion
                Administrador admin = new Administrador();
                admin.setId_administrador(idAdminC);
                admin.setNombre_administrador(nomAdmin);
                admin.setApellido_administrador(apellAdmin);
                admin.setTelefono_administrador(telAdmin);

                helper.abrir();
                regAdminInsert=helper.insertarAdministrador(admin);
                helper.cerrar();
                Toast.makeText(this, regAdminInsert, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Insertar", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v){
        editIdAdmin.setText("");
        editNombreAdmin.setText("");
        editApellidoAdmin.setText("");
        editTelefonoAdmin.setText("");
    }

}