package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VentaEliminarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDVenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_eliminar);

        helper =new ControlDBPupuseria(this);
        editIDVenta=(EditText)findViewById(R.id.editIDVenta);
    }

    public void eliminarVenta(View v){
        String regEliminadas;
        Venta venta=new Venta();
        venta.setIdVenta(Integer.parseInt(editIDVenta.getText().toString()));
        helper.abrir();
        regEliminadas=helper.eliminarVenta(venta);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}