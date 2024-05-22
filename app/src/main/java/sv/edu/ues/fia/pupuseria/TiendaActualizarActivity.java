package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TiendaActualizarActivity extends Activity {

    ControlDBPupuseria helper;

    EditText editIdDir;
    EditText editIdTienda;
    EditText editIdDirNew;
    EditText editIdTiendaNew;
    EditText editIdAdminNew;
    EditText editNomTiendaNew;
    EditText editTelTiendaNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_actualizar);
        //generar objeto de la BD
        helper=new ControlDBPupuseria(this);
        //generar asignaciones de controles a variables
        editIdDir = (EditText) findViewById(R.id.editIdDirUpdt1);
        editIdTienda = (EditText) findViewById(R.id.editIdTiendaUpdt);
        editIdTiendaNew = (EditText) findViewById(R.id.editIdTiendaUpdt2);
        editIdDirNew = (EditText) findViewById(R.id.editIdDIrUpdt2);
        editIdAdminNew = (EditText) findViewById(R.id.editIdAdminCargoUpdt);
        editNomTiendaNew = (EditText) findViewById(R.id.editNomTiendaUpdt);
        editTelTiendaNew = (EditText) findViewById(R.id.editTelTiendaUpdt);

    }

    public void editarCamposTienda(View v) {
        //ejecuta la porcion de codigo de consultar para traer los datos a los campos en pantalla y editar los necesarios
        helper.abrir();

        Tienda tiendaConsulta = helper.consultarTienda(Integer.parseInt(editIdTienda.getText().toString()), Integer.parseInt(editIdDir.getText().toString()));

        helper.cerrar();

        if(tiendaConsulta==null){
            Toast.makeText(this, "Tienda no registrada o no existe", Toast.LENGTH_LONG).show();
        }else{
            editIdTiendaNew.setText(String.valueOf(tiendaConsulta.getId_tienda()));
            editIdDirNew.setText(String.valueOf(tiendaConsulta.getId_direccion()));
            editNomTiendaNew.setText(tiendaConsulta.getNombre_tienda());
            editTelTiendaNew.setText(tiendaConsulta.getTelefono_tienda());
            editIdAdminNew.setText(String.valueOf(tiendaConsulta.getAdministrador()));
        }
    }

    public void actualizarTienda(View v) {
        Tienda tiendaUpdt = new Tienda();
        tiendaUpdt.setId_direccion(Integer.parseInt(editIdDirNew.getText().toString()));
        tiendaUpdt.setId_tienda(Integer.parseInt(editIdTiendaNew.getText().toString()));
        tiendaUpdt.setAdministrador(Integer.parseInt(editIdAdminNew.getText().toString()));
        tiendaUpdt.setNombre_tienda(editNomTiendaNew.getText().toString());
        tiendaUpdt.setTelefono_tienda(editTelTiendaNew.getText().toString());

        helper.abrir();
        String estado = helper.actualizarTienda(tiendaUpdt);
        helper.cerrar();

        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTxtActualizarTienda(View v) {
        editIdDir.setText("");
        editIdTienda.setText("");
        editIdTiendaNew.setText("");
        editIdDirNew.setText("");
        editNomTiendaNew.setText("");
        editTelTiendaNew.setText("");
        editIdAdminNew.setText("");
    }
}